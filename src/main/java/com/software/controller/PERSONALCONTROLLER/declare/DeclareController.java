package com.software.controller.PERSONALCONTROLLER.declare;

import com.software.MODULE.*;
import com.software.SERVICE.PersonalDeclareService;
import com.software.SERVICE.impl.declareServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//职称评审
@Controller
@RequestMapping("/PersonalDeclare")
public class DeclareController {

    //@Autowired各种类
    @Autowired
    PersonalDeclareService personalDeclareService;

    //跳转至职称评审界面
    @RequestMapping("/Declare")
    public String toDeclare(HttpSession session,Map<String, Object> map){

        //判断登录
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //查询出职称评审list
        User user=(User) session.getAttribute("PersonalLoginUser");
        List<Declare> declareList=personalDeclareService.getDeclareByUserID(user.getUserID());
        //查询出职称评审状态list
        List<Declare_check> declareCheckList=personalDeclareService.getDeclareCheckListByUserId(user.getUserID());

        //put上去
        map.put("declareList",declareList);
        map.put("declareCheckList",declareCheckList);
        return "redirect:职称评审界面";
    }

    //跳转至新建审评表界面
    @RequestMapping("/toCreateDeclareTable")
    public String toCreateDeclareTable(HttpSession session,Map<String, Object> map){
        //判断登录
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }

        //学历信息，主要经历，论文

        return "新建评审表界面";
    }

    //查看某个职称评审表详细情况
    @RequestMapping("/Detail/{DeclareId}")
    public String toOneDeclare(@PathVariable("DeclareId") int DeclareId,HttpSession session,Map<String, Object> map){

        //判断登录
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //查询相应的评审表

        //学历信息，主要经历，论文

        //map.put上去

        return "评审表详细内容界面";
    }

    //查看评审表的推荐表
    @RequestMapping("/Recommendation/{DeclareId}")
    public String toOneRecommendation(@PathVariable("DeclareId") int DeclareId,HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //查询相应的评审表

        //学历信息，主要经历，论文

        //map.put上去

        return "评审推荐表界面";
    }

    //查看评审表的推荐表
    @RequestMapping("/Review/{DeclareId}")
    public String toOneReview(@PathVariable("DeclareId") int DeclareId,HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //查询相应的评审表

        //学历信息，主要经历，论文

        //map.put上去

        return "评审表界面";
    }


    //新建评审表
    @PostMapping("/CreateDeclareTable")
    public String CreateDeclareTable(Declare declare,HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }

        //提交相应的信息

        return "redirect:/PersonalDeclare/Declare";
    }

    //添加学历信息记录
    @PostMapping("AddEducation")
    public String AddEducation(Education education, Map<String, Object> map, HttpSession session){


        //添加学历基本信息

        //返回学历的list

        //map.put上去

        return "新建评审界面,不刷新";
    }

    //添加工作经历记录
    @PostMapping("AddExperience")
    public String AddExperience(Experience experience, Map<String, Object> map, HttpSession session){


        //添加工作经历基本信息

        //返回工作经历的list

        //map.put上去

        return "新建评审界面,不刷新";
    }

    //添加工作经历记录
    @PostMapping("AddPaper")
    public String AddExperience(Paper paper, Map<String, Object> map, HttpSession session){


        //添加论文记录

        //返回论文的list

        //map.put上去

        return "新建评审界面,不刷新";
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
