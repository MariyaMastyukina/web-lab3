import com.sun.istack.internal.NotNull;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
///**
// * @author Kir
// * Created on 19.10.2020
// */
//
//public class ResponseObjectDAO implements DAO<ResponseObject, Integer> {
//    /**
//     * Connection factory to database.
//     */
//    private final SessionFactory factory;
//
//    public ResponseObjectDAO(@NotNull final SessionFactory factory) {
//        this.factory = factory;
//    }
//
//    /**
//     * Create new result in results table.
//     *
//     * @param responseObject for add.
//     */
//    @Override
//    public void create(@NotNull final ResponseObject responseObject) {
//        try (final Session session = factory.openSession()) {
//
//            session.beginTransaction();
//
//            session.save(responseObject);
//
//            session.getTransaction().commit();
//        }
//    }
//
//    /**
//     * get result
//     *
//     * @param key for select.
//     * @return responseObject with param model.
//     */
//    @Override
//    public ResponseObject read(@NotNull final Integer key) {
//        try (final Session session = factory.openSession()) {
//
//            final ResponseObject responseObject = session.get(ResponseObject.class, key);
//
//            return responseObject != null ? responseObject : new ResponseObject();
//        }
//    }
//
//    /**
//     *
//     *
//     * @param responseObject new state.
//     */
//    @Override
//    public void update(@NotNull final ResponseObject responseObject) {
//        try (Session session = factory.openSession()) {
//
//            session.beginTransaction();
//
//            session.update(responseObject);
//
//            session.getTransaction().commit();
//        }
//    }
//
//    /**
//     *
//     * @param responseObject for delete.
//     */
//    @Override
//    public void delete(@NotNull final ResponseObject responseObject) {
//        try (Session session = factory.openSession()) {
//
//            session.beginTransaction();
//
//            session.delete(responseObject);
//
//            session.getTransaction().commit();
//        }
//    }
//}
