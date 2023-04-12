package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.DaoUserImp;
import web.entity.User;

import java.util.List;

@Service
@Transactional
public class UserServicesImp implements UserServices{



    private DaoUserImp daoUserImp;

    @Autowired
    public void setUserDao(DaoUserImp daoUserImp) {
        this.daoUserImp = daoUserImp;
    }

    @Override
    public void addUser(User user) {
        daoUserImp.addUser(user);
    }
    public List<User> getAllUsers(){
        return daoUserImp.getAllUsers();
    }
    public void deleteUser(Long id){
        daoUserImp.deleteUser(id);
    }
    public void edit(User user) {
        daoUserImp.edit(user);
    }
    public User getUserById(Long id) {
        return daoUserImp.getUserById(id);
    }
}
