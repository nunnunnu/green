package com.greenart.book_info.entity;



import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin_account")
@DynamicInsert //입력이 안된 null값은 default값을 입력
@Builder //입력한 값만 입력. 객체 생성 시 없는 값은 제외하고 입력
public class AdminAccountEntity {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name="ai_seq")                            private Long aiSeq;
     @Column(name="ai_id")                             private String aiId;
     @Column(name="ai_pwd")                            private String aiPwd;
     @Column(name="ai_name")                           private String aiName;
     @Column(name="ai_grade")  @ColumnDefault("1")     private Integer aiGrade;
     @Column(name="ai_status") @ColumnDefault("0")     private Integer aiStatus;
}