package com.greenart.testproject.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenart.testproject.main.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
     Integer countByUserId(String userId);
     public User findByUserIdAndUserPwd(String userId, String userPwd);
}
