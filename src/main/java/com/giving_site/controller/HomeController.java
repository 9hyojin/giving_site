package com.giving_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping("/introduce")
    public String introduce(){

        return "introduce";
    }

    @GetMapping("/teacher")
    public String teacher(){

        return "teacher";
    }

    @GetMapping("/student")
    public String student(){

        return "student";
    }

    @GetMapping("/login")
    public String login(){

        return "login";
    }

}
