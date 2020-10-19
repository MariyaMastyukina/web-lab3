import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Kir
 * Created on 19.10.2020
 */

public class ApplicationDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        DAO<Result, String> resultDao = new ResultDAO(factory);
        final Result result = new Result();
        result.setModel("engine_model_04");
        result.setPower(12345);
        resultDao.create(result);
        final Result res = resultDao.read("engine_model_03");
        System.out.println(res.toString());
        factory.close();
    }
}
