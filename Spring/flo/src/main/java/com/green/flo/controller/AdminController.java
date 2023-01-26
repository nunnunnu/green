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
import com.green.flo.vo.AdminInfoVO;
import com.green.flo.vo.AdminLoginVO;
import com.green.flo.vo.AdminUpdateVO;

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
     @PageableDefault(size=10, sort="adminSeq", direction=Sort.Direction.DESC) Pageable pageable, HttpSession session
     ){
          //size - 한페이지 당 출력할 row 수
          //sort - 정렬기준이 될 엔티티 변수명
          //direction - 정렬 방향(오름차순이 기본값임)

          session.setAttribute("update_result", null); //비밀번호 글자 수 오류때문에 리스트로 들어왔을때 에러메세지 날림
          AdminInfoVO admin = (AdminInfoVO)session.getAttribute("loginUser");
          if(admin==null){
               return "redirect:/"; //로그인상태가 아니면 로그인페이지로
          }else if(admin.getAdmin_grade()!=99){
               return "redirect:/main"; //마스터계정이아니면 메인페이지로
          }
               
          if(keyword==null){
               keyword="";
          }
          model.addAttribute("result", adminService.getAdminList(keyword, pageable));
          model.addAttribute("keyword", keyword);
          return "/admin/list";
     }
     @GetMapping("/update/status")
     public String getAdminUpdateStatus(@RequestParam Integer value, @RequestParam Long admin_no, @RequestParam @Nullable String keyword, @RequestParam Integer page, HttpSession session){
          AdminInfoVO admin = (AdminInfoVO)session.getAttribute("loginUser");
          if(admin==null){
               return "redirect:/"; //로그인상태가 아니면 로그인페이지로
          }else if(admin.getAdmin_grade()!=99){
               return "redirect:/main"; //마스터계정이아니면 메인페이지로
          }
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
     public String getAdminDelete(@RequestParam Long admin_no, @RequestParam @Nullable String keyword, @RequestParam Integer page, HttpSession session){
          AdminInfoVO admin = (AdminInfoVO)session.getAttribute("loginUser");
          if(admin==null){
               return "redirect:/"; //로그인상태가 아니면 로그인페이지로
          }else if(admin.getAdmin_grade()!=99){
               return "redirect:/main"; //마스터계정이아니면 메인페이지로
          }
          
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
     public String getAdminDetail(@RequestParam Long admin_no, Model model, HttpSession session){
          AdminInfoVO admin = (AdminInfoVO)session.getAttribute("loginUser");
          if(admin==null){
               return "redirect:/"; //로그인상태가 아니면 로그인페이지로
          }else if(admin.getAdmin_grade()!=99){
               return "redirect:/main"; //마스터계정이아니면 메인페이지로
          }
          model.addAttribute("admin_detail", adminService.getAdminInfo(admin_no));
          return "/admin/detail";
     }

     @PostMapping("/update")
     public String postAdminUpdate(AdminUpdateVO data, HttpSession session){
          Map<String, Object> map = adminService.updateAdminInfo(data);

          if((boolean)map.get("status")){
               return "redirect:/admin/list";
          }
          session.setAttribute("update_result", map);
          return "redirect:/admin/detail?admin_no="+data.getSeq();
     }
}
