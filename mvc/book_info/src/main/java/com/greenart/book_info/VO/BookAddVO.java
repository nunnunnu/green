package com.greenart.book_info.VO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class BookAddVO {
     
     private String title;
     private LocalDate pub_dt;
     private String sub_title;
     private Long writer; //seq번호가 들어옴
     private Long translator; //seq번호가 들어옴
     private Long publisher; //seq번호가 들어옴
     private Integer price;
     private Integer discount;
     private Integer point;
}
