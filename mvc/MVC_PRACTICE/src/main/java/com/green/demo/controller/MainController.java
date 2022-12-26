package com.green.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.green.demo.entity.UserEntity;
import com.green.demo.repository.UserRepository;

@Controller
public class MainController {

    @Autowired UserRepository uRepository;
    @GetMapping("/") //접근 경로 - 브라우저 주소창에 입력
    public String getMain(Model model){
        model.addAttribute("name", "myName");
        List<UserEntity> list = uRepository.findAll();

        model.addAttribute("list", list);

        return "index"; //실행할 파일 경로 - 프로젝트 내에 파일이 있는 위치
        //application에서 설정한 곳에 따라 classpath:/templates/index.html 로 자동으로 경로 지정해줌
    }
    @GetMapping("/index") //진입 위치가 index라고해서 꼭 index.html이 불러와지는 것은 아님
    public String getIndex(){
        return "htmls/another";
    }
}
