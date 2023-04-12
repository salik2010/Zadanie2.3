package web.service;

import web.entity.User;

import java.util.List;

public interface UserServices {
    public void addUser(User user);
    public List<User> getAllUsers();
    public void deleteUser(Long id);
    public void edit(User user);
    public User getUserById(Long id);
}
