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
    @Override
    public User Login(String user_number, String user_password){
        return userDao.Login(user_number, user_password);
    }

    //个人版注册
    @Override
    public String PersonalRegister(User user){

        User u=userDao.getUserByIDCard(user.getUserIdentifyID());
        if(u==null) {
            return "身份证已存在";
        }
        u=userDao.getUserByPhone(user.getUserPhone());
        if(u==null){
            return "电话号码已经存在已存在";
        }
        int user_id=userDao.insertUser(user);
        UserDetails userDetails=new UserDetails();
        userDetails.setUserID(user_id);
        userDao.insertUserDetail(userDetails);
        return "success";
    }


    //修改密码
    @Override
    public boolean changeUserPassword(String userPassword,String user_number){
        User u=userDao.Login(user_number,userPassword);
        if(u==null){
            return false;//原密码不符
        }
        userDao.changeUserPassword(userPassword, user_number);
        return true;
    }

    //修改个人版用户信息
    @Override
    public void changeUserDetail(UserDetails userDetails){
        userDao.changeUserDetail(userDetails);
    }
}
