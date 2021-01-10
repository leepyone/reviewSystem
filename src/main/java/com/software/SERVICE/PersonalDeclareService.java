package com.software.SERVICE;

import com.software.MODULE.Declare;
import com.software.MODULE.Declare_check;
import com.software.MODULE.User;

import java.util.List;

public interface PersonalDeclareService {

    /**
     个人的DeclareService
     */

    //根据用户id返回职称评审表list
    public List<Declare> getDeclareByUserID(int userID);

    //根据用户id返回职称评状态表list
    public List<Declare_check> getDeclareCheckListByUserId(int user_id);

    //根据评审表id返回相应评审表
    public Declare getDeclareByDeclareID(int declareID);

    //根据评审表id返回相应评审状态表


    //新建评审表,user作为获取id的东西
    public void CreateDeclare(Declare declare, User user);

}
