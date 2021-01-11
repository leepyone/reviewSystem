package com.software.controller.PERSONALCONTROLLER.judge;


import com.software.MODULE.*;
import com.software.SERVICE.EducationService;
import com.software.SERVICE.ExperienceService;
import com.software.SERVICE.PaperService;
import com.software.SERVICE.PersonalJudgeService;
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
@RequestMapping("/PersonalJudge")
public class PersonalJudgeController {

    @Autowired
    PersonalJudgeService personalJudgeService;
    @Autowired
    EducationService educationService;
    @Autowired
    ExperienceService experienceService;
    @Autowired
    PaperService paperService;

    //简单日期格式转换
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping("/Judge")
    public String toJudge(HttpSession session, Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        User user=(User)session.getAttribute("PersonalLoginUser");

        //获取认定表list
        List<title_judge> titleJudgeList=personalJudgeService.getTitleJudgeByUserID(user);

        map.put("titleJudgeList",titleJudgeList);

        return "zhichengrending";
    }

    //跳转至新建认定表界面
    @RequestMapping("/toCreateJudgeTable")
    public String toCreateJudgeTable(HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }

        return "rending_input";
    }

    //新建认定表
    @PostMapping("/CreateJudgeTable")
    public String CreateJudgeTable(title_judge titleJudge,HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        User user=(User) session.getAttribute("PersonalLoginUser");

        //提交认定表
        personalJudgeService.addTitleJudge(titleJudge,user);

        return "redirect:/PersonalJudge/Judge";//返回职称认定界面
    }


    //添加学历信息记录，education_graduation_time为前端传回来的信息，需要格式化
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

        return "新建职称认定,不刷新";
    }

    //添加工作经历记录
    @PostMapping("/AddExperience")
    public String AddExperience(Experience experience, String experience_starttime, String
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

        return "新建职称认定,不刷新";
    }

    //添加论文记录
    @PostMapping("/AddPaper")
    public String AddPaper(Paper paper, Map<String, Object> map, HttpSession session){

        User user=(User) session.getAttribute("PersonalLoginUser");
        //添加论文记录
        paperService.addPaper(paper);
        //返回论文的list
        List<Paper> paperList=paperService.getPaperByUserID(user);
        //map.put上去
        map.put("paperList",paperList);

        return "新建职称认定,不刷新";
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

        return "新建职称认定,不刷新";
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

        return "新建职称认定,不刷新";
    }

    //修改论文信息
    @PostMapping("/UpdatePaper")
    public String UpdatePaper(Paper paper, Map<String, Object> map, HttpSession session){

        User user=(User) session.getAttribute("PersonalLoginUser");
        //修改论文记录
        paperService.setPaper(paper);
        //返回论文的list
        List<Paper> paperList=paperService.getPaperByUserID(user);
        //map.put上去
        map.put("paperList",paperList);

        return "新建职称认定,不刷新";
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

        return "新建职称认定,不刷新";
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

        return "新建职称认定,不刷新";
    }

    //删除某条论文记录
    @PostMapping("/DeletePaper")
    public String DeletePaper(int paperId,Map<String, Object> map, HttpSession session){
        User user=(User) session.getAttribute("PersonalLoginUser");

        Paper paper=new Paper();
        paper.setPaperID(paperId);
        //删除论文记录
        paperService.deletePaper(paper);
        //返回论文的list
        List<Paper> paperList=paperService.getPaperByUserID(user);
        //map.put上去
        map.put("paperList",paperList);

        return "新建职称认定,不刷新";
    }

    //判断登录
    public boolean isLogin(HttpSession session){
        User user=(User)session.getAttribute("PersonalLoginUser");//获取用户
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
