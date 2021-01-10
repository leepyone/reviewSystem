package com.software.MODULE;


import lombok.Data;

import java.util.Date;

@Data
public class Experience {
    int userID;
    int experienceID;
    Date experienceStarttime;
    Date experienceEndtime;
    String experienceInstitution;
    String experienceType;
    String experienceStatus;

    public Experience(){}

    public Experience(int userID, int experienceID, Date experienceStarttime, Date experienceEndtime, String experienceInstitution, String experienceType, String experienceStatus) {
        this.userID = userID;
        this.experienceID = experienceID;
        this.experienceStarttime = experienceStarttime;
        this.experienceEndtime = experienceEndtime;
        this.experienceInstitution = experienceInstitution;
        this.experienceType = experienceType;
        this.experienceStatus = experienceStatus;
    }
}
