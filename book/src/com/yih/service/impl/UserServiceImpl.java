package com.yih.service.impl;

import com.yih.dao.UserDao;
import com.yih.dao.impl.UserDaoImpl;
import com.yih.pojo.User;
import com.yih.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {

        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {

           return false;
        }

        return true;

    }
}
