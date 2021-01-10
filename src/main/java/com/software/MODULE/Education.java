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

    public Education(){}

    public Education(int userID, int educationID, String educationGraduationProject, String educationLevel, String educationSchool, String educationMajor, Date educationGraduationTime) {
        this.userID = userID;
        this.educationID = educationID;
        this.educationGraduationProject = educationGraduationProject;
        this.educationLevel = educationLevel;
        this.educationSchool = educationSchool;
        this.educationMajor = educationMajor;
        this.educationGraduationTime = educationGraduationTime;
    }
}
