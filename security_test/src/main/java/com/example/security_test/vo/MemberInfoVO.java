package com.example.security_test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberInfoVO {
    private String mi_seq;
    private String mi_id;
    private String mi_pwd;
    private String mi_name;
    private String mi_nickname;
    private String mi_status;
    private String mi_reg_dt;
    private String mi_role;
}
