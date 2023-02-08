package com.green.flo.api;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.green.flo.service.ArtistGroupInfoService;
import com.green.flo.vo.ArtistGroupInfoInsertVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/artist/group")
@RequiredArgsConstructor
public class ArtistGroupInfoController {

    private final ArtistGroupInfoService agiService;

    @PutMapping("/insert")
    public ResponseEntity<Object> putArtistGroupInfo(
        ArtistGroupInfoInsertVO data,
        MultipartFile img //폼데이터로 받는 방법임
    ){
        Map<String, Object> map = agiService.addArtistGroupInfo(data, img);

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
