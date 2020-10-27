import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.math.BigDecimal;

@FacesConverter("y_converter")
public class YConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        try {
            if (!s.equals("")) {
                BigDecimal y_value = new BigDecimal(s);
                return y_value;
            }
            else {
                return null;
            }
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage("Неверный формат для Y"));
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return o.toString();
    }
}
