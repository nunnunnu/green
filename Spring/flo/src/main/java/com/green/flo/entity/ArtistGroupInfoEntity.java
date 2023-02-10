package com.green.flo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="artist_group_info")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArtistGroupInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description="아티스트 그룹 번호", example="1")
    @Column(name="agi_seq") private Long agiSeq;
    @Schema(description="아티스트 그룹 이름", example="뉴진스")
    @Column(name="agi_name") private String agiName;
    @Schema(description="아티스트 그룹 데뷔년도", example="2022")
    @Column(name="agi_debut_year") private Integer agiDebutYear;
    @Schema(description="아티스트 그룹 대표이미지", example="newjeans.png")
    @Column(name="agi_img") private String agiImg;
    @Schema(description="아티스트 그룹 소속사번호", example="1")
    @ManyToOne @JoinColumn(name="agi_pci_seq") private CompanyEntity company;
}