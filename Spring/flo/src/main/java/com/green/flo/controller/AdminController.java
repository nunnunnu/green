package com.green.flo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.green.flo.service.AdminService;
import com.green.flo.vo.AdminAddVo;
import com.green.flo.vo.AdminLoginVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

     @Value("${flo.file.adminImg}") String adminImgPath;
     
     @Autowired AdminService adminService;

     @PostMapping("/login")
     public String postAdminLogin(AdminLoginVO login, HttpSession session, Model model){

          Map<String, Object> resultMap = adminService.loginAdmin(login);
          if((Boolean)resultMap.get("status")){
               session.setAttribute("loginUser", resultMap.get("login"));
               return "redirect:/main";
          }else{
               model.addAttribute("message", resultMap.get("message"));
               return "/index";
          }
     }
     @GetMapping("/logout")
     public String getLogout(HttpSession session){
          session.invalidate();
          return "redirect:/";
     }

     @GetMapping("/add")
     public String getAddAdmin(){

          return "/admin/add";
     }
     @PostMapping("/add")
     public String postAddAdmin(AdminAddVo data, Model model/* , @RequestPart MultipartFile adminImg */){
          Map<String, Object> map =adminService.addAdmin(data);
          if((boolean)map.get("status")){
               return "redirect:/";
          }
          model.addAttribute("inputdata", data);
          model.addAttribute("message", map.get("message"));
          return "/admin/add";
     }

     @GetMapping("/list")
     public String getAdminList(Model model, @RequestParam @Nullable String keyword, 
          @PageableDefault(size=10, sort="adminSeq", direction=Sort.Direction.DESC) Pageable pageable
     ){
               //size - 한페이지 당 출력할 row 수
               //sort - 정렬기준이 될 엔티티 변수명
               //direction - 정렬 방향(오름차순이 기본값임)
               
          if(keyword==null){
               keyword="";
          }
          model.addAttribute("result", adminService.getAdminList(keyword, pageable));
          model.addAttribute("keyword", keyword);
          return "/admin/list";
     }
     @GetMapping("/update/status")
     public String getAdminUpdateStatus(@RequestParam Integer value, @RequestParam Long admin_no, @RequestParam @Nullable String keyword, @RequestParam Integer page){
          adminService.updateAdminStatus(value, admin_no);
          String returnValue="";
          if(keyword==null || keyword.equals("")){
               returnValue="redirect:/admin/list?page="+page;
          }else{
               returnValue = "redirect:/admin/list?page="+page+"&keyword="+keyword;
          }
          return returnValue;
     }
     
     @GetMapping("/delete")
     public String getAdminDelete(@RequestParam Long admin_no, @RequestParam @Nullable String keyword, @RequestParam Integer page){
          adminService.deleteAdmin(admin_no);
          String returnValue="";
          if(keyword==null || keyword.equals("")){
               returnValue="redirect:/admin/list?page="+page;
          }else{
               returnValue = "redirect:/admin/list?page="+page+"&keyword="+keyword;
          }
          return returnValue;
     }

     @GetMapping("/detail")
     public String getAdminDetail(@RequestParam Long admin_no, Model model){
          model.addAttribute("admin_detail", adminService.getAdminInfo(admin_no));
          return "/admin/detail";
     }
}
