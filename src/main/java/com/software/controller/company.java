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
import java.util.List;

@Controller
@RequestMapping("corporation")
public class company {
    private static final Logger LOGGER = Logger.getLogger(company.class);
    @Resource
    private Producer captchaProducer;

    @Autowired
    private CorporationService corporationService;

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

//    @RequestMapping("toselect")
//    public String Toselect(HttpServletRequest request,
//                           @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
//                           @RequestParam(defaultValue="5",value="pageSize")Integer pageSize){
//        if(pageNum == null){
//            pageNum = 1;
//        }
//        if(pageNum <= 0){
//            pageNum = 1;
//        }
//        if(pageSize == null){
//            pageSize = 5;
//        }
//        PageHelper.startPage(pageNum,pageSize);
//        try {
//            List<Declare> userList = userService.SelectUserPage();
//            LOGGER.info("分页数据："+userList);
//            //使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
//            PageInfo<Declare> pageInfo = new PageInfo<Declare>(userList,pageSize);
//            request.setAttribute("userList",userList);
//            request.setAttribute("pageInfo",pageInfo);
//        }finally {
//            PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
//        }
//        return "selectuser";
//    }
//    @RequestMapping("selectuser")
//    public String SelectUser(String username,String realname,String department,HttpServletRequest request,
//                             @RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
//                             @RequestParam(defaultValue="5",value="pageSize")Integer pageSize){
//        LOGGER.info("查询用户！");
//        if(pageNum == null){
//            pageNum = 1;
//        }
//        if(pageNum <= 0){
//            pageNum = 1;
//        }
//        if(pageSize == null){
//            pageSize = 5;
//        }
//        List<Declare> userList2 = new ArrayList<Model>();
//        PageHelper.startPage(pageNum,pageSize);
//        if(!username.equals("") && realname.equals("") && department.equals("所在部门")){
//            userList2 = userService.SelectUserIdPage(username);
//        }
//        else if(username.equals("") && !realname.equals("") && department.equals("所在部门")){
//            userList2 = userService.SelectUserRnPage(realname);
//        }
//        else if(username.equals("") && realname.equals("") && !department.equals("所在部门")){
//            userList2 = userService.SelectUserDpPage(department);
//        }
//        else if(!username.equals("") && !realname.equals("") && department.equals("所在部门")){
//            userList2 = userService.SelectUserIRPage(username,realname);
//        }
//        else if(!username.equals("") && realname.equals("") && !department.equals("所在部门")){
//            userList2 = userService.SelectUserIDPage(username,department);
//        }
//        else if(username.equals("") && !realname.equals("") && !department.equals("所在部门")){
//            userList2 = userService.SelectUserRDPage(realname,department);
//        }
//        else if(!username.equals("") && !realname.equals("") && !department.equals("所在部门")){
//            userList2 = userService.SelectUserIRDPage(username,realname,department);
//        }
//        else {
//            userList2 = userService.SelectUserPage();
//        }
//        LOGGER.info("分页数据："+userList2);
//        //使用PageInfo包装查询后的结果,5是连续显示的条数,结果list类型是Page<E>
//        PageInfo<Declare> pageInfo = new PageInfo<Model>(userList2,pageSize);
//        request.setAttribute("userList",userList2);
//        request.setAttribute("pageInfo",pageInfo);
//        LOGGER.info("查询成功！");
//        return "selectuser";
//    }

}
