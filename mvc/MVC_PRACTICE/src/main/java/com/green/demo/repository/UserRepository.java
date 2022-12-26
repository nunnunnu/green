package com.green.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.green.demo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    List<UserEntity> findByUiId(String id);
    Long countByUiId(String id);
}
