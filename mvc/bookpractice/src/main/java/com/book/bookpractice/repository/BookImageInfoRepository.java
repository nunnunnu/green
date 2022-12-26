package com.book.bookpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.bookpractice.entity.BookImageInfoEntity;

@Repository
public interface BookImageInfoRepository extends JpaRepository<BookImageInfoEntity, Long>{
    
}
