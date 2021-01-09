package com.software.PERSONALCONTROLLER.declare;

import com.software.MODULE.Declare;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/PersonalDeclare")
public class DeclareController {
    //@Autowired各种类

    //跳转至职称评审界面
    @RequestMapping("/Declare")
    public String toDeclare(HttpSession session,Map<String, Object> map){

        //判断登录
        if(!isLogin(session)){
            return "redirect:登录界面";
        }
        //查询出职称评审list

        //map.put("declareList",declareList);
        return "redirect:职称评审界面";
    }

    //查看某个职称评审表
    @RequestMapping("/Detail/{DeclareId}")
    public String toOneDeclare(@PathVariable("DeclareId") int DeclareId,HttpSession session,Map<String, Object> map){

        //判断登录
        if(!isLogin(session)){
            return "redirect:登录界面";
        }

        //查询相应的评审表,包含评审表的基本信息，学历信息，主要经历，

        //map.put上去

        return "评审表详细内容界面";
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
