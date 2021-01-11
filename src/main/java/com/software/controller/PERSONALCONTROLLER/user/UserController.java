package com.software.controller.PERSONALCONTROLLER.user;

import com.software.MODULE.User;
import com.software.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/PersonalUser")
public class UserController {

    //@Autowired各种类
    @Autowired
    UserService userService;

    //跳转个人版登录界面
    @RequestMapping("/Login")
    public String toLogin(HttpSession session){
        if(isLogin(session)){
            //如果登录了
//            return "redirect:个人资料界面";
        }
        return "personal_login";
    }

    //跳转个人版注册界面
    @RequestMapping("/Register")
    public String toRegister(){
        return "注册界面";//跳转页面
    }

    //个人版登录
    @PostMapping("/doLogin")
    public String doLogin(String username, String password,Map<String, Object> map, HttpSession session){
        System.out.println(username+" "+password);

        User user=userService.Login(username,password);
        //登录
        if(user!=null){
            //登录成功
            session.setAttribute("PersonalLoginUser",user);
            return "redirect:/PersonalDeclare/Declare";

        }
        else{
            map.put("LoginFailMsg","用户名或密码错误");
            return "personal_login";//返回登录界面
        }
    }

    //个人版退出登录
    @RequestMapping("/doLogout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/PersonalUser/Login";//返回登录界面
    }

    //个人版注册
    @PostMapping("/doRegister")
    public String doRegister(User user, Map<String, Object> map, HttpSession session){
        String feature=userService.PersonalRegister(user);
        if(feature.equals("success")){
            //注册成功
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        else if(feature.equals("身份证已存在")){
            //身份证重复
            map.put("IdentifyIdRepeatMsg","身份证号码重复");
            return "注册界面";
        }
        else{
            //电话号码重复
            map.put("PhoneRepeatMsg","电话号码重复");
            return "注册界面";
        }
    }

    //判断登录
    public boolean isLogin(HttpSession session){
        User user=(User) session.getAttribute("PersonalLoginUser");//获取用户
        if(user!=null){
            return true;
        }
        return false;
    }
}
