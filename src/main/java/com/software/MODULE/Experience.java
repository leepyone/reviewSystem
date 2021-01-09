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
}
