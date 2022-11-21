 -- test 데이터 베이스로 사용 전환(주석)
use test;
use mysql;
use sys;

-- 테이블 생성
create table member_info(
	-- 테이블이름을 따서 접두어를 붙임. mi - member_info
	mi_seq int not null auto_increment primary key, 
	mi_id varchar(20) not null,
	mi_pwd varchar(128) not null, -- 암호화 고려
	mi_name varchar(100) not null, -- 외국인이름고려
	mi_email varchar(100) not null,
	mi_birth date not null,
	mi_gen int not null default 0,
	mi_reg_dt datetime not null default CURRENT_TIMESTAMP, -- 현재시간
	mi_status int not null default 1
);

-- 데이터 입력(하나 입력)
insert into member_info(mi_id, mi_pwd, mi_name, mi_email, mi_birth, mi_gen) 
values('user001', '123456','김데이터','data@service.com','2022-11-17',0);

-- 데이터 입력(둘 이상)
insert into member_info(mi_id, mi_pwd, mi_name, mi_email, mi_birth, mi_gen) 
values
('user002', '123456','이데이터','data1@service.com','2022-11-17',0),
('user003', '123456','박데이터','data2@service.com','2022-11-17',0),
('user004', '123456','최데이터','data3@service.com','2022-11-17',0),
('user005', '123456','정데이터','data4@service.com','2022-11-17',0),
('user006', '123456','주데이터','data5@service.com','2022-11-17',0),
('user007', '123456','장데이터','data6@service.com','2022-11-17',0),
('user008', '123456','황데이터','data7@service.com','2022-11-17',0);

-- truncate member_info; -- 전체 삭제 명령어, 신중하게 할 것. 주의 메세지 안뜸 
-- delete from member_info; -- 지우는건 같은데 주의메세지가 뜸

select  * from  member_info;

-- 아이디 안넣어도됨;;일단 냅두자
create table post_info( 
	pi_mi_seq int not null auto_increment primary key,
	pi_no int not null,
	pi_title varchar(255) not null, 
	pi_content text not null, 
	pi_reg_dt datetime not null default CURRENT_TIMESTAMP,
	pi_mod_dt datetime ,
	pi_status int not null default 0,
	pi_category int not null,
	pi_view int not null default 0,
	pi_like int not null default 0);

insert into post_info (pi_mi_seq, pi_no, pi_title, pi_content, pi_reg_dt, pi_category)
values
(1,1,'글 제목1','글 내용입니다.1','2022-11-17',1),
(2,2,'글 제목2','글 내용입니다.2','2022-11-17',3),
(3,3,'글 제목3','글 내용입니다.3','2022-11-17',5),
(4,4,'글 제목4','글 내용입니다.4','2022-11-17',4),
(5,5,'글 제목5','글 내용입니다.5','2022-11-17',3),
(6,6,'글 제목6','글 내용입니다.6','2022-11-17',2),
(7,7,'글 제목7','글 내용입니다.7','2022-11-17',1),
(8,8,'글 제목8','글 내용입니다.8','2022-11-17',2);

select * from  post_info;

-- truncate post; 

create table comment_info(
	ci_seq int not null auto_increment primary key, -- 구분 번호 
	ci_contents text not null,
	ci_mi_seq int not null, -- 작성자 번호
	ci_pi_seq int not null, -- 글 번호
	ci_reg_dt datetime not null default CURRENT_TIMESTAMP
);
desc comment_info ;
insert into comment_info (ci_seq, ci_mi_seq, ci_pi_seq, ci_contents)
values 
(1,1,1,'안녕하세요1'),
(2,2,2,'안녕하세요2'),
(3,3,3,'안녕하세요3'),
(4,4,4,'안녕하세요4'),
(5,5,5,'안녕하세요5');

select * from comment_info;

update  comment_info  set ci_contents='내일점심은' where ci_seq =1; -- 1번 사용자의 댓글 수정
update  comment_info  set ci_contents='오늘 저녁은' where ci_seq =2;
update  comment_info  set ci_contents='집에가고싶다' where ci_seq =3;
update  comment_info  set ci_contents='ㅇㅇㅇㅇㅇ' where ci_seq =4;

