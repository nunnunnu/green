create database shop_db;
use shop_db;

create table user_info(
	ui_seq int not null auto_increment primary key,
	ui_id varchar(20) not null,
	ui_pwd varchar(64) not null,
	ui_name varchar(50) not null,
	ui_birth date not null,
	ui_gen int not null default 0,
	ui_address varchar(255) null,
	ui_phone varchar(20) not null,
	ui_email varchar(100) null,
	ui_reg_dt datetime not null default now(),
	ui_grade int not null default 1,
	ui_status int not null default 1,
	ui_access_level int not null default 1	
);

desc user_info;

insert into user_info(ui_id, ui_pwd, ui_name,ui_birth, ui_gen, ui_address,ui_phone, ui_email)
values
('user002','123456','사용자2','2022-10-10',1,'대구광역시 중구','010-2222-2222','sss@dddd.com'),
('user003','123456','사용자3','2022-10-10',1,'대구광역시 중구','010-3333-3333','sss@dddd.com'),
('user004','123456','사용자4','2022-10-10',1,'대구광역시 중구','010-4444-4444','sss@dddd.com'),
('user005','123456','사용자5','2022-10-10',1,'대구광역시 중구','010-5555-5555','sss@dddd.com'),
('user006','123456','사용자6','2022-10-10',1,'대구광역시 중구','010-6666-6666','sss@dddd.com'),
('user007','123456','사용자7','2022-10-10',1,'대구광역시 중구','010-7777-7777','sss@dddd.com'),
('user008','123456','사용자8','2022-10-10',1,'대구광역시 중구','010-8888-8888','sss@dddd.com'),
('user009','123456','사용자9','2022-10-10',1,'대구광역시 중구','010-9999-9999','sss@dddd.com'),
('user010','123456','사용자10','2022-10-10',1,'대구광역시 중구','010-1010-1010','sss@dddd.com'),
('user011','123456','사용자11','2022-10-10',1,'대구광역시 중구','010-0011-0011','sss@dddd.com'),
('user012','123456','사용자12','2022-10-10',1,'대구광역시 중구','010-0012-0012','sss@dddd.com'),
('user013','123456','사용자13','2022-10-10',1,'대구광역시 중구','010-0013-0013','sss@dddd.com'),
('user014','123456','사용자14','2022-10-10',1,'대구광역시 중구','010-0014-0014','sss@dddd.com'),
('user015','123456','사용자15','2022-10-10',1,'대구광역시 중구','010-0015-0015','sss@dddd.com');
select * from user_info;

create table member_info(
	mi_seq int not null auto_increment primary key,
	mi_id varchar(20) not null,
	mi_pwd varchar(20) not null,
	mi_name varchar(20) not null,
	mi_email varchar(50) not null,
	mi_gen int not null,
	mi_birth int not null, 
	mi_grade int null default 1, -- 4관리자 1일반 2우수 3vip
	mi_status int null default 1, -- 1가입대기 2 정상3탈퇴대기4 영구정지
	mi_reg_de datetime null default now()
);

alter table member_info change mi_reg_de mi_reg_dt datetime;

desc member_info;

insert into member_info(mi_id, mi_pwd, mi_name, mi_email, mi_gen, mi_birth, mi_grade, mi_status, mi_reg_dt)
values
('user01','1234','김현식','user01@service.com',0,'1984',1,2,'2021-05-01'),
('user02','1234','표종옥','user02@service.com',1,'1983',1,1,'2021-11-10'),
('user03','1234','강승혜','user03@service.com',1,'2001',2,2,'2021-03-01'),
('user04','1234','김미정','user04@service.com',1,'2000',2,4,'2020-01-30'),
('user05','1234','이혜주','user05@service.com',1,'2003',2,2,'2019-01-25'),
('user06','1234','박준우','user06@service.com',0,'2007',3,2,'2017-07-05'),
('user07','1234','백준호','user07@service.com',0,'2010',3,2,'2016-05-03'),
('user08','1234','오하민','user08@service.com',0,'1991',1,4,'2021-09-22'),
('user09','1234','박선우','user09@service.com',1,'1973',3,2,'2017-11-24'),
('user10','1234','김현우','user00@service.com',0,'1977',1,3,'2018-03-23'),
('user11','1234','이정민','user11@service.com',1,'1967',1,3,'2018-09-06'),
('user12','1234','김연준','user12@service.com',0,'1988',2,2,'2018-05-07'),
('user13','1234','박세영','user13@service.com',1,'1989',3,2,'2017-06-16'),
('user14','1234','표민정','user14@service.com',1,'1995',2,2,'2018-09-09'),
('user15','1234','송홍재','user15@service.com',0,'1999',2,2,'2018-09-11'),
('user16','1234','배은용','user16@service.com',0,'1956',1,3,'2021-02-03'),
('user17','1234','이은비','user17@service.com',1,'1977',1,1,'2021-11-09'),
('user19','1234','최이슬','user19@service.com',1,'1978',1,1,'2021-11-10'),
('user18','1234','권버들','user18@service.com',0,'1988',1,2,'2021-10-06'),
('user20','1234','김우람','user20@service.com',0,'1989',1,2,'2021-09-27'),
('admin','1234','관리자','admin@service.com',0,'1900',4,2,'2015-01-01');

