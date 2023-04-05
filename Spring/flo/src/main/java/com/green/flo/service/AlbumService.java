package com.green.flo.service;

import com.green.flo.entity.AlbumInfoEntity;
import com.green.flo.entity.ArtistGroupInfoEntity;
import com.green.flo.entity.MusicFileEntity;
import com.green.flo.entity.MusicInfoEntity;
import com.green.flo.entity.view.AlbumSummaryEntity;
import com.green.flo.entity.view.MusicInfoViewEntity;
import com.green.flo.repository.*;
import com.green.flo.repository.view.AlbumSummaryRepository;
import com.green.flo.vo.album.AlbumDetailInfoVO;
import com.green.flo.vo.album.AlbumInfoInsertVO;
import com.green.flo.vo.album.AlbumInfoVO;
import com.green.flo.vo.music.MusicInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AlbumService {
    private final AlbumInfoRepository aRepo;
    private final MusicInfoRepository mRepo;
    private final MusicFileRepository mfRepo;
    private final FileService fileService;
    private final ArtistGroupInfoRepository artRepo;
    private final AlbumSummaryRepository asRepo;
    private final MusicInfoViewRepository mivRepo;
    @Transactional
    public Map<String, Object> insertAlbumInfo(AlbumInfoInsertVO data) throws Exception {
        Map<String, Object> map = new LinkedHashMap<>();
        AlbumInfoVO album = data.getAlbumInfo();
        String albumImg = fileService.saveImageFile("album", album.getAlbumImg());
        AlbumInfoEntity albumEntity = AlbumInfoEntity.builder()
                .aiAgiSeq(album.getArtistGroup())
                .aiForeign(album.getCountry())
                .aiName(album.getAlbumName())
                .aiIntroduce(album.getIntroduce())
                .aiPubDt(album.getPublishDate())
                .aiImg(albumImg)
                .build();
        aRepo.save(albumEntity);

        for(MusicInfoVO music : data.getMusicList()){
            MusicInfoEntity musicEntity = MusicInfoEntity.builder()
                    .musicAiSeq(albumEntity.getAiSeq())
                    .musicGenre(music.getGenre())
                    .musicIsTitle(music.getIsTitle())
                    .musicName(music.getName())
                    .musicOrder(music.getOrder())
                    .build();
            mRepo.save(musicEntity);

            ArtistGroupInfoEntity artist = artRepo.findById(albumEntity.getAiAgiSeq()).orElse(null);

            String musicFileName = fileService.saveMusicFile(artist.getAgiName(), music.getFile());

            MusicFileEntity file = MusicFileEntity.builder()
                    .mfileMusicSeq(musicEntity.getMusicSeq())
                    .mfileName(musicFileName)
                    .mfileType("mp3")
                    .build();
            mfRepo.save(file);
        }

        map.put("status", true);
        map.put("message", "앨범 정보 추가 완료");
        return map;
    }
    public Map<String, Object> getAlbumSummaryList(String keyword, Pageable pageable){
        if(keyword==null){
            keyword="";
        }
        Map<String, Object> resultMap = new LinkedHashMap<>();
        Page<AlbumSummaryEntity> album = asRepo.findByAsivGrpNameContains(keyword, pageable);

        resultMap.put("totalPage", album.getTotalPages());
        resultMap.put("currentPage", album.getNumber());
        resultMap.put("totalCount", album.getTotalElements());
        resultMap.put("list", album.getContent());

        return resultMap;
    }

    public Map<String, Object> deleteAlbumInfo(Long albumNo) {
        Map<String, Object> map = new LinkedHashMap<>();
        AlbumInfoEntity album = aRepo.findById(albumNo).orElse(null);
        if(album==null){
            map.put("status", false);
            map.put("message","앨범 번호 오류");
            map.put("code", HttpStatus.BAD_REQUEST);
        }
        aRepo.delete(album);
        map.put("status", true);
        map.put("message","삭제 성공");
        map.put("code", HttpStatus.OK);
        return map;
    }

    public Map<String, Object> getAlbumInfo(Long albumNo) {
        Map<String, Object> map = new LinkedHashMap<>();
        AlbumDetailInfoVO detail = new AlbumDetailInfoVO();
        AlbumInfoEntity album = aRepo.findById(albumNo).orElse(null);
        if(album==null){
            map.put("status", false);
            map.put("message","앨범 번호 오류");
            map.put("code", HttpStatus.BAD_REQUEST);
            return map;
        }
        detail.setAlbum(album);
        List<MusicInfoViewEntity> list = mivRepo.findByArtistNo(albumNo);
        System.out.println(list);
        detail.setMusicList(mivRepo.findByArtistNo(albumNo));
        map.put("status", true);
        map.put("message","조회성공");
        map.put("code", HttpStatus.OK);
        map.put("data", detail);
        return map;
    }
}
