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
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;

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

    @RequestMapping("toindex")
    public String ToIndex() { return "index"; }
    @RequestMapping("tologin")
    public String ToLogin(){
        return "login";
    }
    @RequestMapping("tocenter")
    public String ToCenter() { return "center"; }

    @RequestMapping("dologin")
    public String DoLogin(String corporationName, String password, HttpSession session, HttpServletRequest request){
        LOGGER.info("begin login---->>>>>>>>>>>>>");
        Corporation cModel = corporationService.FindCorporation(corporationName);
        if (cModel != null) {
            if (DigestUtils.md5Hex(password).equals(cModel.getPassword())) {
                session.setAttribute("loginUser", cModel);
                LOGGER.info(corporationName + "登录成功！");
                return "index";
            }
        }
        LOGGER.error(corporationName + "登录失败！");
        request.setAttribute("loginerror","用户名或密码错误！");
        return "login";
    }

    @RequestMapping("toselect")
    public String Toselect(HttpServletRequest request){
        LOGGER.info("查询申报表！");
        List<Declare> declareList = declareService.getAllDeclare();
        request.setAttribute("userList",declareList);
        return "company";
    }
    @RequestMapping("company")
    public String SelectUser(String userName,String identifyNum,String status,
                             String level,String year,HttpServletRequest request){
        LOGGER.info("查询申报表！");
        List<Declare> declareUsernameList = new ArrayList<Declare>();
        Declare declareIdentifynumList = new Declare();
        List<Declare> declareStatusList = new ArrayList<Declare>();
        List<Declare> declareLevelList = new ArrayList<Declare>();
        List<Declare> declareYearList = new ArrayList<Declare>();
        List<Declare> declareList = new ArrayList<Declare>();
        if(!userName.equals(""))
            declareUsernameList=declareService.getDeclareByUserName(userName);
        if(!identifyNum.equals(""))
            declareIdentifynumList=declareService.getDeclareByIdentifyNum(identifyNum);
        if(!status.equals("")){
            int s=Integer.parseInt(status);
            declareStatusList=declareService.getDeclareByStatus(s);
        }
        if(!level.equals("")){
            int l=Integer.parseInt(level);
            declareLevelList=declareService.getDeclareByLevel(l);
        }
        if(!year.equals(""))
            declareYearList=declareService.getDeclareByYear(year);
        declareList.addAll(declareUsernameList);
        declareList.add(declareIdentifynumList);
        declareList.addAll(declareStatusList);
        declareList.addAll(declareLevelList);
        declareList.addAll(declareYearList);
        declareList = new ArrayList<Declare>(new LinkedHashSet<>(declareList));
        request.setAttribute("userList",declareList);
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
    @RequestMapping("deleteuser")
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

