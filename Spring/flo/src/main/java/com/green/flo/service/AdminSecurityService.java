package com.green.flo.service;

import com.green.flo.entity.AdminEntity;
import com.green.flo.repository.AdminRepository;
import com.green.flo.security.provider.JwtTokenProvider;
import com.green.flo.security.service.CustomUserDetailService;
import com.green.flo.utils.AESAlgorithm;
import com.green.flo.vo.AdminInfoVO;
import com.green.flo.vo.LoginVO;
import com.green.flo.vo.response.AdminLoginResponseVO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminSecurityService {
    private final AdminRepository adminRepository;
    private final AuthenticationManagerBuilder authBuilder;
    private final JwtTokenProvider tokenProvider;
    private final CustomUserDetailService userDetailService;

    public AdminLoginResponseVO login(LoginVO login){
//        login.setPwd(AESAlgorithm.Encrypt(login.getPwd()));
        AdminEntity admin = adminRepository.findByAdminIdAndAdminPwd(login.getId(), login.getPwd());
        if(admin==null){
            return AdminLoginResponseVO.builder()
                    .status(false)
                    .message("아이디 또는 비밀번호 오류")
                    .code(HttpStatus.FORBIDDEN).build();
        }else if(!admin.isEnabled()){ //사용정지된 사용자
            return AdminLoginResponseVO.builder()
                    .status(true)
                    .message("이용정지된 사용자입니다.")
                    .code(HttpStatus.FORBIDDEN)
                    .build();

        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(admin.getAdminId(), admin.getAdminPwd());

        Authentication authentication = authBuilder.getObject().authenticate(authenticationToken);
        return AdminLoginResponseVO.builder().status(true).message("정상로그인")
                .token(tokenProvider.generateToken(authentication))
                .code(HttpStatus.OK).build();
    }

    public AdminInfoVO getAdminDetail(String id) {
        try{
            userDetailService.loadUserByUsername(id);
            AdminEntity admin = adminRepository.findByAdminId(id);
            AdminInfoVO vo = new AdminInfoVO(admin);
            return vo;
        }catch (UsernameNotFoundException e){
            return null;
        }
    }
}
