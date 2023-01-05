package com.greenart.spring_test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
     @GetMapping("/")
     public String getMain(Model model, HttpSession session){
          model.addAttribute("data", "Hello World!!");
          session.setAttribute("greet", "welcome");
          return "/index";
     }
     @GetMapping("/index")
     public String getMain2(){
          return "/index";
     }
     @GetMapping("/greet")
     public String getGreet(){
          return "/greet";
     }
     @GetMapping("/login")
     public String getLogin(){
          return "/login";
     }
     @PostMapping("/login")
     public String postLoing(UserVO data, HttpSession session){
          if(data.getId().equals("user") && data.getPwd().equals("1234")){
               session.setAttribute("loginMessage", "로그인 되었습니다.");
               data.setName("사용자");
               session.setAttribute("loginUser", data);
               return "redirect:/";
          }else{
               session.setAttribute("loginMessage", "아이디 또는 비밀번호 오류입니다.");
               return "/login";
          }
     }
}
