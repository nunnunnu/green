package com.green.flo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Table(name="album_info")
public class AlbumInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ai_seq") private Long aiSeq;
    @Column(name="ai_img") private String aiImg;
    @Column(name="ai_name") private String aiName;
    @Column(name="ai_pub_dt") private Date aiPubDt;
    @Column(name="ai_foreign") private Integer aiForeign;
    @Column(name="ai_introduce") private String aiIntroduce;
    @Column(name="ai_agi_seq") private Long aiAgiSeq;
}
