package com.software.SERVICE.impl;

import com.software.DAO.userDao;
import com.software.MODULE.User;
import com.software.MODULE.UserDetails;
import com.software.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    userDao userDao;

    //登录
    public User Login(String user_number, String user_password){
        return userDao.Login(user_number, user_password);
    }

    //个人版注册
    public void PersonalRegister(User user){
        int user_id=userDao.insertUser(user);
        UserDetails userDetails=new UserDetails();

    }
}
