package com.green.flo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtistGroupInfoInsertVO {
    private Long grpNo;
    private String name;
    private Integer debutYear;
    private Long company; //소속사 번호
}
