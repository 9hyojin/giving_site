package com.giving_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignUpConroller {

    @GetMapping("/teacherSignUp")
    public String teacherSignUp(){
        return "/signUp/teacherSignUp";
    }

    @GetMapping("/studentSignUp")
    public String studentSignUp(){
        return "/signUp/studentSignUp";
    }


}
