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

    @Override
    public List<Declare> getDeclareByUserName(String userName) {
        return declareDao.getDeclareByUserName(userName);
    }

    @Override
    public List<Declare> getDeclareByIdentifyNum(String identifyNum) { return declareDao.getDeclareByIdentifyNumber(identifyNum); }

    @Override
    public List<Declare> getDeclareByStatus(int status) {
        return declareDao.getDeclareByStatus(status);
    }

    @Override
    public List<Declare> getDeclareByLevel(int level) {
        return declareDao.getDeclareByLevel(level);
    }

    @Override
    public List<Declare> getDeclareByYear(String year){
        return declareDao.getDeclareByYear(year);
    }

    @Override
    public Declare findDeclare(int declareID) { return declareDao.getDeclareByDeclareID(declareID); }

    @Override
    public void deleteDeclare(int declareID){ declareDao.deleteDeclare(declareID); }

    @Override
    public List<Declare> getDeclareByUS(String userName,int status){ return declareDao.getDeclareByUS(userName,status); }
}
