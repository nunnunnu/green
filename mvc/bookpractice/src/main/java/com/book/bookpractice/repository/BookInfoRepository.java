package com.book.bookpractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.bookpractice.entity.BookInfoEntity;
@Repository
public interface BookInfoRepository extends JpaRepository<BookInfoEntity, Long>{
    
}
