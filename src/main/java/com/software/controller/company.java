package com.software.controller;

import com.software.MODULE.Corporation;
import com.software.MODULE.Declare;
import com.software.SERVICE.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

@Controller
@RequestMapping("corporation")
public class company {
    private static final Logger LOGGER = Logger.getLogger(company.class);
    @Resource
    private Producer captchaProducer;

    @Autowired
    private CorporationService corporationService;
    @Autowired
    private declareService declareService;

    @RequestMapping("toindex")
    public String ToIndex() { return "index"; }
    @RequestMapping("tologin")
    public String ToLogin(){
        return "login";
    }
    @RequestMapping("torepwd")
    public String ToRePwd() { return "repwd-1"; }
    @RequestMapping("toinsert")
    public String ToInsert() { return "adduser"; }

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
    public String ToEditUser(@RequestParam String declareID,HttpServletRequest request){
        int dID = Integer.parseInt(declareID);
        Declare declare = declareService.findDeclare(dID);
        request.setAttribute("thisDeclare",declare);
        return "company_shenhe";
    }

    @RequestMapping("deleteuser")
    public String DeleteUser(@RequestParam String declareID,HttpServletRequest request){
        int dID = Integer.parseInt(declareID);
        declareService.deleteDeclare(dID);
        request.setAttribute("message","删除成功！");
        return "forward:toselect";
    }

}
