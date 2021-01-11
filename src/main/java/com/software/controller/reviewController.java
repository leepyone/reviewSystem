package com.software.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class reviewController {

    @RequestMapping("/toReviewCodePage")
    public String  toManagePage(){

        return "ReviewCodeManage";
    }

}
