package com.green.flo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.flo.entity.CompanyEntity;
@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Long>{
     public Page<CompanyEntity> findByPubNameContains(String companyName, Pageable pageable);
     public Integer countByPubName(String name);
}
