//import lombok.*;

/**
 * @author Kir
 * Created on 19.10.2020
 */
//
//@Data
//@ToString
//@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
public class Result {
    private String model;
    private int power;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
