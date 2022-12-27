package com.greenart.book_info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.greenart.book_info.VO.LoginUserVO;
import com.greenart.book_info.entity.AdminAccountEntity;
import com.greenart.book_info.repository.AdminAccountRepository;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

     @Autowired AdminAccountRepository adminAccountRepository;

     @GetMapping("/")
     public String getMain(){
          System.out.println("GetMain()(❁´◡`❁)(●'◡'●)╰(*°▽°*)╯☆*: .｡. o(≧▽≦)o .｡.:*☆");
          return "/index";
     }
     @GetMapping("/login")
     public String getLogin(HttpServletResponse response){
          response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
          response.setHeader("Pragma", "no-cache");
          response.setHeader("Expires", "0"); //로그인 후 뒤로가기했을때 비밀번호가 뜨지않도록 캐시를 날림
          return "/login";
     }
     @PostMapping("/login")
     public String postLogin(String id, String pwd, Model model, HttpSession session){ 
          //session - 값들을 저장하는 저장소(전체서비스에서 한개 = 전역적임[전체영역에서 접근 가능])
          System.out.println(id);
          System.out.println(pwd);
          AdminAccountEntity loginUser = adminAccountRepository.findByAiIdAndAiPwd(id, pwd);
          //다른 URL로 들어가면 loginUser는 사용할 수 없음
          if(loginUser==null){
               model.addAttribute("loginStatus", "failed");
               model.addAttribute("message", "아이디 또는 비밀번호 오류입니다.");
               return "/login";
          }
          session.setAttribute("loginUser", new LoginUserVO(loginUser));
          //session은 다른 URL로 들어가도 사용가능
          return "redirect:/"; //로그인성공하면 메인화면으로(파일경로아니고 매핑경로 기준.)
     }
     
}
