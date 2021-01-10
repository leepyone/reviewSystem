package com.software.SERVICE.impl;

import com.software.DAO.declareDao;
import com.software.MODULE.Declare;
import com.software.SERVICE.PersonalDeclareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonalDeclareServiceImpl implements PersonalDeclareService {

    @Autowired
    declareDao declareDao;

    //根据用户id返回职称评审表list
    @Override
    public List<Declare> getDeclareByUserID(int userID){

    }

    //根据用户id返回职称评状态表list

    //根据评审表id返回相应评审表
    @Override
    public Declare getDeclareByDeclareID(int declareID){

    }

    //新建评审表
    @Override
    public void CreateDeclare(Declare declare){

    }
}
