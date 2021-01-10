package com.software.MODULE;


import lombok.Data;

@Data
public class title_judge {
    int judgeId;
    int userId;
    int corporationId;
    String judgeZgb;
    int judgeStatus;
    String judgeYear;
    String userName;
    String userIdentifyNumber;
    int judgeLevel;
    int userLevel;
    String judgeTitle;
    String judgeMajor;
    String picPerson;
    String picIdc1;
    String picIdc2;
    String workSum;
    String laborContract;


    String judgeLevel_str;
    public String getjudgeLevel_str() {
        switch (judgeLevel) {
            case 1:
                judgeLevel_str = "初级";
            case 2:
                judgeLevel_str = "中级";
                break;
            case 3:
                judgeLevel_str = "副高";
                break;
            case 4:
                judgeLevel_str = "正高";
                break;
        }
        return judgeLevel_str;
    }

    String userLevel_str;
    public String getuserLevel_str() {
        switch (userLevel) {
            case 1:
                userLevel_str = "事业单位人员";
            case 2:
                userLevel_str = "机关、事业单位非在编人员";
                break;
            case 3:
                userLevel_str = "自由职业者";
                break;
        }
        return userLevel_str;
    }

    String judgeStatus_str;
    public String getjudgeStatus_str() {
        switch (judgeStatus) {
            case 1:
                judgeStatus_str = "事业单位人员";
            case 2:
                judgeStatus_str = "机关、事业单位非在编人员";
                break;
            case 3:
                judgeStatus_str = "自由职业者";
                break;
        }
        return judgeStatus_str;
    }

    public title_judge(){}

    public title_judge(int judgeId, int userId, int corporationId, String judgeZgb, int judgeStatus, String judgeYear, String userName, String userIdentifyNumber, int judgeLevel, int userLevel, String judgeTitle, String judgeMajor, String picPerson, String picIdc1, String picIdc2, String workSum, String laborContract, String judgeLevel_str, String userLevel_str, String judgeStatus_str) {
        this.judgeId = judgeId;
        this.userId = userId;
        this.corporationId = corporationId;
        this.judgeZgb = judgeZgb;
        this.judgeStatus = judgeStatus;
        this.judgeYear = judgeYear;
        this.userName = userName;
        this.userIdentifyNumber = userIdentifyNumber;
        this.judgeLevel = judgeLevel;
        this.userLevel = userLevel;
        this.judgeTitle = judgeTitle;
        this.judgeMajor = judgeMajor;
        this.picPerson = picPerson;
        this.picIdc1 = picIdc1;
        this.picIdc2 = picIdc2;
        this.workSum = workSum;
        this.laborContract = laborContract;
        this.judgeLevel_str = judgeLevel_str;
        this.userLevel_str = userLevel_str;
        this.judgeStatus_str = judgeStatus_str;
    }
}
