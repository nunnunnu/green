package com.greenart.book_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenart.book_info.entity.WriterInfoEntity;

@Repository
public interface WriterInfoRepository extends JpaRepository<WriterInfoEntity, Long> {
     WriterInfoEntity findByWiSeq(Long seq);
}
