package com.example.security_test.api;

import com.example.security_test.mapper.MemberMapper;
import com.example.security_test.vo.MemberJoinVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/member")
public class MemberApiController {
    @Autowired
    MemberMapper mapper;
    @PostMapping("/join")
    public ResponseEntity<Object> postMemberJoin(@RequestBody MemberJoinVO data){
        mapper.insertMember(data);
        return  new ResponseEntity<>(null, HttpStatus.OK);
    }
}
