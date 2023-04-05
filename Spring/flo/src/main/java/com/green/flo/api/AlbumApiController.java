package com.green.flo.api;

import com.green.flo.service.AlbumService;
import com.green.flo.vo.album.AlbumInfoInsertVO;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/album")
@RequiredArgsConstructor
public class AlbumApiController {
    private final AlbumService albumService;
    @PutMapping("")
    public ResponseEntity<Object> putAlbumInfo(AlbumInfoInsertVO data) throws Exception{
        Map<String, Object> map = albumService.insertAlbumInfo(data);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<Object> getAlbumSummaryList(
            @RequestParam @Nullable String keyword,
            @PageableDefault(size=10) Pageable page
    ){
      Map<String, Object> map = albumService.getAlbumSummaryList(keyword, page);
      return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @DeleteMapping("/{albumNo}")
    public ResponseEntity<Object> deleteAlbumInfo(@PathVariable Long albumNo){
        Map<String, Object> result = albumService.deleteAlbumInfo(albumNo);
        return new ResponseEntity<>(result, (HttpStatus)result.remove("code")); //꺼내면서 삭제
    }

    @GetMapping("/{albumNo}")
    public ResponseEntity<Object> getAlbumInfo(@PathVariable Long albumNo){
         Map<String, Object> result = albumService.getAlbumInfo(albumNo);
        return new ResponseEntity<>(result, (HttpStatus)result.remove("code")); //꺼내면서 삭제

    }
}