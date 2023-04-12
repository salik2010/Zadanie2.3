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

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public List<User> getAllUsers() {
        return entityManager.createQuery("From User").getResultList();
    }
    @Override
    public void deleteUser(Long id) {
        entityManager
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }
    public void edit(User user) {
        entityManager.merge(user);
    }
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }
}

