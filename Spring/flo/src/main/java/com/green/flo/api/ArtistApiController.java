package com.green.flo.api;

import com.green.flo.service.ArtistService;
import com.green.flo.vo.ArtistGroupInfoInsertVO;
import com.green.flo.vo.ArtistGroupResponseVO;
import com.green.flo.vo.artist.ArtistInfoInsertVO;
import com.green.flo.vo.artist.ArtistInfoResponseVO;
import com.green.flo.vo.artist.ArtistResponseVO;
import com.green.flo.vo.artistgroup.ArtistGroupInfoResponseVO;
import com.green.flo.vo.artistgroup.DeleteResponseVO;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/artist/info")
public class ArtistApiController {
    private final ArtistService aService;

    @PutMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< Object > putArtistGroupInfo(
            @Parameter(description = "multipart/formdata로 데이터를 입력합니다. (name:그룹명, debutYear:데뷔년도, company:기획사번호)") ArtistInfoInsertVO data,
            @Parameter(description = "multipart/formdata로 파일을 입력합니다.") MultipartFile img //폼데이터로 받는 방법임
    ) {
        Map< String, Object > map = aService.addArtistInfo(data, img);

        return new ResponseEntity < > (map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity <ArtistResponseVO> getArtistGroupList(
            @RequestParam @Nullable String keyword,
            @PageableDefault(size = 10, sort = "artSeq", direction = Sort.Direction.DESC) Pageable pageable
    ) {

        return new ResponseEntity <> (aService.getArtistList(keyword, pageable), HttpStatus.OK);
    }
    @DeleteMapping("/{seq}")
    public ResponseEntity<DeleteResponseVO> deleteArtist(@PathVariable Long seq){
        DeleteResponseVO deleteResponseVO = aService.deleteArtist(seq);
        return new ResponseEntity<>(deleteResponseVO, deleteResponseVO.getCode());
    }
    @GetMapping("/{seq}")
    public ResponseEntity<ArtistInfoResponseVO> getArtistGroup(@PathVariable Long seq){
        ArtistInfoResponseVO responseVO = aService.getArtistInfo(seq);

        return new ResponseEntity<>(responseVO, HttpStatus.OK);
    }
    @PatchMapping("")
    public ResponseEntity<Object> updateArtistGroup(ArtistInfoInsertVO data, @Nullable MultipartFile img) throws Exception {
        Map<String, Object> resultMap = aService.updataArtistInfo(data, img);
        return new ResponseEntity<>(resultMap, HttpStatus.OK);
    }

}
