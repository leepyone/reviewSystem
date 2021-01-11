package com.software.controller;

import com.software.MODULE.*;
import com.software.SERVICE.*;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("corporation")
public class company {
    private static final Logger LOGGER = Logger.getLogger(company.class);

    @Autowired
    private CorporationService corporationService;
    @Autowired
    private declareService declareService;
    @Autowired
    private EducationService educationService;
    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private PaperService paperService;

    @RequestMapping("toregistration")
    public String ToRegistration() { return "company_register"; }
    @RequestMapping("doregistration")
    public String DoRegistration(String corporationName, String password, HttpSession session, HttpServletRequest request){

        return "tologin";
    }

    @RequestMapping("tologin")
    public String ToLogin(){
        return "company_login";
    }
    @RequestMapping("dologin")
    public String DoLogin(String number, String password, HttpSession session, HttpServletRequest request){
        LOGGER.info("begin login---->>>>>>>>>>>>>");
        Corporation cModel = corporationService.FindCorporation(number);
        if (cModel != null) {
            if (password.equals(cModel.getPassword())) {
                session.setAttribute("loginCorp", cModel);
                LOGGER.info(number + "登录成功！");
                return "forward:ManageUser";
            }
        }
        LOGGER.error(number + "登录失败！");
        request.setAttribute("loginerror","用户名或密码错误！");
        return "company_login";
    }

    @RequestMapping("ManageUser")
    public String ManageUser(HttpSession session, HttpServletRequest request){
        LOGGER.info("用户管理！");
        Corporation thisCorp = (Corporation) session.getAttribute("loginCorp");
        List<User> workerList = corporationService.getWorkers(thisCorp.getCorporationId());
        HashMap<String, String> map = new HashMap<>();
        List<Map> maps = new ArrayList<Map>();
        for(User worker : workerList) {
            map.put("workerName",worker.getUserName());
            map.put("workerPhone",worker.getUserPhone());
            map.put("workerStatus",String.valueOf(corporationService.FindUserStatus(worker.getUserID())));
            LOGGER.info(map);
            maps.add(map);
            LOGGER.info(maps);
        }
        request.setAttribute("workerList",maps);
        return "Manage";
    }
    @RequestMapping("deleteuser")
    public String DeleteUser(@RequestParam String userName) {
        corporationService.DeleteUser(corporationService.FindUserID(userName));
        return "forward:Manage";
    }

    @RequestMapping("toselect")
    public String Toselect(HttpServletRequest request){
        LOGGER.info("查询申报表！");
        List<Declare> declareList = declareService.getAllDeclare();
        request.setAttribute("declareList",declareList);
        return "company";
    }
    @RequestMapping("selectdeclare")
    public String SelectUser(String userName,String identifyNum,String status,
                             String level,String year,HttpServletRequest request){
        LOGGER.info("查询申报表！");
        List<Declare> declareList = new ArrayList<Declare>();
        if (!userName.equals("") && status.equals("选择状态"))
            declareList=declareService.getDeclareByUserName(userName);
        else if(!identifyNum.equals(""))
            declareList=declareService.getDeclareByIdentifyNum(identifyNum);
        else if (!status.equals("选择状态") && userName.equals("")){
            int s;
            if (status.equals("审核通过"))
                s=3;
            else if (status.equals("退回"))
                s=1;
            else if (status.equals("待审核"))
                s=0;
            else
                s=2;
            declareList=declareService.getDeclareByStatus(s);
        }
        else if (!level.equals("选择级别")){
            int l;
            if (level.equals("低级"))
                l=1;
            else if (level.equals("中级"))
                l=2;
            else
                l=3;
            declareList=declareService.getDeclareByLevel(l);
        }
        else if(!year.equals("选择年度"))
            declareList=declareService.getDeclareByYear(year);
        else if (!userName.equals("") && !status.equals("选择状态")){
            int s;
            if (status.equals("审核通过"))
                s=3;
            else if (status.equals("退回"))
                s=1;
            else if (status.equals("待审核"))
                s=0;
            else
                s=2;
            declareList=declareService.getDeclareByUS(userName,s);
        }
        else
            declareList=declareService.getAllDeclare();
        request.setAttribute("declareList",declareList);
        LOGGER.info("查询成功！");
        return "company";
    }

    @RequestMapping("todetails")
    public String ToEditUser(@RequestParam String declareID,HttpServletRequest request,HttpSession session){
        int dID = Integer.parseInt(declareID);
        Declare declare = declareService.findDeclare(dID);
        List<Education> edu = new ArrayList<Education>();
        edu = educationService.getEduList(declare.getUserID());
        List<Experience> exp = new ArrayList<Experience>();
        exp = experienceService.getExpList(declare.getUserID());
        List<Paper> papers = new ArrayList<Paper>();
        papers = paperService.getPaperList(declare.getUserID());
        request.setAttribute("thisDeclare",declare);
        request.setAttribute("thisEdu",edu);
        request.setAttribute("thisExp",exp);
        request.setAttribute("thisPaper",papers);
        session.setAttribute("thisD",declare);
        return "company_shenhe";
    }
    @RequestMapping("deletedeclare")
    public String DeleteUser(@RequestParam String declareID,HttpServletRequest request){
        int dID = Integer.parseInt(declareID);
        declareService.deleteDeclare(dID);
        request.setAttribute("message","删除成功！");
        return "forward:toselect";
    }

    @RequestMapping("toagree")
    public String ToAgree() { return "company_totop"; }
    @RequestMapping("agree")
    public String AgreeDeclare(HttpSession session, HttpServletRequest request){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);

        long l = System.currentTimeMillis();
        int i = (int)( l % 100 );
        while(corporationService.FindDelareID(i)){
            l = System.currentTimeMillis();
            i = (int)( l % 100 );
        }

        User user = (User)session.getAttribute("PersonalLoginUser");
        Declare d = (Declare)session.getAttribute("thisD");
        Declare_check dCheck = new Declare_check();
        dCheck.setCheckId(i);
        dCheck.setCheckDate(currentTime_2);
        dCheck.setDeclareId(d.getDeclareID());
        dCheck.setUserId(user.getUserID());
        dCheck.setCheckStatus(3);
        corporationService.InsertCheck(dCheck);
        corporationService.UpdateDeclareStatus(d.getDeclareID(),3);
        return "forward:todetails";
    }

    @RequestMapping("torefuse")
    public String ToRefuse() { return "company_todeep"; }
    @RequestMapping("refuse")
    public String RefuseDeclare(@RequestParam String declareUser,
                                String oppoin,
                                String status,HttpSession session, HttpServletRequest request){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);

        long l = System.currentTimeMillis();
        int i = (int)( l % 100 );
        while(corporationService.FindDelareID(i)){
            l = System.currentTimeMillis();
            i = (int)( l % 100 );
        }

        Declare d = (Declare)session.getAttribute("thisD");
        User user = (User)session.getAttribute("PersonalLoginUser");

        declareUser=d.getDeclareUserName();

        Declare_check dCheck = new Declare_check();
        dCheck.setCheckId(i);
        dCheck.setCheckDate(currentTime_2);
        dCheck.setDeclareId(d.getDeclareID());
        dCheck.setUserId(user.getUserID());
        dCheck.setCheckOppoins(oppoin);
        if(status.equals("退回修改")){
            dCheck.setCheckStatus(1);
            corporationService.UpdateDeclareStatus(d.getDeclareID(),1);
        }
        else{
            dCheck.setCheckStatus(2);
            corporationService.UpdateDeclareStatus(d.getDeclareID(),2);
        }
        corporationService.InsertCheck(dCheck);
        return "forward:todetails";
    }

}

