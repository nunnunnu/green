package com.green.flo.vo.album;

import com.green.flo.entity.AlbumInfoEntity;
import com.green.flo.entity.view.MusicInfoViewEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlbumDetailInfoVO {
    AlbumInfoEntity album;
    List<MusicInfoViewEntity> musicList;
}
