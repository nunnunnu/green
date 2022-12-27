package com.greenart.book_info.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenart.book_info.VO.AdminAccountVo;
import com.greenart.book_info.entity.AdminAccountEntity;
import com.greenart.book_info.repository.AdminAccountRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
     
     // String blank_pattern = "/[\s]/g";
     
     @Autowired AdminAccountRepository aRepo;
     
     @GetMapping("/join") //requestMapping
     public String getMemberJoin(){
          return "/member/join"; //application.properties prefix, suffix기준
     }
     @PostMapping("/join")
     public String postMemberJoin(String id, String pwd, String name, Model model){
          // String kor_pattern = ".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*";
          String eng_pattern = "^[a-zA-Z0-9]*$"; //영어, 숫자만 가능
          Pattern p = Pattern.compile(eng_pattern);
          if(!p.matcher(id).matches()){
               model.addAttribute("status", "invalidId");
               return "/member/join"; 
          }
          String pwd_pattern = "^[a-zA-Z0-9`~!@#$%^&*()-_=+]{6,20}$"; //영어, 숫자만 가능
          p = Pattern.compile(pwd_pattern);
          if(!p.matcher(pwd).matches()){
               model.addAttribute("status", "invalidPwd");
               return "/member/join"; 
          }

          // String replacedId = id.replaceAll(" ", ""); //문자열 공백 제거
          // if(id.length()!=replacedId.length()){ //공백이 있었다면 문자열의 길이가 달라짐
          //      model.addAttribute("status", "whitespaceId");
          //      return "/member/join"; 
          // }
          // String replacedPwd = pwd.replaceAll(" ", ""); //문자열 공백 제거
          // if(pwd.length()!=replacedPwd.length()){ //공백이 있었다면 문자열의 길이가 달라짐
          //      model.addAttribute("status", "whitespacePwd");
          //      return "/member/join"; 
          // }

          if(id.equals("") || id==null){
               model.addAttribute("status", "emptyId");
               model.addAttribute("id", id);
               model.addAttribute("name", name);
               return "/member/join"; 
          }
          if(pwd.equals("") || pwd==null){
               model.addAttribute("status", "emptyPwd");
               model.addAttribute("id", id);
               model.addAttribute("name", name);
               return "/member/join"; 
          }
          if(name.equals("") || name==null){
               model.addAttribute("status", "emptyName");
               model.addAttribute("id", id);
               model.addAttribute("name", name);
               return "/member/join"; 
          }
          if(aRepo.countByAiId(id)>0){
               model.addAttribute("id", id);
               model.addAttribute("name", name);
               model.addAttribute("status", "duplicated");
               return "/member/join"; 
          }else{
               AdminAccountEntity data = AdminAccountEntity.builder().aiId(id).aiPwd(pwd).aiName(name).build();
               aRepo.save(data);
          }
          return "/login"; //가입 성공하면 바로 로그인페이지로
     }
     @GetMapping("/list")
     public String getMemberList(Model model, Pageable pageable
     ){
          Page<AdminAccountEntity> page = aRepo.findAll(pageable);
          List<AdminAccountVo> result = new ArrayList<>();
          for(AdminAccountEntity a : page.getContent()){
               result.add(new AdminAccountVo(a));
          }
          model.addAttribute("accountList", result);
          model.addAttribute("totalPage", page.getTotalPages());
          model.addAttribute("totalCount", page.getTotalElements());
          model.addAttribute("getMemberJoin()", page.getNumber());
          return "member/list";
     }
     @GetMapping("/status")
     public String getMemberStatusUpdate(@RequestParam Long seq, @RequestParam Integer status){
          AdminAccountEntity entity = aRepo.findByAiSeq(seq); //select문
          entity.setAiStatus(status); //값 변경
          aRepo.save(entity); //ctrl + s
          // -> update
          return "redirect:/member/list";
     }
     @GetMapping("/delete")
     public String getMemberDelete(@RequestParam Long seq){
          AdminAccountEntity entity = aRepo.findByAiSeq(seq);
          aRepo.delete(entity); //삭제
          return "redirect:/member/list";
     }

}
