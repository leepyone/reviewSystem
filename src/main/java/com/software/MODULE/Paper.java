package com.software.MODULE;


import lombok.Data;

import java.util.Date;

@Data
public class Paper {
    int userID;
    int paperID;
    Date paperDate;
    String paperType;
    String paperName;
    String paperPublication;
    String paperPart;

    public Paper(){}

    public Paper(int userID, int paperID, Date paperDate, String paperType, String paperName, String paperPublication, String paperPart) {
        this.userID = userID;
        this.paperID = paperID;
        this.paperDate = paperDate;
        this.paperType = paperType;
        this.paperName = paperName;
        this.paperPublication = paperPublication;
        this.paperPart = paperPart;
    }
}
