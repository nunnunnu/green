package com.green.flo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.green.flo.entity.ArtistGroupInfoEntity;

public interface ArtistGroupInfoRepository extends JpaRepository<ArtistGroupInfoEntity, Long> {
    
}
