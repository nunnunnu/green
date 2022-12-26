package com.green.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/detail") //기본경로 설정
public class DetailController {
    @ GetMapping("/") //RequestMapping이 있으면 /까지 쳐줘야함. 
    public String getDetail(){
        return "/detail/detail.html";
    }
}
