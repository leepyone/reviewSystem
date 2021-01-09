package com.software.MODULE;


import lombok.Data;

import java.util.Date;

@Data
public class Judge_check {
    int checkId;
    Date checkDate;
    int judgeId;
    int userId;
    String checkOppions;
    int checkStatus;


    String checkStatus_str;
    public String getcheckStatus_str() {
        switch (checkStatus) {
            case 0:
                checkStatus_str = "未审核";
            case 1:
                checkStatus_str = "退回修改";
                break;
            case 2:
                checkStatus_str = "审核不通过";
                break;
            case 3:
                checkStatus_str = "审核通过";
                break;
        }
        return checkStatus_str;
    }
}
