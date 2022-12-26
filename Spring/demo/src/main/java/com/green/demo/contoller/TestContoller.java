package com.green.demo.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.green.demo.data.UserInfo;

@Controller
public class TestContoller {
    @GetMapping("/test")
    public String getTest(Model model){
        UserInfo u = new UserInfo();
        u.id="user001";
        u.name = "parkjinhee";
        model.addAttribute("user", u);
        return "pages/test";
    }
    @GetMapping("/testmvc")
    public String testMVC(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "pages/testtemplates";
    }
    @GetMapping("/testapi")
    @ResponseBody //html없미 return을 그대로 표시해줌
    public String getapi(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("/testapi2")
    @ResponseBody
    public hello helloapi(@RequestParam("name") String name){
        hello h = new hello();
        h.setname(name);
        return h;
    }
    static class hello{
        private String name;
        public String getname() {
            return name;
        }
        public void setname(String name){
            this.name = name;
        }
    }   
}
