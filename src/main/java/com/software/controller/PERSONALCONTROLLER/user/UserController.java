package com.software.controller.PERSONALCONTROLLER.user;

import com.software.MODULE.User;
import com.software.SERVICE.impl.UserServiceImpl;
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
    UserServiceImpl userService;

    //跳转个人版登录界面
    @RequestMapping("/Login")
    public String toLogin(HttpSession session){
        if(isLogin(session)){
            //如果登录了
            return "redirect:个人资料页面(主界面)";
        }
        return "ok";//跳转到登录页面
    }

    //跳转个人版注册界面
    @RequestMapping("/Register")
    public String toRegister(){
        return "ok";//跳转页面
    }

    //个人版登录
    @PostMapping("/doLogin")
    public String doLogin(String username, String password,Map<String, Object> map, HttpSession session){

        System.out.println(username+" "+password);
        //登录
        if(true){
            //登录成功
            session.setAttribute("PersonalLoginUser",username);//将User对象插入session，目前为String
            return "redirect:个人资料页面(主界面)";

        }
        else{
            map.put("LoginFailMsg","用户名或密码错误");
            return "登录界面";//返回登录界面
        }
    }

    //个人版退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session, SessionStatus sessionStatus){
        session.invalidate();
        sessionStatus.setComplete();
        return "redirect:/PersonalUser/Login";//返回登录界面
    }

    //个人版注册
    @PostMapping("/doRegister")
    public String doRegister(User user, Map<String, Object> map, HttpSession session){
        if(true){
            //注册成功
            //创建相同id的记录，其余字段为空
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        else if(true){
            //身份证重复
            map.put("IdentifyIdRepeatMsg","身份证号码重复");
            return "注册界面";
        }
        else{
            map.put("PhoneRepeatMsg","电话号码重复");
            return "注册界面";
        }
    }

    //判断登录
    public boolean isLogin(HttpSession session){
        //xxx=session.getAttribute("PersonalLoginUser");//获取用户
        if(true){
            //登录了
            return true;
        }
        return false;
    }
}
