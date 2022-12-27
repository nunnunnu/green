package com.greenart.book_info.VO;

import com.greenart.book_info.entity.AdminAccountEntity;

import lombok.Data;
@Data
public class AdminAccountVo {
     private Long seq;
     private String id;
     private String name;
     private Integer grade;
     private Integer status;

     public AdminAccountVo(AdminAccountEntity account){
          this.seq = account.getAiSeq();
          this.id = account.getAiId();
          this.name = account.getAiName();
          this.grade = account.getAiGrade();
          this.status = account.getAiStatus();
     }
}
