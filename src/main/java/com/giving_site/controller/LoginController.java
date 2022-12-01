package com.giving_site.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.giving_site.dto.TeacherDTO;
import com.giving_site.model.KakaoProfile;
import com.giving_site.model.OAuthToken;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.security.AuthProvider;


@Controller
public class LoginController {
//
//    @GetMapping("/login-form")
//    public String loginForm(){
//
//        return "/view/loginForm";
//    }
//
//    @PostMapping("/login")
//    public String login(@ModelAttribute TeacherDTO teacherDTO){
//        boolean loginResult = teacherService.login(teacherDTO);
//        if (loginResult){
//            return "/view/home";
//        } else{
//            return "/view/loginForm";
//        }









    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String kakaoCallback(String code) {

        //POST방식으로 key=value 데이터를 카카오쪽으로 요청
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type"," application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
        params.add("grant_type","authorization_code");
        params.add("client_id","4a11325f69a14397d97122888cf676f4");
        params.add("redirect_uri","http://localhost:8090/auth/kakao/callback");
        params.add("code",code);

        //HttpHeader 와 HttpBody를 하나의 오브젝트에 담기
        HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = new HttpEntity<>(params,headers);


        //Http 요청하기 - Post방식으로, 그리고 response 변수의 응답받음
        ResponseEntity<String> response = restTemplate.exchange(
                "https://kauth.kakao.com/oauth/token", HttpMethod.POST,kakaoTokenRequest,String.class);

        //ObjectMapper => java 와 json 바꾸는 라이브러리
        ObjectMapper objectMapper = new ObjectMapper();
        OAuthToken oauthToken = null;
        try{
            oauthToken = objectMapper.readValue(response.getBody(),OAuthToken.class);
        } catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        System.out.println("카카오엑세스토큰:" +oauthToken.getAccess_token());



        RestTemplate restTemplate2 = new RestTemplate();
        HttpHeaders headers2 = new HttpHeaders();
        headers2.add("Authorization","Bearer "+oauthToken.getAccess_token());
        headers2.add("Content-type"," application/x-www-form-urlencoded;charset=utf-8");


        HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest = new HttpEntity<>(headers2);


        ResponseEntity<String> response2 = restTemplate2.exchange(
                "https://kapi.kakao.com//v2/user/me", HttpMethod.POST,kakaoProfileRequest,String.class);



        ObjectMapper objectMapper2 = new ObjectMapper();
        KakaoProfile kakaoProfile = null;
        try{
            kakaoProfile = objectMapper2.readValue(response2.getBody(),KakaoProfile.class);
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        System.out.println("카카오아이디: " +kakaoProfile.getId());
        System.out.println("카카오이메일: " +kakaoProfile.getKakao_account().getEmail());


        return (String) response2.getBody();
    }

    @GetMapping ("/signUp")
    public String signUp(){
        return "/signUp/signUp";
    }

}
