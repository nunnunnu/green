package com.green.flo.vo;

import java.util.List;

import com.green.flo.entity.ArtistGroupInfoEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistGroupResponseVO {
    @Schema(description = "그룹 리스트")
    private List<ArtistGroupInfoEntity> list;
    @Schema(description = "총 그룹 수", example="121")
    private Long total;
    @Schema(description = "총 페이지 수", example="13")
    private Integer totalPage;
    @Schema(description = "조회한 페이지(1페이지->0, 2페이지->1)", example="0")
    private Integer currentPage;
    //일치하는 부분은 super class 만들어서 작업해도됨. 
}
