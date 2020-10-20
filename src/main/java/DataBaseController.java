import lombok.NoArgsConstructor;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author Kir
 * Created on 19.10.2020
 */

/**
 * USELESS right now
 */
@ManagedBean
@SessionScoped
@NoArgsConstructor
public class DataBaseController {
    private SessionFactory factory;
    private DAO<ResponseObject, Integer> resultDao;

    @PostConstruct
    public void init() {
        factory = new Configuration().configure().buildSessionFactory();
        resultDao = new ResponseObjectDAO(factory);
    }

    public DAO<ResponseObject, Integer> getResultDao() {
        return resultDao;
    }

    public void setResultDao(DAO<ResponseObject, Integer> resultDao) {
        this.resultDao = resultDao;
    }
}
