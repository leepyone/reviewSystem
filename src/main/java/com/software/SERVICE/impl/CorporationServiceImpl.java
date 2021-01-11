package com.software.SERVICE.impl;

import com.software.DAO.declareDao;
import com.software.DAO.userDao;
import com.software.MODULE.*;
import com.software.SERVICE.CorporationService;
import com.software.DAO.CorporationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorporationServiceImpl implements CorporationService {
    @Autowired
    private CorporationDao corporationDao;
    @Autowired
    private declareDao dao;
    @Autowired
    private userDao userDao;

    @Override
    public Corporation FindCorporation(String corporationName) {
        return corporationDao.FindCorporation(corporationName);
    }

    @Override
    public void InsertCheck(Declare_check check) {
        dao.InsertDeclareCheck(check);
    }

    @Override
    public boolean FindDelareID(int id) {
        if (dao.getDeclareByDeclareID(id).getDeclareID() == id)
            return true;
        else
            return false;
    }

    @Override
    public void UpdateDeclareStatus(int declareID,int status) { dao.setState(declareID,status); }

    @Override
    public List<User> getWorkers( int corpID ) { return corporationDao.getWorkers(corpID); }

    @Override
    public int FindUserStatus(int userID){ return corporationDao.getUserStatus(userID); }

    @Override
    public void DeleteUser(int userID) { userDao.changeUserCorpId(-1,userID); }

    @Override
    public int FindUserID(String userName){ return userDao.getUserID(userName); }
}
