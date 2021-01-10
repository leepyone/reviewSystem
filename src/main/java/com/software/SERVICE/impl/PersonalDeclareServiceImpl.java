package com.software.SERVICE.impl;

import com.software.DAO.declareDao;
import com.software.MODULE.Declare;
import com.software.MODULE.Declare_check;
import com.software.MODULE.User;
import com.software.SERVICE.PersonalDeclareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonalDeclareServiceImpl implements PersonalDeclareService {

    /**
     个人的DeclareServiceImpl
     */

    @Autowired
    declareDao declareDao;

    //根据用户id返回职称评审表list
    @Override
    public List<Declare> getDeclareByUserID(User user){
        int userID=user.getUserID();
        return declareDao.getDeclareByUserID(userID);
    }

    //根据用户id返回职称评状态表list
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

    //根据评审表id返回相应评审状态表
    @Override
    public Declare_check getDeclareCheckByDeclareId(Declare declare){
        int declareID=declare.getDeclareID();
        return declareDao.getDeclareCheckByDeclareId(declareID);
    }

    //新建评审表
    @Override
    public void CreateDeclare(Declare declare, User user){
        declareDao.InsertDeclare(declare);
        int declareId=declare.getDeclareID();

        //初始化对应Declare_check对象
        Declare_check declareCheck=new Declare_check();
        declareCheck.setDeclareId(declareId);
        declareCheck.setUserId(user.getUserID());

        declareDao.InsertDeclareCheck(declareCheck);
    }
}
