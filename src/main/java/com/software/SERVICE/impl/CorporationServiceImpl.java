package com.software.SERVICE.impl;

import com.software.SERVICE.CorporationService;
import com.software.DAO.CorporationDao;
import com.software.MODULE.Corporation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorporationServiceImpl implements CorporationService{
    @Autowired
    private CorporationDao corporationDao;

    @Override
    public Corporation FindCorporation(String corporationName){ return corporationDao.FindCorporation(corporationName); }
}
