package com.ly.service;

import com.ly.dao.UserDao;
import com.ly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ly on 2017/10/8 18:11
 */
@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUser(String username, String password) {
        return userDao.getUserByName(username, password);
    }
    
    public User register(User user) {
        userDao.register(user);
        return userDao.getUserByName(user.getUsername(), user.getPassword());
    }
}
