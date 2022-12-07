package com.giving_site.controller;

import com.giving_site.dto.TeacherDTO;
import com.giving_site.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/signUp")
    public String signUp(){
        return "/signUp/signUp";
    }

    @GetMapping("/teacherSignUp")
    public String saveForm(){
        return "/signUp/teacherSignUp";
    }


    @PostMapping("/teacherSignUp")
    public String save(@ModelAttribute TeacherDTO teacherDTO) {
        teacherService.save(teacherDTO);
        return "/view/loginForm";
    }


    @GetMapping("/login")
    public String loginForm(){
        return"/view/loginForm";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute TeacherDTO teacherDTO, HttpSession session) {
        TeacherDTO loginResult = teacherService.login(teacherDTO);
        if (loginResult != null) {
            //로그인성공
            session.setAttribute("loginId", loginResult.getUserId());
        } else {
            //로그인실패
        }
        return "login";
    }
}
