package com.book.bookpractice.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member_info")
public class MemberInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="mi_seq")      private Long miSeq;
    @Column(name="mi_id")       private String miId;
    @Column(name="mi_pwd")      private String miPwd;
    @Column(name="mi_name")     private String miName;
    @Column(name="mi_nickname") private String miNickname;
    @Column(name="mi_email")    private String miEmail;
    @Column(name="mi_birth")    private Date miBirth;
    @Column(name="mi_gen")      private Integer miGen;
    @Column(name="mi_reg_dt")   private Date miRegDt;
    @Column(name="mi_grade")    private Integer miGrade;
    @Column(name="mi_status")   private Integer miStatus;
}