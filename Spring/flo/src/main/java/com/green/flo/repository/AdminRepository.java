package com.green.flo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.flo.entity.AdminEntity;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
     public AdminEntity findByAdminIdAndAdminPwd(String adminId, String AdminPwd);
     public Integer countByAdminId(String id);

     public Page<AdminEntity> findByAdminIdContains(String adminId, Pageable pageable);
}

