package com.greenart.book_info.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenart.book_info.entity.AdminAccountEntity;

@Repository
public interface AdminAccountRepository extends JpaRepository<AdminAccountEntity, Long>{
     Integer countByAiId(String id);
     // Integer countByName(String aiName);
     //select * from admin_account where ai_id = {aiId} and aiPwd = {aiPwd}
     AdminAccountEntity findByAiIdAndAiPwd(String id, String pwd);
     AdminAccountEntity findByAiSeq(Long aiSeq);
     Page<AdminAccountEntity> findAll(Pageable pageable);
}
