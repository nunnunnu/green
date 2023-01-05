package com.greenart.testproject.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greenart.testproject.main.entity.User;
import com.greenart.testproject.main.repository.UserRepository;
import com.greenart.testproject.main.vo.LoginUserVO;
import com.greenart.testproject.main.vo.LoginVo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
     
     @Autowired UserRepository userRepo; //위에 두는게 안전함

     @GetMapping("/login")
     public String getMemberLogin(HttpSession session, Model model){
          if(session.getAttribute("loginUser")!=null){
               return "redirect:/";
          }
          return "/member/login";
     }
     @PostMapping("/login")
     public String postMemberLogin(LoginVo data, Model model, HttpSession session){
          User entity = userRepo.findByUserIdAndUserPwd(data.getId(), data.getPwd());
          if(entity==null){
               model.addAttribute("message", "아이디 또는 비밀번호 오류입니다.");
               return "/member/login";
          }
          //로그인 성공 시 조회한 사용자의 정보를 세션에 등록한다.
          LoginUserVO user = new LoginUserVO(entity);
          session.setAttribute("loginUser", user);
          return "redirect:/";
     }
     @GetMapping("/join")
     public String getMemberJoin(Model model, HttpSession session){
          if(session.getAttribute("loginUser")!=null){
               return "redirect:/";
          }
          return "/member/join";
     }
     @PostMapping("/join")
     public String postMemberJoin(String id, String pwd, String name, Model model){
          if(userRepo.countByUserId(id)!=0){
               model.addAttribute("message", id+"은/는 이미 가입된 아이디입니다.");
               return "/member/join";
          }
          userRepo.save(User.builder().userId(id).userName(name).userPwd(pwd).build());
          return "redirect:/";
     }
     @GetMapping("/logout")
     public String getLogout(HttpSession session){
          session.invalidate();
          return "redirect:/";
     }
     @GetMapping("/info")
     public String getMemberInfo(HttpSession session){
          // if(session.getAttribute("loginUser")!=null){
          //      return "redirect:/";
          // }
          return "/member/info";
     }
     @PostMapping("/auth")
     public String postMemberAuth(String pwd, HttpSession session, Model model){
          LoginUserVO user = (LoginUserVO) session.getAttribute("loginUser");
          if(user!=null && userRepo.findByUserIdAndUserPwd(user.getId(), pwd)!=null){
               return "redirect:/member/detail";
          }
          model.addAttribute("message", "비밀번호가 틀렸습니다.");
          return "/member/info";
     }
     @GetMapping("/detail")
     public String getMemberDetail(){
          return "/member/detail";
     }
}
