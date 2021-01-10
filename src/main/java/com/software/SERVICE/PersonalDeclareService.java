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
    public List<Declare> getDeclareByUserID(User user);

    //根据用户id返回职称评状态表list
    public List<Declare_check> getDeclareCheckListByUserId(User user);

    //根据评审表id返回相应评审表
    public Declare getDeclareByDeclareID(Declare declare);

    //根据评审表id返回相应评审状态表
    public Declare_check getDeclareCheckByDeclareId(Declare declare);

    //新建评审表,user作为获取id的东西
    public void CreateDeclare(Declare declare, User user);

}
