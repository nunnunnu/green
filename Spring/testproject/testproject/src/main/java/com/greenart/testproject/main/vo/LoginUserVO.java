package com.greenart.testproject.main.vo;

import com.greenart.testproject.main.entity.User;

import lombok.Data;

@Data
public class LoginUserVO {
     private Long no;
     private String id;
     private String name;

     public LoginUserVO(User entity){
          this.no = entity.getUserSeq();
          this.id = entity.getUserId();
          this.name = entity.getUserName();
     }
}
