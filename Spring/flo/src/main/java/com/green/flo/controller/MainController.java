package com.green.flo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
     
     @GetMapping("/")
     public String getIndex(HttpSession session){
          if(session.getAttribute("loginUser")!=null){
               return "redirect:/main";
          }
          return "/index"; //절대경로 표시방법 /templates/views//index.html이나 내부적으로 //는 /하나로 만들어줌
          // return "index"; //상대경로 표시방법(헷갈림) 이상황에서는 둘다 되긴 함
     }

     @GetMapping("/main")
     public String getMain(){
          return "/main";
     }
}