package com.software.MODULE;


import lombok.Data;

@Data
public class User {
    int userID;//用户号id
    //唯一
    String userNumber;//注册账号
    String userPassword;//注册密码
    String userName;//用户姓名
    int userType;//用户类别
    int userCorpID;//单位ID
    //唯一
    String userIdentifyID;//身份证号
    //唯一
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
    public User(){}
    public User(int userID, String userNumber, String userPassword, String userName, int userType, int userCorpID, String userIdentifyID, String userPhone) {
        this.userID = userID;
        this.userNumber = userNumber;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userType = userType;
        this.userCorpID = userCorpID;
        this.userIdentifyID = userIdentifyID;
        this.userPhone = userPhone;

    }

}
