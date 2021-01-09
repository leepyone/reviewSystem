package com.software.PERSONALCONTROLLER.user;

import com.software.MODULE.User;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/PersonalUser")
public class UserController {

    //跳转个人版登录界面
    @RequestMapping("/Login")
    public String toLogin(){
        return "ok";//跳转页面
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
            session.setAttribute("PersonalLoginUser",username);
            return "redirect:个人资料页面";

        }
        else{
            map.put("LoginFailMsg","用户名或密码错误");
            return "登录界面";
        }
    }

    @PostMapping("/doRegister")
    public String doRegister(User user, Map<String, Object> map, HttpSession session){
        if(true){
            //注册成功
            return "redirect:登录界面";
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
}
