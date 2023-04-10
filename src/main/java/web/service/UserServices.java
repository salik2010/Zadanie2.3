package web.service;

import web.entity.User;

import java.util.List;

public interface UserServices {
    public List<User> from(int count);
}
