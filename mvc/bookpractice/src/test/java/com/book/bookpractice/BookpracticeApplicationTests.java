package com.book.bookpractice;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.book.bookpractice.entity.BookInfoEntity;
import com.book.bookpractice.repository.BookInfoRepository;

@SpringBootTest
class BookpracticeApplicationTests {
	@Autowired BookInfoRepository biRepo;
	@Test
	@Transactional
	void addBookInfo() {
		BookInfoEntity b = new BookInfoEntity(null, "제목", "부제목", 12000, 0.1, 0.05, new Date(), "인문", "출판사");
		b = biRepo.save(b);
		System.out.println(b);
	}
	

}
