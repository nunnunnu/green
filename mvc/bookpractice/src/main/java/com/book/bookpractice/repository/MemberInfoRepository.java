package com.book.bookpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.bookpractice.entity.MemberInfoEntity;

@Repository
public interface MemberInfoRepository extends JpaRepository < MemberInfoEntity, Long > {

}