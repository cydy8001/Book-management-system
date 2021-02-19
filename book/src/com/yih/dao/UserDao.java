package com.yih.dao;

import com.yih.pojo.User;

public interface UserDao {


    public User queryUserByUsername(String username);


    public User queryUserByUsernameAndPassword(String username, String password);


    public int saveUser(User user);


}
