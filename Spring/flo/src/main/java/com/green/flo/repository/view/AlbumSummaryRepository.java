package com.green.flo.repository.view;

import com.green.flo.entity.view.AlbumSummaryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumSummaryRepository extends JpaRepository<AlbumSummaryEntity, Long> {

    Page<AlbumSummaryEntity> findByAsivGrpNameContains(String grpName, Pageable pagealbe);
}
