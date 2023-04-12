package web.dao;



import org.springframework.stereotype.Repository;
import web.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;



@Repository
public class DaoUserImp implements DaoUser {


    @PersistenceContext
    private EntityManager entityManager;
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }
    public void addUser(User user) {
        getEntityManager().persist(user);
    }

    public List<User> getAllUsers() {
        return getEntityManager().createQuery("From User").getResultList();
    }
    @Override
    public void deleteUser(Long id) {
        getEntityManager()
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }
    public void edit(User user) {
        getEntityManager().merge(user);
    }
    public User getUserById(Long id) {
        return getEntityManager().find(User.class, id);
    }
}

