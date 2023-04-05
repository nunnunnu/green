package com.green.flo.repository;

import com.green.flo.entity.view.MusicInfoViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicInfoViewRepository extends JpaRepository<MusicInfoViewEntity, Long> {
    List<MusicInfoViewEntity> findByArtistNo(Long artistNo);
}
