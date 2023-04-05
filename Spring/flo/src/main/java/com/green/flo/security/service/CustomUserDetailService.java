package com.green.flo.security.service;

import com.green.flo.entity.AdminEntity;
import com.green.flo.repository.AdminRepository;
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
    private final AdminRepository aRepo;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return createUserDetails(aRepo.findByAdminId(username)); //자동실행 메소드
    }
    public UserDetails createUserDetails(AdminEntity admin) {
        return User.builder().username(admin.getAdminId())
                .password(passwordEncoder.encode(admin.getAdminPwd()))
                .roles(admin.getAdminRole())
                .build(); //저장
    }
}

