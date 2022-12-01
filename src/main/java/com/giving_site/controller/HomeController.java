package com.giving_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(){

        return "/view/home";
    }

    @GetMapping("/introduce")
    public String introduce(){

        return "/view/introduce";
    }

    @GetMapping("/teacher")
    public String teacher(){

        return "/view/teacher";
    }

    @GetMapping("/together")
    public String together(){

        return "/view/together";
    }

//    @GetMapping("/login")
//    public String login(){
//
//        return "/view/login";
//    }


}
