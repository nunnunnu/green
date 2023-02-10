package com.green.flo.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.flo.entity.ArtistGroupInfoEntity;
import com.green.flo.repository.ArtistGroupInfoRepository;
import com.green.flo.repository.CompanyRepository;
import com.green.flo.vo.ArtistGroupInfoInsertVO;
import com.green.flo.vo.ArtistGroupResponseVO;

import lombok.RequiredArgsConstructor;

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
}
