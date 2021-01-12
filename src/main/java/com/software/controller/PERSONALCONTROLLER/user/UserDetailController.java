package com.software.controller.PERSONALCONTROLLER.user;

import com.software.MODULE.*;
import com.software.SERVICE.EducationService;
import com.software.SERVICE.ExperienceService;
import com.software.SERVICE.PaperService;
import com.software.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/PersonalUserInfo")
public class UserDetailController {

    //@Autowired各种类
    @Autowired
    UserService userService;
    @Autowired
    EducationService educationService;
    @Autowired
    ExperienceService experienceService;
    @Autowired
    PaperService paperService;

    //简单日期格式转换
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //跳转个人资料界面
    @RequestMapping("/toPersonalInfo")
    public String toPersonalInfo(HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        User user=(User) session.getAttribute("PersonalLoginUser");

        //返回学历的list
        List<Education> educationList=educationService.getEducationByUserID(user);
        //map.put上去
        map.put("educationList",educationList);
        //返回工作经历的list
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        //map.put上去
        map.put("experienceList",experienceList);

        return "personaldata";

    }

    //修改个人基本信息信息，user_detail
    @PostMapping("/UpdatePersonalUserDetail")
    public String UpdatePersonalUserDetail(UserDetails userDetails, Map<String, Object> map, HttpSession session){

        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //修改用户基本信息
        userService.changeUserDetail(userDetails);

        return "redirect:/";
    }

    //添加学历信息记录
    @PostMapping("/AddEducation")
    public String AddEducation(Education education, String education_graduation_time,
                               Map<String, Object> map, HttpSession session){

        User user=(User) session.getAttribute("PersonalLoginUser");
        //日期格式转换
        Date educationGraduationTime=StringToDate(education_graduation_time);
        education.setEducationGraduationTime(educationGraduationTime);
        //添加学历基本信息
        educationService.addEducation(education);
        //返回学历的list
        List<Education> educationList=educationService.getEducationByUserID(user);
        //map.put上去
        map.put("educationList",educationList);

        return "个人资料页面(主界面)";
    }

    //添加工作经历记录
    @PostMapping("/AddExperience")
    public String AddExperience(Experience experience,String experience_starttime,String
            experience_endtime, Map<String, Object> map, HttpSession session){

        User user=(User) session.getAttribute("PersonalLoginUser");
        //日期格式转换
        Date experienceStarttime=StringToDate(experience_starttime);
        Date experienceEndtime=StringToDate(experience_endtime);
        experience.setExperienceStarttime(experienceStarttime);
        experience.setExperienceEndtime(experienceEndtime);
        //添加工作经历基本信息
        experienceService.addExperience(experience);
        //返回工作经历的list
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        //map.put上去
        map.put("experienceList",experienceList);

        return "个人资料页面(主界面)";
    }


    //修改学历信息
    @PostMapping("/UpdateEducation")
    public String UpdateEducation(Education education, String education_graduation_time,
                                  Map<String, Object> map, HttpSession session){

        User user=(User) session.getAttribute("PersonalLoginUser");
        //日期格式转换
        Date educationGraduationTime=StringToDate(education_graduation_time);
        education.setEducationGraduationTime(educationGraduationTime);
        //修改学历信息
        educationService.setEducation(education);
        //返回学历的list
        List<Education> educationList=educationService.getEducationByUserID(user);
        //map.put上去
        map.put("educationList",educationList);

        return "个人资料页面(主界面)";
    }

    //修改工作经历
    @PostMapping("/UpdateExperience")
    public String UpdateExperience(Experience experience,String experience_starttime,String
            experience_endtime, Map<String, Object> map, HttpSession session){

        User user=(User) session.getAttribute("PersonalLoginUser");
        //日期格式转换
        Date experienceStarttime=StringToDate(experience_starttime);
        Date experienceEndtime=StringToDate(experience_endtime);
        experience.setExperienceStarttime(experienceStarttime);
        experience.setExperienceEndtime(experienceEndtime);
        //修改工作经历
        experienceService.setExperience(experience);
        //返回工作经历的list
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        //map.put上去
        map.put("experienceList",experienceList);

        return "个人资料页面(主界面)";
    }


    //删除某条学历信息记录
    @PostMapping("/DeleteEducation")
    public String DeleteEducation(int educationId,Map<String, Object> map, HttpSession session){
        User user=(User) session.getAttribute("PersonalLoginUser");

        Education education=new Education();
        education.setEducationID(educationId);
        educationService.deleteEducation(education);

        //返回学历的list
        List<Education> educationList=educationService.getEducationByUserID(user);
        //map.put上去
        map.put("educationList",educationList);

        return "个人资料页面(主界面)";
    }

    //删除某条工作经历记录
    @PostMapping("/DeleteExperience")
    public String DeleteExperience(int experienceId,Map<String, Object> map, HttpSession session){
        User user=(User) session.getAttribute("PersonalLoginUser");

        Experience experience=new Experience();
        experience.setExperienceID(experienceId);
        //删除工作经历记录
        experienceService.deleteExperience(experience);
        //返回工作经历的list
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        //map.put上去
        map.put("experienceList",experienceList);

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

    //xxxx-xx-xx转化成Date类
    public Date StringToDate(String dateStr){
        try {
            Date date=simpleDateFormat.parse(dateStr);
            return date;
        }
        catch (ParseException e){ }
        return null;
    }
}
