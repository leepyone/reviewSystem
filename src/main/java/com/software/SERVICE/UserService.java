package com.software.SERVICE;

import com.software.MODULE.User;
import com.software.MODULE.UserDetails;

public interface UserService {

    //登录
    public User Login(String user_number, String user_password);

    //个人版注册
    public String PersonalRegister(User user);

    //修改密码
    public boolean changeUserPassword(String userPassword,String user_number);

    //修改用户信息
    public void changeUserDetail(UserDetails userDetails);
}
