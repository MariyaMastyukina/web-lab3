import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.math.BigDecimal;

@FacesValidator("y_validator")
public class YValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            BigDecimal y_value = new BigDecimal(o.toString());
            BigDecimal min = new BigDecimal(-3);
            BigDecimal max = new BigDecimal(5);
            if (y_value.compareTo(max) >= 0 || y_value.compareTo(min) <= 0)
                throw new ValidatorException(new FacesMessage("Введенные данные не входят в диапозон значений Х"));
        } catch (NumberFormatException | NullPointerException e) {
            throw new ValidatorException(new FacesMessage("Неверный формат введенных значений для Х"));
        }
    }
}
