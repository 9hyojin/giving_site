package com.giving_site.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

@Controller
public class LoginController {

    @GetMapping("/auth/kakao/callback")
    public @ResponseBody String kakaoCallback(String code){

        //POST방식으로 key=value 데이터를 카카오쪽으로 요청
        RestTemplate rt = new RestTemplate();
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
        ResponseEntity response = rt.exchange(
                "https://kauth.kakao.com/oauth/token", HttpMethod.POST,kakaoTokenRequest,String.class);



        return "카카오 토큰 요청 완료: 토큰요청에 대한 응답:"+response;
    }
}
