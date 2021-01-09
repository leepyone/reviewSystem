package com.software.SERVICE.impl;

import com.software.DAO.declareDao;
import com.software.MODULE.Declare;
import com.software.SERVICE.declareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class declareServiceImpl implements declareService {

    @Autowired
    declareDao declareDao;

    //获取所有评审单
    @Override
    public List<Declare> getAllDeclare(){return declareDao.getAllDeclare();}

    //通过用户id获取评审单集合
    @Override
    public List<Declare> getDeclareByUserID(int userID){return declareDao.getDeclareByUserID(userID); }

    //通过评审单id获取响应评审单
    @Override
    public Declare getDeclareByDeclareID(int declareID) {
        return null;
    }

    //通过报送公司ID获取评审单列表
    @Override
    public List<Declare> getDeclareByCorporationID(int corporationID) {
        return null;
    }

    //通过职改办ID获取评审单列表
    @Override
    public List<Declare> getDeclareByCorID(int corID) {
        return null;
    }
}
