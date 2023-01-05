package com.greenart.testproject.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
     @GetMapping("/")
     public String getMain(Model model, HttpSession session){
          //Model - 데이터를 실어나르는 박스(데이터 컨텍스트)
          model.addAttribute("hello", "Hello World!!");
          //웹페이지 파일이 로드되기전에 생성됨
          session.setAttribute("sessionValue", "세션에 추가된 값");
          //백엔드 시스템에서, 세션무효화를 실행했을때 세션을 다시만든다.

          return "/index";
     }

     @GetMapping("/index")
     public String getIndex(Model model){
          model.addAttribute("hello", "@GetMapping(\"index\")를 통한 응답");
          return "/index";
     }
     @GetMapping("/invalidate")
     public String getInvalidate(HttpSession session){
          session.invalidate(); //세션 초기화
          return "redirect:/index";
          //index는 endpoint에서 찾음
     }
}
