package com.green.flo.api;

import java.util.Map;

import com.green.flo.vo.artistgroup.ArtistGroupInfoResponseVO;
import com.green.flo.vo.artistgroup.DeleteResponseVO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.green.flo.service.ArtistGroupInfoService;
import com.green.flo.vo.ArtistGroupInfoInsertVO;
import com.green.flo.vo.ArtistGroupResponseVO;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/artist/group")
@RequiredArgsConstructor
public class ArtistGroupInfoController {

    private final ArtistGroupInfoService agiService;

    @PutMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity < Object > putArtistGroupInfo(
        @Parameter(description = "multipart/formdata로 데이터를 입력합니다. (name:그룹명, debutYear:데뷔년도, company:기획사번호)") ArtistGroupInfoInsertVO data,
        @Parameter(description = "multipart/formdata로 파일을 입력합니다.") MultipartFile img //폼데이터로 받는 방법임
    ) {
        Map < String, Object > map = agiService.addArtistGroupInfo(data, img);

        return new ResponseEntity < > (map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity < ArtistGroupResponseVO > getArtistGroupList(
        @RequestParam @Nullable String keyword,
        @PageableDefault(size = 10, sort = "agiSeq", direction = Sort.Direction.DESC) Pageable pageable
    ) {
        
        return new ResponseEntity <> (agiService.getArtistGroupList(keyword, pageable), HttpStatus.OK);
    }
    @DeleteMapping("/{grpNo}")
    public ResponseEntity<DeleteResponseVO> deleteArtist(@PathVariable Long grpNo){
        DeleteResponseVO deleteResponseVO = agiService.deleteArtistGroup(grpNo);
        return new ResponseEntity<>(deleteResponseVO, deleteResponseVO.getCode());
    }
    @GetMapping("/{grpNo}")
    public ResponseEntity<ArtistGroupInfoResponseVO> getArtistGroup(@PathVariable Long grpNo){
        ArtistGroupInfoResponseVO responseVO = agiService.getArtistGroupInfo(grpNo);

        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }
    @PatchMapping("")
    public ResponseEntity<Object> updateArtistGroup(ArtistGroupInfoInsertVO data, @Nullable MultipartFile img) throws Exception {
        Map<String, Object> resultMap = agiService.updataArtistGroupInfo(data, img);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }
}