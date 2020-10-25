import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;

/**
 * @author Kir
 * Created on 19.10.2020
 */

/**
 * USELESS right now
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataBaseController implements Serializable {
    private SessionFactory factory;
    private DAO<ResponseObject, Integer> resultDao;

    public void init() {
        factory = new Configuration().configure().buildSessionFactory();
        resultDao = new ResponseObjectDAO(factory);
        System.out.println("Init of DB");
    }

    public DAO<ResponseObject, Integer> getResultDao() {
        return resultDao;
    }

    public void setResultDao(DAO<ResponseObject, Integer> resultDao) {
        this.resultDao = resultDao;
    }

}
