package com.green.flo.vo.artist;

import com.green.flo.entity.ArtistGroupInfoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistInfoResponseVO {
    private Long no;
    private String name;
    private Integer birthYear;
    private String imgFile;
    private ArtistGroupInfoEntity group;
}
