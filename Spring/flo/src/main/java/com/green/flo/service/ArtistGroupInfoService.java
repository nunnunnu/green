package com.green.flo.service;

import java.util.LinkedHashMap;
import java.util.Map;

import com.green.flo.entity.CompanyEntity;
import com.green.flo.vo.artistgroup.ArtistGroupInfoResponseVO;
import com.green.flo.vo.artistgroup.DeleteResponseVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.green.flo.entity.ArtistGroupInfoEntity;
import com.green.flo.repository.ArtistGroupInfoRepository;
import com.green.flo.repository.CompanyRepository;
import com.green.flo.vo.ArtistGroupInfoInsertVO;
import com.green.flo.vo.ArtistGroupResponseVO;

import lombok.RequiredArgsConstructor;

import static org.springframework.util.StringUtils.hasText;

@Service
@RequiredArgsConstructor //의존성 자동 주입 - @Autowired를 자동으로 해줌. 
public class ArtistGroupInfoService {
    private final ArtistGroupInfoRepository agiRepo; //서비스 안쪽에서만 사용할거라서 private, 변경 가능성이 없기때문에 final
    private final FileService fileService;
    private final CompanyRepository companyRepo;

    public Map<String, Object> addArtistGroupInfo(ArtistGroupInfoInsertVO data, MultipartFile img){
        Map<String, Object> map = new LinkedHashMap<>();
        String saveFilePath = "";
        try{
            saveFilePath = fileService.saveImageFile("artist_group", img); //return된 파일경로를 받음
        }catch(Exception e){
            System.out.println("파일 전송 실패");
            map.put("data", null);
            map.put("status", false);
            map.put("message", "파일 전송에 실패했습니다.");
            map.put("code", HttpStatus.INTERNAL_SERVER_ERROR);
            return map;
        }
        ArtistGroupInfoEntity entity = ArtistGroupInfoEntity.builder()
                                        .agiName(data.getName())
                                        .agiDebutYear(data.getDebutYear())
                                        .company(companyRepo.findById(data.getCompany()).get())
                                        .agiImg(saveFilePath)
                                        .build();
                                        
        agiRepo.save(entity);
        map.put("status", true);
        map.put("message", "추가되었습니다.");
        map.put("code", HttpStatus.OK);

        return map;
    }

    public ArtistGroupResponseVO getArtistGroupList(String keyword, Pageable pageable){
        if(keyword==null){
            keyword="";
        }
        Page<ArtistGroupInfoEntity> agiPage = agiRepo.findByAgiNameContains(keyword, pageable);
        ArtistGroupResponseVO response = ArtistGroupResponseVO.builder()
                                            .list(agiPage.getContent())
                                            .total(agiPage.getTotalElements())
                                            .totalPage(agiPage.getTotalPages())
                                            .currentPage(agiPage.getNumber())
                                            .build();
        return response;
    }

    public DeleteResponseVO deleteArtistGroup(Long seq){
        ArtistGroupInfoEntity entity = agiRepo.findById(seq).orElse(null);
        DeleteResponseVO result = new DeleteResponseVO();
        if(entity==null) {
            return DeleteResponseVO.builder().code(HttpStatus.BAD_REQUEST).status(false).message("존재하지않는 아티스트 그룹번호").build();
        }
        String filename = entity.getAgiImg();
        Boolean deleted = fileService.delImageFile("artist_group", filename);
        String message = "아티스트 그룹정보를 살제했습니다.";

        if(deleted) message +=("이미지 삭제 완료");
        else message +="(이미지 삭제 실패)";

        agiRepo.delete(entity);

        return DeleteResponseVO.builder().code(HttpStatus.OK).status(true).message("삭제완료").build();
    }

    public ArtistGroupInfoResponseVO getArtistGroupInfo(Long grpNo) {
        ArtistGroupInfoEntity entity = agiRepo.findById(grpNo).orElse(null);
        if(entity==null){
            return null;
        }

        return  ArtistGroupInfoResponseVO.builder()
                .no(entity.getAgiSeq())
                .name(entity.getAgiName())
                .debutYear(entity.getAgiDebutYear())
                .imgFile(entity.getAgiImg())
                .company(entity.getCompany())
                .build();
    }

    public Map<String, Object> updataArtistGroupInfo(ArtistGroupInfoInsertVO data, MultipartFile img) throws Exception {
        Map<String, Object> map = new LinkedHashMap<>();
        System.out.println(data);
        ArtistGroupInfoEntity entity = agiRepo.findById(data.getGrpNo()).orElse(null);
        if(entity==null){
            map.put("status", false);
            map.put("message", "일치하는 그룹이 존재하지않습니다.");
            map.put("code", HttpStatus.BAD_REQUEST);
            return map;
        }
        if(img!=null){
            String fileName = fileService.saveImageFile("artist_group",img);
            fileService.delImageFile("artist_group", entity.getAgiImg());
            entity.setAgiImg(fileName);
        }
        if(hasText(data.getName())){
            entity.setAgiName(data.getName());
        }
        if(data.getDebutYear()!=null){
            entity.setAgiDebutYear(data.getDebutYear());
        }
        if(data.getCompany()!=null){
            CompanyEntity company = companyRepo.findById(data.getCompany()).orElse(null);
            if(company!=null){
                entity.setCompany(company);
            }
        }
        agiRepo.save(entity);
        map.put("status", true);
        map.put("message", "수정완료");
        map.put("code", HttpStatus.OK);
        return map;
    }
}
