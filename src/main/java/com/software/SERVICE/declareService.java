package com.software.SERVICE;

import com.software.MODULE.Declare;

import java.util.List;

public interface declareService {

    public List<Declare> getAllDeclare();//查看所有职称评审列表集合

    public List<Declare> getDeclareByUserName(String userName);//通过用户名称获得评审单集合

    public Declare getDeclareByIdentifyNum(String identifyNum);//通过身份证号获取单个评审单

    public List<Declare> getDeclareByStatus(int status);//通过报申报状态获取评审单列表

    public List<Declare> getDeclareByLevel(int level);//通过申报级别获取评审单列表

    public List<Declare> getDeclareByYear(String level);//通过申报年度获取评审单列表

    public Declare findDeclare(int declareID);

    //public void deleteDeclare(int declareID);

}
