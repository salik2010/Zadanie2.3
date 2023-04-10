package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.DaoUserImp;
import web.entity.User;

import java.util.List;

@Service
public class UserServicesImp implements UserServices{

    private final DaoUserImp daoUserImp;

    public UserServicesImp(DaoUserImp daoUserImp) {
        this.daoUserImp = daoUserImp;
    }

    public List<User> from(int count){
        return daoUserImp.from(count);
    }
}
