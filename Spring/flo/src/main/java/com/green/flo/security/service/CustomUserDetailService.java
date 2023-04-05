package com.example.security_test.security.service;

import com.example.security_test.mapper.MemberMapper;
import com.example.security_test.vo.entity.MemberInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final MemberMapper memberMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return createUserDetails(memberMapper.getMemberInfoByMemberId(username)); //자동실행 메소드
    }
    public UserDetails createUserDetails(MemberInfoVO member) {
        return User.builder().username(member.getMi_id())
                .password(passwordEncoder.encode(member.getMi_pwd()))
                .roles(member.getMi_role())
                .build(); //저장
    }
}

