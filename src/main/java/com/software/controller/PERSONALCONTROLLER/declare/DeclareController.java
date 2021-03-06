package com.software.controller.PERSONALCONTROLLER.declare;

import com.software.MODULE.*;
import com.software.SERVICE.EducationService;
import com.software.SERVICE.ExperienceService;
import com.software.SERVICE.PaperService;
import com.software.SERVICE.PersonalDeclareService;
import com.software.SERVICE.impl.declareServiceImpl;
import com.sun.istack.internal.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

//职称评审/PersonalDeclare/toCreateDeclareTable
@Controller
@RequestMapping("/PersonalDeclare")
public class DeclareController {

    //@Autowired各种类
    @Autowired
    PersonalDeclareService personalDeclareService;
    @Autowired
    EducationService educationService;
    @Autowired
    ExperienceService experienceService;
    @Autowired
    PaperService paperService;

    //简单日期格式转换
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    //跳转申报职称页面
    @RequestMapping("/Main")
    public String toMain(HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //查询出职称评审list
        User user=(User)session.getAttribute("PersonalLoginUser");
        List<Declare> declareList=personalDeclareService.getDeclareByUserID(user);

        //put上去
        map.put("declareList",declareList);

        return "shenbaozhicheng";
    }

    //跳转至职称评审界面
    @RequestMapping("/Declare")
    public String toDeclare(HttpSession session,Map<String, Object> map){

        //判断登录
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        //查询出职称评审list
        User user=(User)session.getAttribute("PersonalLoginUser");
        List<Declare> declareList=personalDeclareService.getDeclareByUserID(user);


        //put上去
        map.put("declareList",declareList);

        return "index";
    }

    //跳转至新建审评表界面
    @RequestMapping("/toCreateDeclareTable")
    public String toCreateDeclareTable(HttpSession session,Map<String, Object> map){
        //判断登录
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        User user=(User)session.getAttribute("PersonalLoginUser");
        //学历信息，主要经历，论文,所有公司信息
        List<Education> educationList=educationService.getEducationByUserID(user);
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        List<Paper> paperList=paperService.getPaperByUserID(user);
        List<Corporation> corporationList=personalDeclareService.FindAllCorporations();

        //map.put
        map.put("educationList",educationList);
        map.put("experienceList",experienceList);
        map.put("paperList",paperList);
        map.put("corporationList",corporationList);

        return "pingshen_input";
    }

    //查看某个职称评审表详细情况
    @RequestMapping("/Detail/{declareId}")
    public String toOneDeclare(@PathVariable("declareId") int declareId, HttpSession session, Map<String, Object> map){

        //判断登录
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        User user=(User)session.getAttribute("PersonalLoginUser");
        //查询相应的评审表和declare_check表
        Declare declareTemp=new Declare();
        declareTemp.setDeclareID(declareId);
        Declare declare=personalDeclareService.getDeclareByDeclareID(declareTemp);
        List<Declare_check> declareCheckList=personalDeclareService.getDeclareCheckListByDeclareId(declareTemp);

        //学历信息，主要经历，论文
        List<Education> educationList=educationService.getEducationByUserID(user);
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        List<Paper> paperList=paperService.getPaperByUserID(user);

        //map.put上去
        map.put("declare",declare);
        map.put("declareCheckList",declareCheckList);
        map.put("educationList",educationList);
        map.put("experienceList",experienceList);
        map.put("paperList",paperList);
        return "detail";
    }

    //查看评审表的推荐表
    @RequestMapping("/Recommendation/{declareId}")
    public String toOneRecommendation(@PathVariable("declareId") int declareId,HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        User user=(User) session.getAttribute("PersonalLoginUser");
        //查询相应的评审表
        Declare declareTemp=new Declare();
        declareTemp.setDeclareID(declareId);
        Declare declare=personalDeclareService.getDeclareByDeclareID(declareTemp);
        List<Declare_check> declareCheckList=personalDeclareService.getDeclareCheckListByDeclareId(declareTemp);
        //学历信息，主要经历，论文
        List<Education> educationList=educationService.getEducationByUserID(user);
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        List<Paper> paperList=paperService.getPaperByUserID(user);

        //map.put上去
        map.put("declare",declare);
        map.put("declareCheckList",declareCheckList);
        map.put("educationList",educationList);
        map.put("experienceList",experienceList);
        map.put("paperList",paperList);
        return "评审推荐表界面";
    }

    //查看评审表的审评表(打印)
    @RequestMapping("/Review/{declareId}")
    public String toOneReview(@PathVariable("declareId") int declareId,HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        User user=(User) session.getAttribute("PersonalLoginUser");
        //查询相应的评审表
        Declare declareTemp=new Declare();
        declareTemp.setDeclareID(declareId);
        Declare declare=personalDeclareService.getDeclareByDeclareID(declareTemp);
        List<Declare_check> declareCheckList=personalDeclareService.getDeclareCheckListByDeclareId(declareTemp);
        //学历信息，主要经历，论文
        List<Education> educationList=educationService.getEducationByUserID(user);
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        List<Paper> paperList=paperService.getPaperByUserID(user);
        //map.put上去
        map.put("declare",declare);
        map.put("declareCheckList",declareCheckList);
        map.put("educationList",educationList);
        map.put("experienceList",experienceList);
        map.put("paperList",paperList);
        return "评审表(打印)界面";
    }


    //新建评审表
    @PostMapping("/CreateDeclareTable")
    public String CreateDeclareTable(Declare declare,String declare_worktime,HttpSession session,Map<String, Object> map){
        if(!isLogin(session)){
            return "redirect:/PersonalUser/Login";//返回登录界面
        }
        System.out.println(declare);
        //日期格式转换
        User user=(User) session.getAttribute("PersonalLoginUser");
        Date declareWorkTime=StringToDate(declare_worktime);
        declare.setDeclareWorktime(declareWorkTime);
        Date date =new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String setUptime=df.format(date);
        declare.setDeclareSetuptime(setUptime);
        declare.setDeclareYear("2021");
        //提交相应的信息
        personalDeclareService.CreateDeclare(declare,user);
        return "redirect:/PersonalDeclare/toCreateDeclareTable";
    }

    //添加学历信息记录，education_graduation_time为前端传回来的信息，需要格式化
    @PostMapping("/AddEducation")
    public String AddEducation(Education education, String education_graduation_time,
                               Map<String, Object> map, HttpSession session){

        System.out.println(education);
        User user=(User) session.getAttribute("PersonalLoginUser");
        //日期格式转换
        Date educationGraduationTime=StringToDate(education_graduation_time);
        education.setEducationGraduationTime(educationGraduationTime);
        education.setUserID(user.getUserID());
        //添加学历基本信息
        educationService.addEducation(education);
        //返回学历的list
        List<Education> educationList=educationService.getEducationByUserID(user);
        //map.put上去
        map.put("educationList",educationList);

        return "redirect:/PersonalDeclare/toCreateDeclareTable";
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
        experience.setUserID(user.getUserID());
        //添加工作经历基本信息
        experienceService.addExperience(experience);
        //返回工作经历的list
        List<Experience> experienceList=experienceService.getExperienceByUserID(user);
        //map.put上去

        map.put("experienceList",experienceList);

        return "redirect:/PersonalDeclare/toCreateDeclareTable";
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

        return "redirect:/PersonalDeclare/toCreateDeclareTable";
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

        return "pingshen_input";
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

        return "pingshen_input";
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

        return "pingshen_input";
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

        return "pingshen_input";
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

        return "pingshen_input";
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

        return "pingshen_input";
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