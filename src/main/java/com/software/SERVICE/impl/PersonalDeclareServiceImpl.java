package com.software.SERVICE.impl;

import com.software.DAO.CorporationDao;
import com.software.DAO.declareDao;
import com.software.MODULE.Corporation;
import com.software.MODULE.Declare;
import com.software.MODULE.Declare_check;
import com.software.MODULE.User;
import com.software.SERVICE.PersonalDeclareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class PersonalDeclareServiceImpl implements PersonalDeclareService {

    /**
     个人的DeclareServiceImpl
     */

    @Autowired
    declareDao declareDao;

    @Autowired
    CorporationDao corporationDao;

    //根据用户id返回职称评审表list
    @Override
    public List<Declare> getDeclareByUserID(User user){
        int userID=user.getUserID();
        return declareDao.getDeclareByUserID(userID);
    }

    //根据用户id返回职称评状态表list，个人端无用
    @Override
    public List<Declare_check> getDeclareCheckListByUserId(User user){
        int userID=user.getUserID();
        return declareDao.getDeclareCheckListByUserId(userID);
    }

    //根据评审表id返回相应评审表
    @Override
    public Declare getDeclareByDeclareID(Declare declare){
        int declareID=declare.getDeclareID();
        return declareDao.getDeclareByDeclareID(declareID);
    }

    //根据评审表id返回相应评审表list
    @Override
    public List<Declare_check> getDeclareCheckListByDeclareId(Declare declare){
        int declareID=declare.getDeclareID();
        return declareDao.getDeclareCheckListByDeclareId(declareID);
    }

    //新建评审表
    @Override
    public void CreateDeclare(Declare declare,User user){
        int userID=user.getUserID();
        declare.setDeclareStatus(0);//未审核
        declare.setDeclareTime(new Date());
        declare.setUserID(userID);
        declareDao.InsertDeclare(declare);
    }

    //查询所有公司
    @Autowired
    public List<Corporation> FindAllCorporations(){
        return corporationDao.FindAllCorporations();
    }
}
