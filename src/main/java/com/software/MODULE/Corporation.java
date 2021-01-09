package com.software.MODULE;


import lombok.Data;

@Data
public class Corporation {
    int corporationId;
    String account;
    String password;
    String corporationName;
    String corporationPerson;
    int corporationLevel;
    int corporationType;
    String corporationMandator;
    String corporationLocation;
    String corporationAddress;
    String pic1;
    String pic2;
    String pic3;

    String corporationType_str;
    public String getcorporationType_str() {
        switch (corporationType) {
            case 1:
                corporationType_str = "公有单位";
                break;
            case 2:
                corporationType_str = "非公有单位";
                break;
        }
        return corporationType_str;
    }

    String corporationLevel_str;
    public String getcorporationLevel_str() {
        switch (corporationLevel) {
            case 1:
                corporationLevel_str = "区属";
                break;
            case 2:
                corporationLevel_str = "省属";
                break;
        }
        return corporationLevel_str;
    }
}
