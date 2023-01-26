package com.green.flo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.flo.service.CompanyService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/company")
public class CompanyController {

     @Autowired CompanyService companyService;

     @GetMapping("/list")
     public String getCompanyList(Model model, @RequestParam @Nullable String keyword, 
     @PageableDefault(size=10, sort="pubSeq", direction=Sort.Direction.DESC) Pageable pageable, HttpSession session){
          if(keyword==null){
               keyword="";
          }
          model.addAttribute("result", companyService.getCompanyList(keyword, pageable));
          model.addAttribute("keyword", keyword);
          return "/company/list";
     }
     @GetMapping("/add")
     public String getCompanyAdd(){

          return "/company/add";
     }
     @GetMapping("/detail")
     public String getCompanyDetail(@RequestParam Long company_no,
          @RequestParam @Nullable Integer page,
          @RequestParam @Nullable String keyword,
          Model model
     ){
          if(page==null){page=0;}
          if(keyword==null){keyword="";}
          Map<String, Object> map = companyService.selectCompanyInfo(company_no);
          map.put("message", null);
          model.addAttribute("company", map);
          model.addAttribute("page", page);
          model.addAttribute("keyword", keyword);
          return "/company/detail";
     }

     @PostMapping("/update")
     public String postCompanyUpdate(Long no, String name, Model model){
          Map<String, Object> resultMap = companyService.updateCompanyInfo(no, name);
          if((Boolean)resultMap.get("updated")){

               return "redirect:/company/list";
          }else{
               resultMap.put("status", true);
               model.addAttribute("company", resultMap);
               return "/company/detail";
          }
     }

     @PostMapping("/add")
     public String postCompanyAdd(String name, Model model){
          Map<String, Object> resultMap = companyService.addCompanyInfo(name);
          if((Boolean)resultMap.get("status")){

               return "redirect:/company/list";
          }else{
               model.addAttribute("name", name);
               model.addAttribute("result", resultMap);
               return "/company/add";
          }
     }
     @GetMapping("/delete")
     public String getCompanyDelete(@RequestParam Long company_no){
          companyService.deleteCompany(company_no);
          return "redirect:/company/list";
     }

}
