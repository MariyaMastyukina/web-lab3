



import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.math.BigDecimal;

@FacesValidator("x_validator")
public class XValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        try {
            BigDecimal x_value = new BigDecimal(o.toString());
            BigDecimal min = new BigDecimal(-5);
            BigDecimal max = new BigDecimal(5);
            if (x_value.compareTo(max) >= 0 || x_value.compareTo(min) <= 0)
                throw new ValidatorException(new FacesMessage("Введенные данные не входят в диапозон значений Х"));
        } catch (NumberFormatException | NullPointerException e) {
            throw new ValidatorException(new FacesMessage("Неверный формат введенных значений для Х"));
        }
    }
}

