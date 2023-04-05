package com.green.flo.entity.view;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="album_summary_info_view")
public class AlbumSummaryEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "asiv_seq") private Long asivSeq;
    @Column(name = "asiv_cover") private String asivCover;
    @Column(name = "asiv_title") private String asivTitle;
    @Column(name = "asiv_pub_dt") private Date asivPubDt;
    @Column(name = "asiv_contry") private String asivContry;
    @Column(name = "asiv_grp_name") private String asivGrpName;
    @Column(name = "asiv_music_cnt") private Integer asivMusicCnt;
}
