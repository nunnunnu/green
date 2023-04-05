package com.green.flo.vo.artistgroup;

import com.green.flo.entity.CompanyEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistGroupInfoResponseVO {
    private Long no;
    private String name;
    private Integer debutYear;
    private CompanyEntity company;
    private String imgFile;
}
