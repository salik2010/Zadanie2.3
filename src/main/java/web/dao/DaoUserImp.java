package web.dao;

import org.springframework.stereotype.Component;
import web.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DaoUserImp implements DaoUser {

    private final List<User> users;
    {
        users = new ArrayList<>();
        users.add(new User(1L,"dima","Samoylenko",30,"Partssezd"));
        users.add(new User(2L,"dima2","Samoylenko2",32,"Partssezd"));
        users.add(new User(3L,"dima3","Samoylenko3",33,"Partssezd"));
        users.add(new User(4L,"dima4","Samoylenko4",34,"Partssezd"));
        users.add(new User(5L,"dima5","Samoylenko5",35,"Partssezd"));
    }
    public List<User> from(int count) {
         return users.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        
        users.add(user);
    }
//    public daoUser(List<User> users) {
//        this.users = users;
//    }
}
