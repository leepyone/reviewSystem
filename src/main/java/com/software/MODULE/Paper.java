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
}
