package fr.istic.taa.jaxrs.dao.generic;
import fr.istic.taa.jaxrs.domain.*;
import java.util.List;

public class UserDAO extends AbstractJpaDao<Long, User> {

    public UserDAO() {
        super(User.class);
    }

    public List<User> getAllUser() {
        String query = "select e from User as e";
        return this.entityManager.createQuery(query).getResultList();
    }

    public User findByName(String name) {
        return entityManager.createQuery("select e from User e where e.name=:name",User.class).setParameter("name", name).getSingleResult();
    }

    public Worker getBestWorkerName() {
        String query = "select e from Worker as e where e.rate = (select max(e.rate) from User as" +
                " e)";

        //String query = "select e from Worker as e ";
        return  this.entityManager.createQuery(query,Worker.class).getSingleResult();
    }
}