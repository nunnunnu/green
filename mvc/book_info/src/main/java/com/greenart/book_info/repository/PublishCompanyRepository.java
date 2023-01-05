package com.greenart.book_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenart.book_info.entity.PublishCompanyEntity;

@Repository
public interface PublishCompanyRepository extends JpaRepository<PublishCompanyEntity, Long> {
     PublishCompanyEntity findByPcSeq(Long seq);
}
