package com.software.MODULE;


import lombok.Data;

@Data
public class corporation_worker {

    private int corporationId;
    private int userID;
    private int userStatus;//0、禁用；1、启用

    public corporation_worker(){}
    public corporation_worker(int corporationId, int userID, int userStatus) {
        this.corporationId = corporationId;
        this.userID = userID;
        this.userStatus = userStatus;
    }
}
