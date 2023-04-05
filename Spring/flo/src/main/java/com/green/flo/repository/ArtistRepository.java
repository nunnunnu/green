package com.green.flo.repository;

import com.green.flo.entity.ArtistEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Long> {

    Page<ArtistEntity> findByArtNameContains(String artName, Pageable pageable);
}
