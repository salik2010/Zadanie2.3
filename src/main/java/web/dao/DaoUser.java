package web.dao;

import web.entity.User;

import java.util.List;

public interface DaoUser {
    public List<User> from(int count);

    void save(User user);
}
