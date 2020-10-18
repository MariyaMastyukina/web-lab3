import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kir
 * Created on 17.10.2020
 */

@ManagedBean
@ViewScoped
@Data
public class ExampleBean {

    private Employee newEmployee = new Employee();

    private List<Employee> employees = new ArrayList<Employee>();


    public void addEmployee() {
        employees.add(newEmployee);
        newEmployee = new Employee();
    }
}
