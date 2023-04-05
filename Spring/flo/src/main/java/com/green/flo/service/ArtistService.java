package com.green.flo.service;

import com.green.flo.entity.ArtistEntity;
import com.green.flo.entity.ArtistGroupInfoEntity;
import com.green.flo.entity.CompanyEntity;
import com.green.flo.repository.ArtistGroupInfoRepository;
import com.green.flo.repository.ArtistRepository;
import com.green.flo.repository.CompanyRepository;
import com.green.flo.vo.ArtistGroupInfoInsertVO;
import com.green.flo.vo.ArtistGroupResponseVO;
import com.green.flo.vo.artist.ArtistInfoInsertVO;
import com.green.flo.vo.artist.ArtistInfoResponseVO;
import com.green.flo.vo.artist.ArtistResponseVO;
import com.green.flo.vo.artistgroup.ArtistGroupInfoResponseVO;
import com.green.flo.vo.artistgroup.DeleteResponseVO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.springframework.util.StringUtils.hasText;

@Service
@RequiredArgsConstructor
public class ArtistService {
    private final ArtistGroupInfoRepository agiRepo; //서비스 안쪽에서만 사용할거라서 private, 변경 가능성이 없기때문에 final
    private final FileService fileService;
    private final CompanyRepository companyRepo;
    private final ArtistRepository aRepo;

    public Map<String, Object> addArtistInfo(ArtistInfoInsertVO data, MultipartFile img){
        Map<String, Object> map = new LinkedHashMap<>();
        String saveFilePath = "";
        try{
            saveFilePath = fileService.saveImageFile("artist", img); //return된 파일경로를 받음
        }catch(Exception e){
            System.out.println("파일 전송 실패");
            map.put("status", false);
            map.put("message", "파일 전송에 실패했습니다.");
            map.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
            return map;
        }
        System.out.println(data);
        ArtistGroupInfoEntity group = agiRepo.findById(data.getGrpInfo()).orElse(null);
        if(group==null){
            map.put("status", false);
            map.put("message", "그룹 번호 오류");
            map.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
            return map;

        }
        ArtistEntity entity = ArtistEntity.builder()
                .artName(data.getArtName())
                .artBirth(data.getBirthYear())
                .artImg(saveFilePath)
                .group(group)
                .build();

        aRepo.save(entity);
        map.put("status", true);
        map.put("message", "추가되었습니다.");
        map.put("code", HttpStatus.OK);

        return map;
    }

    public ArtistResponseVO getArtistList(String keyword, Pageable pageable){
        if(keyword==null){
            keyword="";
        }
        Page<ArtistEntity> artPage = aRepo.findByArtNameContains(keyword, pageable);
        ArtistResponseVO response = ArtistResponseVO.builder()
                .list(artPage.getContent())
                .total(artPage.getTotalElements())
                .totalPage(artPage.getTotalPages())
                .currentPage(artPage.getNumber())
                .build();

        return response;
    }

    public DeleteResponseVO deleteArtist(Long seq){
        ArtistEntity entity = aRepo.findById(seq).orElse(null);
        DeleteResponseVO result = new DeleteResponseVO();
        if(entity==null) {
            return DeleteResponseVO.builder().code(HttpStatus.BAD_REQUEST).status(false).message("존재하지않는 아티스트 번호").build();
        }
        String filename = entity.getArtImg();
        Boolean deleted = fileService.delImageFile("artist", filename);
        String message = "아티스트 정보를 삭제했습니다.";

        if(deleted) message +=("이미지 삭제 완료");
        else message +="(이미지 삭제 실패)";

        aRepo.delete(entity);

        return DeleteResponseVO.builder().code(HttpStatus.OK).status(true).message("삭제완료").build();
    }

    public ArtistInfoResponseVO getArtistInfo(Long seq) {
        ArtistEntity entity = aRepo.findById(seq).orElse(null);
        if(entity==null){
            return null;
        }

        return  ArtistInfoResponseVO.builder()
                .no(entity.getArtSeq())
                .birthYear(entity.getArtBirth())
                .group(entity.getGroup())
                .name(entity.getArtName())
                .imgFile(entity.getArtImg())
                .build();
    }

    public Map<String, Object> updataArtistInfo(ArtistInfoInsertVO data, MultipartFile img) throws Exception {
        Map<String, Object> map = new LinkedHashMap<>();
        System.out.println(data);
        ArtistEntity entity = aRepo.findById(data.getArtNo()).orElse(null);
        if(entity==null){
            map.put("status", false);
            map.put("message", "일치하는 아티스트가 존재하지않습니다.");
            map.put("code", HttpStatus.BAD_REQUEST);
            return map;
        }
        if(img!=null){
            String fileName = fileService.saveImageFile("artist",img);
            fileService.delImageFile("artist", entity.getArtImg());
            entity.setArtImg(fileName);
        }
        if(hasText(data.getArtName())){
            entity.setArtName(data.getArtName());
        }
        if(data.getBirthYear()!=null){
            entity.setArtBirth(data.getBirthYear());
        }
        if(data.getGrpInfo()!=null){
            ArtistGroupInfoEntity group = agiRepo.findById(data.getGrpInfo()).orElse(null);
            if(group!=null){
                entity.setGroup(group);
            }
        }
        aRepo.save(entity);
        map.put("status", true);
        map.put("message", "수정완료");
        map.put("code", HttpStatus.OK);
        return map;
    }
}
