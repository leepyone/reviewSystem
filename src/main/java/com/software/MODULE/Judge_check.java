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

    public Judge_check(){}

    public Judge_check(int checkId, Date checkDate, int judgeId, int userId, String checkOppions, int checkStatus, String checkStatus_str) {
        this.checkId = checkId;
        this.checkDate = checkDate;
        this.judgeId = judgeId;
        this.userId = userId;
        this.checkOppions = checkOppions;
        this.checkStatus = checkStatus;
        this.checkStatus_str = checkStatus_str;
    }
}
