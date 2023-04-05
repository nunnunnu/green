package com.green.flo.vo.response;

import com.green.flo.security.vo.TokenVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AdminLoginResponseVO {
    private Boolean status;
    private String message;
    private HttpStatus code;
    private TokenVO token;
}
