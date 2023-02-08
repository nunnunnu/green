package com.green.flo.entity;

import java.time.LocalDate;

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

@Entity
@Table(name="artist_group_info")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ArtistGroupInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="agi_seq") private Long agiSeq;
    @Column(name="agi_name") private String agiName;
    @Column(name="agi_debut_year") private Integer agiDebutYear;
    @Column(name="agi_img") private String agiImg;
    @Column(name="agi_pci_seq") private Long agiPciSeq;
}
