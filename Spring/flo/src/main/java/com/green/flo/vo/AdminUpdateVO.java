package com.green.flo.vo;

import lombok.Data;

@Data
public class AdminUpdateVO {
     private Long seq;
     private String pwd;
     private String name;
     private Integer status;
     private Integer grade;
}
