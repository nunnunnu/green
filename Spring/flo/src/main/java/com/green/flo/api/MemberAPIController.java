package com.green.flo.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.flo.entity.MemberInfoEntity;
import com.green.flo.repository.MemberInfoRepository;
import com.green.flo.vo.LoginVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberAPIController {

     private final MemberInfoRepository memberInfoRepository; //이거하면 autowired생략가능함

     @PostMapping("/login")
     public Map<String, Object> postMemberLogin(@RequestBody LoginVO login){
          Map<String, Object> map = new LinkedHashMap<>();

          MemberInfoEntity entity = memberInfoRepository.findByMiIdAndMiPwd(login.getId(), login.getPwd());

          if(entity==null){
               map.put("status", false);
               map.put("message", "잘못된 로그인 정보입니다.");
          }else{
               map.put("status", true);
               map.put("user", entity);
          }

          return map;
     }
}
