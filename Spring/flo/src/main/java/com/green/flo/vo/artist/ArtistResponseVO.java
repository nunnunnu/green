package com.green.flo.vo.artist;

import com.green.flo.entity.ArtistEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArtistResponseVO {
    private List<ArtistEntity> list;
    private Long total;
    private Integer totalPage;
    private Integer currentPage;
}
