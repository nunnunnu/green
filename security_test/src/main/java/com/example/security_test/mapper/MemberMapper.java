package com.example.security_test.mapper;

import com.example.security_test.vo.MemberJoinVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    public void insertMember(MemberJoinVO data);
}
