package com.green.flo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name="music_info")
public class MusicInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="music_seq") private Long musicSeq;
    @Column(name="music_name") private String musicName;
    @Column(name="music_is_title") private Boolean musicIsTitle;
    @Column(name="music_order") private Integer musicOrder;
    @Column(name="music_genre") private Long musicGenre;
    @Column(name="music_ai_seq") private Long musicAiSeq;
}
