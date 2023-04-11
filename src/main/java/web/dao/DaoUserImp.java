package web.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DaoUserImp implements DaoUser {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
    private static int count;
    private final List<User> users;
    {

        users = new ArrayList<>();
        users.add(new User((long) ++count,"dima","Samoylenko",30,"Partssezd"));
        users.add(new User((long) ++count,"dima2","Samoylenko2",32,"Partssezd"));
        users.add(new User((long) ++count,"dima3","Samoylenko3",33,"Partssezd"));
        users.add(new User((long) ++count,"dima4","Samoylenko4",34,"Partssezd"));
        users.add(new User((long) ++count,"dima5","Samoylenko5",35,"Partssezd"));
        //entityManager.persist(new User(1L,"dd","fff",55,"66"));
    }



    public List<User> from(int count) {
         return users.stream().limit(count).collect(Collectors.toList());
    }

    @Override

    public void save(User user) {
        //user.setId((long) 1);
         entityManager.persist(user);
        //users.add(user);
    }
//    public daoUser(List<User> users) {
//        this.users = users;
//    }
}
