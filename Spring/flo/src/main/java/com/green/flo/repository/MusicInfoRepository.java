package com.green.flo.repository;

import com.green.flo.entity.MusicInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicInfoRepository extends JpaRepository<MusicInfoEntity, Long> {
}
