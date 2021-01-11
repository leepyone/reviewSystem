package com.software.SERVICE;

import com.software.MODULE.Corporation;
import com.software.MODULE.Declare_check;
import com.software.MODULE.User;
import com.software.MODULE.corporation_worker;

import java.util.List;

public interface CorporationService {
    public Corporation FindCorporation(String corporationName);

    public void InsertCheck(Declare_check check);

    public boolean FindDelareID(int id);

    public void UpdateDeclareStatus(int declareID,int status);

    public List<User> getWorkers(int corpID);

    public int FindUserStatus(int userID);

    public void DeleteUser(int userID);

    public int FindUserID(String userName);

}
