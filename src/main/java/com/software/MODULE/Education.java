package com.software.MODULE;


import lombok.Data;

import java.util.Date;

@Data
public class Education {
    int userID;
    int educationID;
    String educationGraduationProject;
    String educationLevel;
    String educationSchool;
    String educationMajor;
    Date educationGraduationTime;
}
