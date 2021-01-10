package com.software.SERVICE;

import com.software.MODULE.Declare;

import java.util.List;

public interface PersonalDeclareService {

    /**
     个人的DeclareService
     */

    //根据用户id返回职称评审表list
    public List<Declare> getDeclareByUserID(int userID);

    //根据用户id返回职称评状态表list


    //根据评审表id返回相应评审表
    public Declare getDeclareByDeclareID(int declareID);

    //新建评审表
    public void CreateDeclare(Declare declare);

}
