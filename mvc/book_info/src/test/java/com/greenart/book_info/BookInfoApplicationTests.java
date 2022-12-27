package com.greenart.book_info;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.greenart.book_info.entity.AdminAccountEntity;
import com.greenart.book_info.entity.Grade;
import com.greenart.book_info.repository.AdminAccountRepository;

@SpringBootTest
class BookInfoApplicationTests {

	@Autowired AdminAccountRepository aRepo;

	@Test
	@Transactional
	void addAdmin() {
		AdminAccountEntity account = AdminAccountEntity.builder().aiId("admin").aiPwd("1234").aiName("관리자").build();
		aRepo.save(account);
		System.out.println(account);
	}
	// @Test
	// @Transactional
	// void findAll(){
	// 	List<AdminAccountEntity> list = aRepo.findAll();
	// 	for(AdminAccountEntity a : list){
	// 		System.out.println(a);
	// 	}
	// }

}
