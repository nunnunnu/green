package com.greenart.testproject.main.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
// @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user_info")
public class User {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "user_seq")    private Long userSeq;
     @Column(name = "user_id")     private String userId;
     @Column(name = "user_pwd")    private String userPwd;
     @Column(name = "user_name")   private String userName;
}
