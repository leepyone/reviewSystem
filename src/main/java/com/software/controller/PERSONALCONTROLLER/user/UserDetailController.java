package com.software.controller.PERSONALCONTROLLER.user;

import com.software.DAO.userDao;
import com.software.MODULE.Education;
import com.software.MODULE.Experience;
import com.software.MODULE.User;
import com.software.MODULE.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/UserInfo")
public class UserDetailController {

    //@Autowired各种类
    @Autowired
    userDao userDao;

    //修改个人基本信息信息，user_detail
    @PostMapping("/UpdatePersonalUserDetail")
    public String UpdatePersonalUserDetail(UserDetails userDetails, Map<String, Object> map, HttpSession session){

        if(!isLogin(session)){
            //如果没有登录
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //插入用户基本信息

        return "个人资料页面(主界面)";
    }

    //添加学历信息记录
    @PostMapping("AddEducation")
    public String AddEducation(Education education, Map<String, Object> map, HttpSession session){

        if(!isLogin(session)){
            //如果没有登录
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //添加学历基本信息

        return "个人资料页面(主界面)";
    }

    //添加工作经历记录
    @PostMapping("AddExperience")
    public String AddExperience(Experience experience,Map<String, Object> map, HttpSession session){

        if(!isLogin(session)){
            //如果没有登录
            return "redirect:/PersonalUser/Login";//返回登录界面
        }

        //添加工作经历记录

        return "个人资料页面(主界面)";
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
