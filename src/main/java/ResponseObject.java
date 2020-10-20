
import lombok.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Kir
 * Created on 19.10.2020
 */

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ManagedBean
@SessionScoped

//Model
public class ResponseObject {

    private int id;
    private double x_value;
    private double y_value;
    private int r_value;
    private double script_time;
    private double current_time;
    private String jsessionid;

    public String getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(String jsessionid) {
        this.jsessionid = jsessionid;
    }

    public double getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(double current_time) {
        this.current_time = current_time;
    }

    private String hit_result;

    public double getScript_time() {
        return script_time;
    }

    public void setScript_time(double script_time) {
        this.script_time = script_time;
    }

    public String getHit_result() {
        return hit_result;
    }

    public void setHit_result(String hit_result) {
        this.hit_result = hit_result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getY_value() {
        return y_value;
    }

    public void setY_value(double y_value) {
        this.y_value = y_value;
    }

    public double getX_value() {
        return x_value;
    }

    public void setX_value(double x_value) {
        this.x_value = x_value;
    }

    public int getR_value() {
        return r_value;
    }

    public void setR_value(int r_value) {
        this.r_value = r_value;
    }

    @Override
    public String toString() {
        return "<tr>" +
                "<td>" + this.x_value + "</td>" +
                "<td>" + this.y_value + "</td>" +
                "<td>" + this.r_value + "</td>" +
                "<td>" + this.current_time + "</td>" +
                "<td>" + this.script_time + "</td>" +
                "<td>" + this.hit_result + "</td>" +
                "</tr>";
    }
}
