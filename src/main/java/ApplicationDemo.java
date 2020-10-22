import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kir
 * Created on 19.10.2020
 */

public class ApplicationDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<ResponseObject, Integer> resultDao = new ResponseObjectDAO(factory);
        final ResponseObject responseObject = new ResponseObject();
        responseObject.setX_value(1);
        responseObject.setY_value(1);
        responseObject.setR_value(1);
        responseObject.setScript_time(123);;
        responseObject.setHit_result("TRUE");
        responseObject.setJsessionid("1234t");
        resultDao.create(responseObject);
        final ResponseObject res = resultDao.read(1);
        System.out.println(res.toString());
        factory.close();
    }
}
