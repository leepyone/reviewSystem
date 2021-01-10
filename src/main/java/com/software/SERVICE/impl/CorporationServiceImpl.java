package com.software.SERVICE.impl;

import com.software.DAO.declareDao;
import com.software.MODULE.Declare;
import com.software.MODULE.Declare_check;
import com.software.SERVICE.CorporationService;
import com.software.DAO.CorporationDao;
import com.software.MODULE.Corporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorporationServiceImpl implements CorporationService {
    @Autowired
    private CorporationDao corporationDao;
    @Autowired
    private declareDao dao;

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
}
