package com.software.MODULE;

import lombok.Data;

import java.util.Date;

@Data
public class UserDetails {
    int userID;
    int userSex;
    Date userBirthday;
    String userHometown;
    String userLiveplace;
    String userEmail;
    String userQQ;
    String userProfile;
    String userEducation;//
    String userWorkexp;
    String userTitle;
    String userPhone;
    int politicsStatus;
    String userLanguage;
    String userSpecialty;
    String rewPub;
    String partTime;

    String politicsStatus_str;
    public String getpoliticsStatus_str() {
        switch (politicsStatus){
            case 1:politicsStatus_str="共产党员";break;
            case 2:politicsStatus_str="预备党员";break;
            case 3:politicsStatus_str="群众";break;
            case 4:politicsStatus_str="其他";break;
        }
        return politicsStatus_str;
    }
    public UserDetails(){}

    public UserDetails(int userID, int userSex, Date userBirthday, String userHometown, String userLiveplace, String userEmail, String userQQ, String userProfile, String userEducation, String userWorkexp, String userTitle, String userPhone, int politicsStatus, String userLanguage, String userSpecialty, String rewPub, String partTime) {
        this.userID = userID;
        this.userSex = userSex;
        this.userBirthday = userBirthday;
        this.userHometown = userHometown;
        this.userLiveplace = userLiveplace;
        this.userEmail = userEmail;
        this.userQQ = userQQ;
        this.userProfile = userProfile;
        this.userEducation = userEducation;
        this.userWorkexp = userWorkexp;
        this.userTitle = userTitle;
        this.userPhone = userPhone;
        this.politicsStatus = politicsStatus;
        this.userLanguage = userLanguage;
        this.userSpecialty = userSpecialty;
        this.rewPub = rewPub;
        this.partTime = partTime;
    }
}
