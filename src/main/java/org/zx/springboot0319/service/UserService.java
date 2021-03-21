package org.zx.springboot0319.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zx.springboot0319.dao.UserDao;
import org.zx.springboot0319.model.User;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public void addUser(User user){
        userDao.save(user);
    }
    public void deleteUser(String id){
        userDao.deleteById(id);
    }
}
