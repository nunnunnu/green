package com.green.flo.entity.view;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="musin_info_view")
public class MusicInfoViewEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="music_seq") private Long musicSeq;
    @Column(name="music_name") private String musicName;
    @Column(name="music_order") private Integer musicOrder;
    @Column(name="music_is_title") private Boolean musicIsTitle;
    @Column(name="genre_name") private String genreName;
    @Column(name="mfile_name") private String mfileName;
    @Column(name="music_ai_seq") private Long artistNo;

}
