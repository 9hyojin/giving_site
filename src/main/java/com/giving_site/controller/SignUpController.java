package com.giving_site.controller;

import com.giving_site.dto.TeacherDTO;
import com.giving_site.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class SignUpController {
    private final TeacherService teacherService;

    @GetMapping("/teacherSignUp")
    public String saveForm() {
        return "/signUp/teacherSignUp";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute TeacherDTO teacherDTO) {
        teacherService.save(teacherDTO);
        return "login";

    }

    @GetMapping("/login-form")
    public String loginForm() {

        return "/view/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute TeacherDTO teacherDTO, HttpSession session) {
        TeacherDTO loginResult = teacherService.login(teacherDTO);
        if (loginResult != null) {
            session.setAttribute("loginEmail", loginResult.getUserEMail());
            session.setAttribute("id", loginResult.getUserId());
            return "/view/home";
        } else {
            return "/view/loginForm";
        }

    }
}
//    @GetMapping("/teacherSignUp")
//    public String teacherSignUp(){
//        return "/signUp/teacherSignUp";
//    }
//
//    @GetMapping("/studentSignUp")
//    public String studentSignUp(){
//        return "/signUp/studentSignUp";
//    }

