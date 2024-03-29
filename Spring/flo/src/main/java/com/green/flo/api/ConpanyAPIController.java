package com.green.flo.api;

import com.green.flo.service.CompanyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/company")
public class ConpanyAPIController {
     @Autowired CompanyService companyService;

     @GetMapping("/list")
     public ResponseEntity<Object> getCompanyList(@RequestParam @Nullable String keyword, 
     @PageableDefault(size=10, sort="seq", direction=Sort.Direction.DESC) Pageable pageable,
          HttpSession session
     ){
          if(keyword==null){
               keyword="";
          }
          // model.addAttribute("result", companyService.getCompanyList(keyword, pageable));
          // model.addAttribute("keyword", keyword); //비동기방식이라서 keyword가 날아가지않아서 저장안해도됨
          return new ResponseEntity<>(companyService.getCompanyList(keyword, pageable), HttpStatus.OK);
     }

     @GetMapping("/detail")
     public ResponseEntity<Object> getCompanyDetail(@RequestParam Long no,
          @RequestParam @Nullable Integer page,
          @RequestParam @Nullable String keyword
     ){
          if(page==null){page=0;}
          if(keyword==null){keyword="";}
          Map<String, Object> map = companyService.selectCompanyInfo(no);
          // map.put("message", null);
          // model.addAttribute("company", map);
          // model.addAttribute("page", page);
          // model.addAttribute("keyword", keyword);
          if((Boolean)map.get("status")){
               return new ResponseEntity<>(map, HttpStatus.OK);
          }else{
               return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
          }
     }

     @PatchMapping("/{name}/{no}")
     public ResponseEntity<Object> postCompanyUpdate(@PathVariable Long no,@PathVariable String name){
          Map<String, Object> resultMap = companyService.updateCompanyInfo(no, name);
          
          return new ResponseEntity<>(resultMap, HttpStatus.ACCEPTED);
     }
     
     @PutMapping("/{name}")
     public ResponseEntity<Object> postCompanyAdd(@PathVariable String name){
          Map<String, Object> resultMap = companyService.addCompanyInfo(name);
          return new ResponseEntity<>(resultMap, HttpStatus.ACCEPTED);
     }
     @DeleteMapping("/{no}")
     public ResponseEntity<Object> getCompanyDelete(@PathVariable Long no){
          Map<String, Object> map = new LinkedHashMap<>();
          companyService.deleteCompany(no);
          map.put("message", "회사 정보를 삭제했습니다.");
          return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
     }
}
