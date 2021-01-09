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

    @Override
    public List<Declare> getAllDeclare(){return declareDao.getAllDeclare();}

    @Override
    public List<Declare> getDeclareByUserID(int userID){return declareDao.getDeclareByUserID(userID); }

    @Override
    public Declare getDeclareByDeclareID(int declareID) {
        return null;
    }

    @Override
    public List<Declare> getDeclareByCorporationID(int corporationID) {
        return null;
    }

    @Override
    public List<Declare> getDeclareByCorID(int corID) {
        return null;
    }

}
