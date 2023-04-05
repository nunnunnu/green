package com.green.flo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="artist_info")
public class ArtistEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="art_seq") private Long artSeq;
    @Column(name="art_name") private String artName;
//    @Column(name="art_agi_seq") private Long artAgiSeq;
    @Column(name="art_birth") private Integer artBirth;
    @Column(name="art_img") private String artImg;
    @ManyToOne @JoinColumn(name="art_agi_seq") private ArtistGroupInfoEntity group;
}
