package com.software.MODULE;


import lombok.Data;

@Data
public class User {
    int userID;//用户号
    String userNumber;//注册账号
    String userPassword;//注册密码
    String userName;//用户姓名
    int userType;//用户类别
    int userCorpID;//单位ID
    String userIdentifyID;//身份证号
    String userPhone;//手机号

    String userType_str;
    public String getuserType_str() {
        switch (userType){
            case 1:userType_str="个人";break;
            case 2:userType_str="单位工作人员";break;
            case 3:userType_str="单位管理人员";break;
            case 4:userType_str="审查人员";break;
        }
        return userType_str;
    }
}
