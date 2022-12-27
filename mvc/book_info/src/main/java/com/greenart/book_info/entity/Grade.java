package com.greenart.book_info.entity;

public enum Grade {
     NOMAL(1), SUPER(99);
     public final Integer code;

     Grade(int code) {
          this.code = code;
     }
}