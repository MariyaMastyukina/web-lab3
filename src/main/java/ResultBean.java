import lombok.NoArgsConstructor;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kir
 * Created on 20.10.2020
 */
@ManagedBean
@SessionScoped
@NoArgsConstructor
public class ResultBean {

    private ResponseObject responseObject;
    private List<ResponseObject> responses;

    @PostConstruct
    public void init() {
        responseObject = new ResponseObject();
        responses = new ArrayList<>();
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

    private void execute() {
        //TODO validation
        //TODO forward to db controller then get response and update *.xhtml
    }

    private void remove(){
        //TODO use client session (through jsp session and manage bean)
    }
}
