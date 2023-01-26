package com.green.flo.api;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.green.flo.service.GenreService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/genre")
public class GenreAPIController {
     @Autowired GenreService genreService;

     @GetMapping("/list")
     public ResponseEntity<Object> getGenreList(@RequestParam @Nullable String keyword, 
     @PageableDefault(size=10, sort="genreSeq", direction=Sort.Direction.DESC) Pageable pageable,
          HttpSession session
     ){
          if(keyword==null){
               keyword="";
          }
          // model.addAttribute("result", genreService.getGenreList(keyword, pageable));
          // model.addAttribute("keyword", keyword); //비동기방식이라서 keyword가 날아가지않아서 저장안해도됨
          return new ResponseEntity<>(genreService.getGenreList(keyword, pageable), HttpStatus.OK);
     }

     @GetMapping("/detail")
     public ResponseEntity<Object> getGenreDetail(@RequestParam Long genre_no,
          @RequestParam @Nullable Integer page,
          @RequestParam @Nullable String keyword
     ){
          if(page==null){page=0;}
          if(keyword==null){keyword="";}
          Map<String, Object> map = genreService.selectGenreInfo(genre_no);
          // map.put("message", null);
          // model.addAttribute("genre", map);
          // model.addAttribute("page", page);
          // model.addAttribute("keyword", keyword);
          if((Boolean)map.get("status")){
               return new ResponseEntity<>(map, HttpStatus.OK);
          }else{
               return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
          }
     }

     @PatchMapping("/update")
     public ResponseEntity<Object> postGenreUpdate(@RequestParam Long no,@RequestParam String name){
          Map<String, Object> resultMap = genreService.updateGenreInfo(no, name);
          
          return new ResponseEntity<>(resultMap, HttpStatus.ACCEPTED);
     }
     
     @PutMapping("/add")
     public ResponseEntity<Object> postGenreAdd(@RequestParam String name){
          Map<String, Object> resultMap = genreService.addGenreInfo(name);
          return new ResponseEntity<>(resultMap, HttpStatus.ACCEPTED);
     }
     @DeleteMapping("/delete")
     public ResponseEntity<Object> getGenreDelete(@RequestParam Long genre_no){
          Map<String, Object> map = new LinkedHashMap<>();
          genreService.deleteGenre(genre_no);
          map.put("message", "장르 정보를 삭제했습니다.");
          return new ResponseEntity<>(map, HttpStatus.ACCEPTED);
     }
}
