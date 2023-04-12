package web.dao;

import web.entity.User;

import java.util.List;

public interface DaoUser {
    public void deleteUser(Long id);
    public List<User> getAllUsers();
    public void addUser(User user);
    public void edit(User user);
    public User getUserById(Long id);
}
