import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Kir
 * Created on 20.10.2020
 */
@ManagedBean(name = "resultBean", eager = true)
@SessionScoped
@NoArgsConstructor
public class ResultBean implements Serializable {
    private ResponseObject responseObject;
    private List<ResponseObject> responses;
    private DataBaseController dbController;

    @PostConstruct
    public void init() {
        responseObject = new ResponseObject();
        responses = new ArrayList<>();
        dbController = new DataBaseController();
        dbController.init();
        //init responses
    }

    public List<ResponseObject> getResponses() {
        return responses;
    }

    public void setResponses(List<ResponseObject> responses) {
        this.responses = responses;
    }

    public ResponseObject getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(ResponseObject responseObject) {
        this.responseObject = responseObject;
    }

    public void execute() {
        //TODO forward to db controller then get response and update *.xhtml
        FacesContext facesContext = FacesContext.getCurrentInstance();
        System.out.println("execute method");
        System.out.println(responseObject.getR_value() + " = R VALUE");
        //if (validate(responseObject.getX_value(), responseObject.getY_value(), responseObject.getR_value())) {
            long script_time = System.currentTimeMillis();
            responseObject.setCurrent_time(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
            String res = checkODZ(responseObject.getX_value(), responseObject.getY_value(), responseObject.getR_value()) ? "TRUE" : "FALSE";
            responseObject.setHit_result(res);
            responseObject.setScript_time(System.currentTimeMillis() - script_time);
            responseObject.setJsessionid(facesContext.getExternalContext().getSessionId(false));
            try {
                dbController.getResultDao().create(responseObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
            responses.add(responseObject);
            responseObject = new ResponseObject();
            System.out.println(responses.size());
        for (ResponseObject s:responses) {
            System.out.println(s.toString());
        }
//        } else {
//            //TODO sth
//        }
    }

    public void remove() {
        //TODO use client session (through jsp session and manage bean)
        Iterator<ResponseObject> respIterator = responses.iterator();
        System.out.println("Remove method");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        while (respIterator.hasNext()) {
            ResponseObject cur = respIterator.next();
            //if (cur.getJsessionid().equals(facesContext.getExternalContext().getSessionId(false))) {
                try {
                    //dbController.getResultDao().delete(cur);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                respIterator.remove();
            //}
        }

    }

    private boolean validate(Double x, Double y, int r) {
        int[] a = {1, 2, 3, 4, 5};
        return (x > -5 && x < 5 && y > -3 && y < 5 && Arrays.asList(a).contains(r));
    }

    private boolean checkODZ(double x, double y, int r) {
        System.out.println(x + "; " + y + "; " + r);
        if (x >= 0 && y >= 0)
            return checkFirstQ(x, y, r);
        else if (x <= 0 && y <= 0)
            return checkThirdQ(x, y, r);
        else if (x >= 0 && y <= 0)
            return checkFourthQ(x, y, r);
        else
            return checkSecondQ(x, y, r);
    }

    private boolean checkFirstQ(double x, double y, int r) {
        return (x * x + y * y <= r * r);
    }

    private boolean checkSecondQ(double x, double y, int r) {
        return (x < (double) r / 2 && y < r);
    }

    private boolean checkThirdQ(double x, double y, int r) {
        return false;
    }

    private boolean checkFourthQ(double x, double y, int r) {
        return (x - y <= r);
    }
}
