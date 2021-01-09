package com.software.PERSONALCONTROLLER.declare;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/PersonalDeclare")
public class DeclareController {
    //@Autowired各种类

    //跳转至职称评审界面
    @RequestMapping("/Declare")
    public String toDeclare(HttpSession session){
        if(!isLogin(session)){
            return "redirect:登录界面";
        }
        return "redirect:职称评审界面";
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
