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
public class ArtistInfoInsertVO {
    private Long artNo;
    private String artName;
    private Integer birthYear;
    private Long grpInfo;
}
