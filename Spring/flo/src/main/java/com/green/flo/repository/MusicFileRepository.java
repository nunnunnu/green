package com.green.flo.repository;

import com.green.flo.entity.MusicFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicFileRepository extends JpaRepository<MusicFileEntity, Long> {
}
