package com.greenart.book_info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greenart.book_info.entity.BookInfoEntity;
@Repository
public interface BookInfoRepository extends JpaRepository<BookInfoEntity, Long> {
     
}
