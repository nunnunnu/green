package com.green.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.green.demo.VO.UserInfoVO;
import com.green.demo.entity.UserEntity;
import com.green.demo.repository.UserRepository;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired UserRepository uRepo;
    @GetMapping("/join")
    public String getMemberJoin(){
        return "/member/join";
    }
    @PostMapping("/join")
    public String postMemberJoin(UserInfoVO data, Model model){
        System.out.println(data);
        if(uRepo.countByUiId(data.getId())>0){
            model.addAttribute("dup_id", data.getId());
            return "/member/duplicated";
        }
        UserEntity entity = new UserEntity(null, data.getId(), data.getPwd(), data.getNickname());
        System.out.println(entity);
        uRepo.save(entity);
        return "member/joined";
    }
}
