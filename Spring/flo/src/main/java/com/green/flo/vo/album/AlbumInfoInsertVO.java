package com.green.flo.vo.album;

import com.green.flo.vo.music.MusicInfoVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumInfoInsertVO {
    private AlbumInfoVO albumInfo;
    private MusicInfoVO[] musicList;


}
