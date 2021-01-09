package com.software.MODULE;


import lombok.Data;

@Data
public class title_judge {
    int judgeId;
    int userId;
    int corporationId;
    String judgeZgb;
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
}
