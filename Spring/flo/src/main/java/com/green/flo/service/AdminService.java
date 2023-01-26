package com.green.flo.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.green.flo.entity.AdminEntity;
import com.green.flo.repository.AdminRepository;
import com.green.flo.vo.AdminAddVo;
import com.green.flo.vo.AdminInfoVO;
import com.green.flo.vo.AdminLoginVO;
import com.green.flo.vo.AdminUpdateVO;

@Service
public class AdminService {
     @Autowired AdminRepository adminRepository;

     public Map<String, Object> loginAdmin(AdminLoginVO login){
          Map<String, Object> map = new LinkedHashMap<>();
          
          AdminEntity entity = adminRepository.findByAdminIdAndAdminPwd(login.getAdmin_id(), login.getAdmin_pwd());
          if(entity==null){
               map.put("status", false);
               map.put("message", "아이디 혹은 비밀번호 오류입니다.");
          }else if(entity.getAdminStatus()==1){
               map.put("status", false);
               map.put("message", "등록 대기중인 관리자 계정입니다.");
          }else if(entity.getAdminStatus()==3){
               map.put("status", false);
               map.put("message", "이용 정지된 관리자 계정입니다.");
          }else{
               map.put("status", true);
               map.put("message", "정상 로그인 되었습니다.");
               map.put("login", new AdminInfoVO(entity));
          }
          return map;
     }
     
     public Map<String, Object> addAdmin(AdminAddVo data){
          Map<String, Object> map = new LinkedHashMap<>();
          if(data.getId()==null){
               map.put("status", false);
               map.put("message", "아이디를 입력하세요");
          }else if(adminRepository.countByAdminId(data.getId())!=0){
               map.put("status", false);
               map.put("message", data.getId()+"은/는 이미 사용중인 아이디입니다.");
          }else if(data.getPwd()==null || data.getPwd().equals("")){
               map.put("status", false);
               map.put("message", "비밀번호를 입력하세요");
          }else if(data.getName()==null || data.getName().equals("")){
               map.put("status", false);
               map.put("message", "이름을 입력하세요");
          }else{
               AdminEntity entity = AdminEntity.builder().adminId(data.getId()).adminPwd(data.getPwd())
               .adminName(data.getName()).adminGrade(data.getType()).adminStatus(1).build();
               entity = adminRepository.save(entity);
               map.put("status", true);
               map.put("message", "관리자 계정 등록 신청 완료");
          }
          return map;
     }

     public Map<String, Object> getAdminList(String keyword, Pageable pageable) {
          Page<AdminEntity> page = adminRepository.findByAdminIdContains(keyword, pageable);
          Map<String, Object> map = new LinkedHashMap<>();
          map.put("list", page.getContent());
          map.put("total", page.getTotalElements());
          map.put("totalPage", page.getTotalPages());
          map.put("currentPage", page.getNumber());
          return map;
     }

     public void updateAdminStatus(Integer value, Long admin_seq) {
          AdminEntity entity = adminRepository.findById(admin_seq).get();
          entity.setAdminStatus(value);
          adminRepository.save(entity);

     }

     public void deleteAdmin(Long admin_no) {
          AdminEntity entity = adminRepository.findById(admin_no).get();
          adminRepository.delete(entity);
     }

     public AdminEntity getAdminInfo(Long admin_no){
          return adminRepository.findById(admin_no).get();
     }

     public Map<String, Object> updateAdminInfo(AdminUpdateVO data) {
          Map<String, Object> map = new LinkedHashMap<>();
          Optional<AdminEntity> entity = adminRepository.findById(data.getSeq());
          String pattern = "^[0-9|a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]*$"; //정규표현식, 특수문자, 공백 제외 허용
          if(entity.isEmpty()){
               map.put("status", false);
               map.put("message", "잘못된 사용자 정보가 입력되었습니다.");
          }else if(data.getPwd().length()>16 || data.getPwd().length()<8){
               map.put("status", false);
               map.put("message", "비밀번호는 8~16자리로 입력해주세요.");
          }else if(data.getPwd().replaceAll(" ", "").length()==0 ||
               !Pattern.matches(pattern, data.getPwd())
          ){
               map.put("status", false);
               map.put("message", "비밀번호에 특수문자 또는 공백을 사용할 수 없습니다.");
          }else if(data.getName().replaceAll(" ", "").length()==0 ||
               !Pattern.matches(pattern, data.getName())
          ){
               map.put("status", false);
               map.put("message", "관리자 이름에 특수문자 또는 공백을 사용할 수 없습니다.");
          }else{
               AdminEntity e = entity.get();
               e.setAdminPwd(data.getPwd());
               e.setAdminName(data.getName());
               e.setAdminStatus(data.getStatus());
               e.setAdminGrade(data.getGrade());
               adminRepository.save(e);
               map.put("status", true);
          }

          
          
          return map;
     }




}
