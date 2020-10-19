import com.sun.istack.internal.NotNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author Kir
 * Created on 19.10.2020
 */

public class ResultDAO implements DAO<Result, String> {
    /**
     * Connection factory to database.
     */
    private final SessionFactory factory;

    public ResultDAO(@NotNull final SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Create new engine in engines table.
     *
     * @param result for add.
     */
    @Override
    public void create(@NotNull final Result result) {
        try (final Session session = factory.openSession()) {

            session.beginTransaction();

            session.save(result);

            session.getTransaction().commit();
        }
    }

    /**
     * Get engine by model.
     *
     * @param model for select.
     * @return engine with param model.
     */
    @Override
    public Result read(@NotNull final String model) {
        try (final Session session = factory.openSession()) {

            final Result result = session.get(Result.class, model);

            return result != null ? result : new Result();
        }
    }

    /**
     * Update engine state.
     *
     * @param result new state.
     */
    @Override
    public void update(@NotNull final Result result) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.update(result);

            session.getTransaction().commit();
        }
    }

    /**
     * Delete engine.
     *
     * @param result for delete.
     */
    @Override
    public void delete(@NotNull final Result result) {
        try (Session session = factory.openSession()) {

            session.beginTransaction();

            session.delete(result);

            session.getTransaction().commit();
        }
    }
}
