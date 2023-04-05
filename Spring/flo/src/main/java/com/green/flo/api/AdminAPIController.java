package com.green.flo.api;

import com.green.flo.service.AdminSecurityService;
import com.green.flo.vo.AdminInfoVO;
import com.green.flo.vo.LoginVO;
import com.green.flo.vo.response.AdminLoginResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminAPIController {
    private final AdminSecurityService adminSecurityService;

    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponseVO> postAdminLogin(@RequestBody LoginVO login){
        AdminLoginResponseVO responseVO = adminSecurityService.login(login);
        return new ResponseEntity<>(responseVO, responseVO.getCode());
    }
    @GetMapping("/details/{id}")
    public ResponseEntity<AdminInfoVO> getAdminDetailInfo(@PathVariable String id){
        return new ResponseEntity<>(adminSecurityService.getAdminDetail(id), HttpStatus.OK);
    }
}
