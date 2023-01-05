package com.greenart.book_info;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.greenart.book_info.entity.AdminAccountEntity;
import com.greenart.book_info.entity.StudentInfoEntity;
import com.greenart.book_info.entity.StudentMajorEntity;
import com.greenart.book_info.repository.AdminAccountRepository;
import com.greenart.book_info.repository.BookInfoRepository;
import com.greenart.book_info.repository.StudentInfoRepository;
import com.greenart.book_info.repository.StudentMajorRepository;
import com.greenart.book_info.repository.WriterInfoRepository;

@SpringBootTest
class BookInfoApplicationTests {

	@Autowired AdminAccountRepository aRepo;
	@Autowired BookInfoRepository bRepo;
	@Autowired WriterInfoRepository wRepo;

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

	@Test
	void testLogin(){ 
		String id = "admin1";
		String pwd = "123456";
          AdminAccountEntity loginUser = aRepo.findByAiIdAndAiPwd(id, pwd);
          assertNotEquals(loginUser, null); //로그인이 되면 성공
     }

	@Test
	void bookFindAll(){
		System.out.println(bRepo.findAll());
	}
	@Test 
	void writerFind(){
		System.out.println(wRepo.findAll());
	}

	@Autowired StudentMajorRepository majorRepo;
	@Autowired StudentInfoRepository stuRepo;

	@Test
	void getStudents(){
		System.out.println(stuRepo.findAll());
	}
	@Test
	void getMajors(){
		System.out.println(majorRepo.findAll());
	}
	@Test
	void addStudent(){
		StudentInfoEntity stu = new StudentInfoEntity();
		stu.setStuName("박학생");
		stu.setMajor(new StudentMajorEntity(null, "컴퓨터 공학과")); //Major도 함께 insert됨
		stuRepo.save(stu);
	}
	@Test
	void addStudent2(){
		StudentInfoEntity stu = new StudentInfoEntity();
		stu.setStuName("최학생");
		stu.setMajor(majorRepo.findById(3L).get()); //Major도 함께 insert됨
		stuRepo.save(stu);
	}
}
