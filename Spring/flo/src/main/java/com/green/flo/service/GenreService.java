package com.green.flo.service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.green.flo.entity.GenreEntity;
import com.green.flo.repository.GenreRepository;
import com.green.flo.vo.GenreListResponseVO;

@Service
public class GenreService {
     @Autowired GenreRepository genreRepository;

     public GenreListResponseVO getGenreList(String keyword, Pageable pageable) {
          Page<GenreEntity> page = genreRepository.findByGenreNameContains(keyword, pageable);
          GenreListResponseVO response = GenreListResponseVO.builder()
          .list(page.getContent())
          .total(page.getTotalElements())
          .totalPage(page.getTotalPages())
          .currentPage(page.getNumber())
          .build();
          return response;
     }
     public Map<String, Object> addGenreInfo(String name){
          Map<String, Object> resultMap = new LinkedHashMap<>();
          if(name.equals("")){
               resultMap.put("status", false);
               resultMap.put("message", "장르가 입력되지 않았습니다.");
          }else if(genreRepository.countByGenreName(name)==0){
               GenreEntity genre = GenreEntity.builder().genreName(name).build();
               genreRepository.save(genre);
               resultMap.put("status", true);
               resultMap.put("message", "장르정보를 추가했습니다.");
          }else{
               resultMap.put("status", false);
               resultMap.put("message", name+"장르는 이미 존재합니다.");
          }
          return resultMap;
     }
     @Transactional
     public void deleteGenre(Long genre_no) {
          genreRepository.deleteById(genre_no);
     }
     public Map<String, Object> selectGenreInfo(Long genre_no) {
          Map<String, Object> resultMap = new LinkedHashMap<>();
          Optional<GenreEntity> entityOpt = genreRepository.findById(genre_no);
          if(entityOpt.isEmpty()){
               resultMap.put("status", false);
          }else{
               resultMap.put("status", true);
               resultMap.put("no", entityOpt.get().getGenreSeq());
               resultMap.put("name", entityOpt.get().getGenreName());
          }
          
          return resultMap;
     }
     public Map<String, Object> updateGenreInfo(Long no, String name) {
          Map<String, Object> map = new LinkedHashMap<>();
          System.out.println(no);
          System.out.println(name);
          Optional<GenreEntity> entityOpt = genreRepository.findById(no);
          System.out.println(entityOpt);
          System.out.println(genreRepository.countByGenreName(name)!=0);
          
          if(entityOpt.isEmpty()){
               map.put("updated", false);
               map.put("no", no);
               map.put("name", name);
               map.put("message", "잘못된 장르 정보입니다.");
          }else if(entityOpt.get().getGenreName().equalsIgnoreCase(name)){
               map.put("updated", false);
               map.put("no", no);
               map.put("name", name);
               map.put("message", "장르 이름이 변경되지 않았습니다.");
          }else if(genreRepository.countByGenreName(name)!=0){
               map.put("updated", false);
               map.put("no", no);
               map.put("name", name);
               map.put("message", name+"는 이미 존재합니다.");
          }else if(name.equals("")){
               map.put("updated", false);
               map.put("no", no);
               map.put("name", name);
               map.put("message", "변경할 이름을 입력해주세요.");
          }else{
               GenreEntity entity = GenreEntity.builder().genreName(name).genreSeq(no).build();
               genreRepository.save(entity);
               map.put("updated", true);
               map.put("message", "장르를 변경했습니다.");
          }    
          return map;
     }
}
