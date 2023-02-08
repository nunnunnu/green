package com.green.flo.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.green.flo.entity.ArtistGroupInfoEntity;
import com.green.flo.repository.ArtistGroupInfoRepository;
import com.green.flo.vo.ArtistGroupInfoInsertVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //의존성 자동 주입 - @Autowired를 자동으로 해줌. 
public class ArtistGroupInfoService {
    private final ArtistGroupInfoRepository agiRepo; //서비스 안쪽에서만 사용할거라서 private, 변경 가능성이 없기때문에 final

    public Map<String, Object> addArtistGroupInfo(ArtistGroupInfoInsertVO data, MultipartFile img){
        Map<String, Object> map = new LinkedHashMap<>();
        ArtistGroupInfoEntity entity = new ArtistGroupInfoEntity(null, data.getName(), data.getDebutYear(), img.getOriginalFilename(), data.getCompany());
        agiRepo.save(entity);
        map.put("data", data);
        map.put("file", img.getOriginalFilename());

        return map;
    }
}