select * from member_info;
truncate  member_info ;

select * from member_info where mi_birth > 2000;
select * from member_info where mi_grade=2;
select * from member_info where mi_grade=1;
select * from member_info where mi_grade=4;
select *, year(now())-mi_birth as age  from member_info where mi_gen =0 and age>=30; -- age를 만들긴햇는데 테이블에 속한건아니라 에러뜸
select *, year(now())-mi_birth as age  from member_info where mi_gen =0 and year(now())-mi_birth >=30;
select mi_id  from member_info where mi_gen =0 and year(now())-mi_birth >=30;

select mi_id, mi_name, mi_email, mi_gen from member_info 
where year(now())-mi_birth>=30 and year(now())-mi_birth<40 -- 30대 
and mi_grade =2;  -- 우수회원

select count(*) from member_info where mi_grade = 1; 
select * from member_info where year(now())-mi_birth<18;
select * from member_info where mi_name like '김%'; 
select * from member_info where mi_status =1;
update member_info set mi_status=2 where mi_status=1; -- 가입 승인

update member_info set mi_grade = 3 where mi_grade =2; -- 우수회원을 vip로
select * from member_info where mi_grade  = 3;

delete from member_info where mi_status =4;

delete from member_info where year(now())-mi_birth<18;

select 선택컬럼 from where 조건식
update 테이블 set 컬럼 = 값,... where 조건식 
delete from 테이블 where 조건식 
insert into 테이블(컬럼1....컬럼n) values (값1,....값n)

-- 사용자로부터 아이디와 비밀번호를 입력받아서 로그인이 가능한지 체크
select * from member_info where mi_id ='user05' and mi_pwd ='1234'; -- 데이터가 나오면 로그인성공
select count(*)=1 from member_info where mi_id ='user05' and mi_pwd ='1234'; -- 1 나오면 로그인성공
select * from member_info where mi_id ='user04' and mi_pwd ='1234'; -- 데이터가 나오지않음. 로그인실패
select count(*)=1 from member_info where mi_id ='user04' and mi_pwd ='1234'; -- 0 나오면 로그인실패 (1이 true고 0이 false임)
-- user05로 가입한 회원이 있는지 조회
select  count(*)>=1 from member_info where mi_id = 'user01';
select count(*)>=1 from member_info where mi_email ='user01@service.com';
select count(*)>=1 from member_info where mi_pwd ='1234'; 

create table board_info(
	b_seq int not null auto_increment primary key,
	b_title varchar(100) not null,
	b_content varchar(10000) not null,
	b_reg_dt datetime not null default CURRENT_TIMESTAMP,
	b_author int not null
);

create table product_info(
	pi_seq int not null auto_increment primary key,
	pi_name varchar(255) not null,
	pi_sub varchar(255) null,
	pi_reg_dt datetime not null default CURRENT_TIMESTAMP,
	pi_div int not null,
	pi_price int null default 0,
	pi_stock int null default 0,
	pi_like int null default 0
);

create table user(
	u_seq int not null auto_increment primary key,
	u_id varchar(20) not null,
	u_pwd varchar(20) not null,
	u_reg_dt datetime not null default CURRENT_TIMESTAMP
);

desc user;
desc product_info ;
desc board_info ;

insert into product_info (pi_name,pi_sub,pi_div,pi_price,pi_stock)
values 
('노지햇감자 3kg','놓치지마세요! 21년 첫 수확 노지 햇감자',1,6680,100),
('햇 양파 1.8Kg','믿고 먹을 수 있는 상품을 합리적인 가격에',1,3500,100),
('애호박 1개','믿고 먹을 수 있는 상품을 합리적인 가격에',	1,980,100),
('다짐육 200g','100g당 판매가 3,750원',2,	6750,100),
('닭 안심살','무항생제 친환경 닭고기 닭 안심살',2,4100,100),
('감동란 6구','맛도, 영양도 감동 !',2,4800,	100),
('해양심층수','매일 마시는 청정 바다의 심층수',3,5600,100),
('더 오렌지','순수한 오렌지 과육을 짜낸 100% 착즙 주스',3,15000,100),
('크림치즈','부드럽고 담백한 인기 크림치즈',4,8900,100),
('통밀 견과스틱','고소한 맛, 다채로운 식감',4,5000,100);
select * from product_info;
select * from board_info ;
delete from product_info where pi_name ='애호박 1개';
delete from product_info where pi_name ='더 오렌지';
select * from product_info where pi_div=3;

select * from product_info where pi_price >=5000;
select count(*) from product_info where pi_price <=5000;

select count(*)=1 from user_info where ui_id = 'user01' and ui_pwd ='1234'; -- 로그인

-- 게시글 작성
insert into board_info (b_title, b_content, b_author)
values ('글제목','글내용',1);

-- 게시글 수정
update board_info set b_title ='글제목 수정' where b_title='글제목';

select sum(pi_stock) from product_info where pi_price <=5000;
select avg(pi_price) from product_info;

desc board_info ;

INSERT INTO shop_db.board_info
(b_title, b_content, b_author)
VALUES('글제목', '글내용', 1);

UPDATE shop_db.board_info
SET b_title='글제목수정2', b_content='글내용수정'
WHERE b_seq=1; 

create database company_db;
use company_db;

