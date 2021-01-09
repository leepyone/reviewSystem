package com.software.MODULE;


import lombok.Data;

import java.util.Date;

@Data
public class Declare {
    int declareID;
    int userID;
    String declareYear;
    String declareUserName;
    int corporationID;
    int declareCorID;//职改办ID
    String declareUserSex;
    String declareUserIdentifynumber;
    String declareUserBirthday;
    String declareUserNation;
    String declareUserHometown;
    String declareUserPhone;
    String declareUserEmail;
    int declareLevel;
    String declareProfessionalSeries;
    String declarePolitics;
    Date declareTime;
    String declareExplain;
    String declareInstitution;
    String declareCommunicate;
    String declareSetuptime;
    String declarePersoncharacter;
    String declareIsfirst;
    Date declareLasttime;
    Date declareWorktime;
    int declareTimelimit;//专业技术工作年限
    String declareMethod;
    int declareWenttime;//曾申报次数
    String declareCorperationLevel;
    String declarePoliticsPost;
    String declareQualification;
    String declareSeries;

    String declareLevel_str;
    public String getdeclareLevel_str() {
        switch (declareLevel) {
            case 1:
                declareLevel_str = "低级";
                break;
            case 2:
                declareLevel_str = "中级";
                break;
            case 3:
                declareLevel_str = "高级";
                break;
        }
        return declareLevel_str;
    }
}