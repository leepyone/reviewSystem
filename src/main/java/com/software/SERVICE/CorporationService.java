package com.software.SERVICE;

import com.software.MODULE.Corporation;
import com.software.MODULE.Declare_check;

public interface CorporationService {
    public Corporation FindCorporation(String corporationName);

    public void InsertCheck(Declare_check check);

    public boolean FindDelareID(int id);

    public void UpdateDeclareStatus(int declareID,int status);

}