delete from comment_info  where ci_mi_seq =3; -- 3번 사용자의 댓글을 삭제함

select * from comment_info where ci_mi_seq=5;
select ci_content from comment_info where ci_mi_seq=5; -- 댓글 내용만 
select ci_content, ci_seq  from comment_info where ci_mi_seq=5; -- 댓글 내용과 댓글번호만
select ci_content as content, ci_seq as no from comment_info where ci_mi_seq=5; -- 댓글 내용과 댓글번호만 컬럼명 바꿔서

select mi_id, mi_name  from member_info;
alter table post_info change pi_no pi_seq int; 
select * from post_info pi2  where pi_seq  = 1; -- 글번호가 1인 글
select  * from comment_info ci where ci_pi_seq =1; -- 1번 글에 작성된 댓글만
select pi_title, pi_content from post_info pi2  where  pi_seq=1; -- 이쪽 칼럼명으로 출력됨
-- union all -- 추천하지않는방법. 따로 조회하는것이 나음
select ci_content, ci_content from comment_info where  ci_pi_seq=1; 

insert into comment_info (ci_seq, ci_mi_seq, ci_pi_seq, ci_contents)
values (6,6,6,"안녕6");

alter table comment_info change ci_contents ci_content text;

select * from member_info where mi_name  like '김%'; -- 김씨인거 출력
select * from member_info where mi_name  like '%팔'; -- 팔로 끝나는
select * from member_info where mi_name  like '%협%'; -- 협이 포함된



update member_info set mi_name = '곽두팔' where mi_seq =1; 
update member_info set mi_name = '서팔광' where mi_seq =2; 
update member_info set mi_name = '김덕협' where mi_seq =3; 
update member_info set mi_name = '남궁협식' where mi_seq =4; 
update member_info set mi_name = '김협두' where mi_seq =5; 
update member_info set mi_name = '왕대협' where mi_seq =6; 
update member_info set mi_name = '여춘팔' where mi_seq =7; 

-- drop table person; -- 테이블까지 완전 삭제
-- select  * from person;
-- drop table member_info;
drop table post_info;
drop table comment_info;

desc member_info ;
desc post_info ;

alter table post_info change pi_no pi_num int; -- 칼럼 명 바꿈
alter table post_info change pi_num pi_no int;
	
alter table member_info add column address varchar(255) after mi_gen; -- 컬럼 추가

alter table member_info  change address mi_address varchar(255); -- 컬럼 명 변경

alter table member_info modify mi_name varchar(60); -- 크기 수정

-- alter table comment_info change cmt_no ci_no int;
-- alter table comment_info change cmt_contents ci_contents text;
-- alter table comment_info change cmt_reg_dt ci_reg_dt dateTime;
-- alter table comment_info change cmt_status ci_status int;

-- alter table comment_info add column ci_pi_no int;


create table employee (
	emp_no int not null auto_increment primary key,
	emp_name varchar(50) not null,
	emp_jikgup varchar(10) not null,
	emp_fee int not null
);

insert into employee (emp_name, emp_jikgup, emp_fee)
values 
	('서용재','과장',7500) ,
	('오경환','대리',5500) ,
	('이재용','사장',15000),
	('최현우','부장',8500) ,
	('유윤선','주임',4200) ,
	('이준호','사원',3300) ,
	('한현희','과장',7200) ,
	('유원미','차장',7700) ,
	('함필규','대리',5200) ,
	('권민규','이사',10000);

select * from employee;
select * from employee where emp_fee>=6000;

select * from employee where emp_fee<6000;
select * from employee where emp_fee>=5000 and emp_fee<=6500;

update employee set emp_jikgup='과장' where emp_jikgup = '대리';
update employee set emp_jikgup='대리' where emp_jikgup = '주임';

update employee set emp_fee = emp_fee+500; -- 모든 연봉 500추가
