package com.software.SERVICE;

import com.software.MODULE.Declare;

import java.util.List;

public interface declareService {

    public List<Declare> getAllDeclare();//查看所有职称评审列表集合

    public List<Declare> getDeclareByUserID(int userID);//通过用户ID获得评审单集合

    public Declare getDeclareByDeclareID(int declareID);//通过评审单ID获取单个评审单

    public List<Declare> getDeclareByCorporationID(int corporationID);//通过报送公司ID获取评审单列表

    public List<Declare> getDeclareByCorID(int corID);//通过职改办ID获取评审单列表



}
