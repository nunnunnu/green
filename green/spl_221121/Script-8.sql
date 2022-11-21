create database book_db;
use book_db;

create table book_info(
  bi_seq	int	not null	auto_increment	primary key,
  bi_title	varchar(100)	not null		,
  bi_sub_title	text			,
  bi_publisher	int	not null		,
  bi_pub_dt	date	not null		,
  bi_cate	int	not null		,
  bi_author	int	not null		,
  bi_pay	int	not null		,
  bi_status	int	not null	default 0	,
  bi_translation	int	
);

create table book_detail(
  bd_seq	int	not null	auto_increment	primary key,
  bd_page	int	not null		,
  bd_weight	int	not null		,
  bd_size	varchar(20)	not null		,
  bd_title	text	not null		,
  bd_detail	text	not null		,
  bd_sales	int	not null	default 0	,
  bd_bi_seq	int	not null
);

create table book_img(
  bimg_seq	int 	not null	auto_increment	primary key,
  bimg_img	varchar(50)	not null,		
  bimg_bi_seq	int 	not null		
);

create table category_info(
  ci_seq	int	not null	auto_increment	primary key,
  ci_cate	varchar(20)	not null		
);

create table auther_info(
  ai_seq	int	not null	auto_increment	primary key,
  ai_name	varchar(20)	not null		,
  ai_introduce	text	not null		,
  ai_country varchar(20)	not null,
  ai_birth	date	not null		
);

create table book_review(
  br_seq	int	not null	auto_increment	primary key,
  br_score	int	not null default	0	,
  br_comment	text	not null		,
  br_mi_seq	int	not null		,
  br_like	int	not null	default 0	,
  br_bi_seq int not null
);

create table member_info(
  mi_seq	int	not null	auto_increment	primary key,
  mi_id	varchar(50)	not null		,
  mi_pwd	varchar(50)	not null		,
  mi_name	varchar(50)	not null		,
  mi_gen	int	not null	default 0	,
  mi_birth	date	not null		,
  mi_address	varchar(100)	not null		,
  mi_email	varchar(20)	not null		,
  mi_reg_dt	datetime	not null default	now()	,
  mi_status	int	not null	default 1	
);

create table book_review_like(
  brl_seq	int	not null	auto_increment	primary key,
  brl_like	int	not null	default 0	,
  brl_mi_seq	int	not null		
);

create table publisher_info(
  pi_seq	int	not null	auto_increment	primary key,
  pi_name	varchar(50)	not null		
);

create table translation_info(
  ti_seq	int	not null	auto_increment	primary key,
  ti_name	varchar(50)	not null		
);

INSERT INTO category_info
(ci_cate)
VALUES('생물학');
select * from category_info ci 

INSERT INTO book_db.publisher_info
(pi_name)
VALUES('곰출판');

INSERT INTO book_db.auther_info
(ai_name, ai_introduce)
VALUES('룰루 밀러', '‘방송계의 퓰리처상’으로 불리는 피버디상(Peabody Awards)을 수상한 과학 전문기자로, 15년 넘게 미국공영라디오방송국(NPR)에서 일하고 있다.
인간의 행동을 형성하는 ‘보이지 않는 힘들’에 관한 이야기를 나누는 NPR의 〈인비저빌리아(Invisibilia)〉의 공동 기획자');

INSERT INTO book_db.translation_info
(ti_name)
VALUES('정지인');


INSERT INTO book_info
(bi_title, bi_sub_title, bi_publisher, bi_pub_dt, bi_cate, bi_author, bi_pay, bi_status, bi_translation)
VALUES('물고기는 존재하지 않는다', '상실, 사랑 그리고 숨어 있는 삶의 질서에 관한 이야기', 1, '2021-12-17', 1, 1, 15300, 0,1);
select * from book_info bi ;

INSERT INTO book_db.book_detail
(bd_page, bd_weight, bd_size, bd_title, bd_detail, bd_sales, bd_bi_seq)
VALUES(300, 480, '135*210*20mm', '‘방송계의 퓰리처상’ 피버디상 수상자 룰루 밀러의
사랑과 혼돈, 과학적 집착에 관한 경이롭고도 충격적인 데뷔작!', '‘방송계의 퓰리처상’으로 불리는 피버디상(Peabody Awards)을 수상한 과학 전문기자 룰루 밀러의 경이로운 논픽션 《물고기는 존재하지 않는다》는 여러 언론 매체에서 ‘2020년 최고의 책’으로 선정할 만큼 수많은 찬사를 받은 화제의 베스트셀러다.
집착에 가까울 만큼 자연계에 질서를 부여하려 했던 19세기 어느 과학자의 삶을 흥미롭게 좇아가는 이 책은 어느 순간 독자들을 혼돈의 한복판으로 데려가서 우리가 믿고 있던 삶의 질서에 관해 한 가지 의문을 제기한다. “물고기가 존재하지 않는다는 것은 엄연한 하나의 사실이다. 그렇다면 우리는 또 무엇을 잘못 알고 있을까?” 하고 말이다. 누군가에게는 이 질문이 살아가는 데 아무런 영향을 미치지 않을 수도 있다. 하지만 세상을 바라보는 “진실한 관계들”에 한층 가까이 다가가기 위해 노력하는 사람들에게는 분명 이 책이 놀라운 영감과 어느 한쪽으로도 치우치지 않는 폭넓은 시야를 제공해줄 것이다.', 
0,1);
select * from book_detail bd ;

INSERT INTO book_db.member_info
(mi_id, mi_pwd, mi_name, mi_birth, mi_gen, mi_address, mi_email)
VALUES
('user001', '1234', '서민영', '1982-05-27', 2, '서울','user001@book.com'),
('user002', '1234', '최민은', '1976-01-01', 2, '인천','user002@book.com'),
('user003', '1234', '이예영', '1968-10-19', 2, '대구','user003@book.com'),
('user004', '1234', '장시혁', '2004-05-12', 1, '부산','user004@book.com'),
('user005', '1234', '한서원', '1979-06-03', 1, '울산','user005@book.com'),
('user006', '1234', '박예진', '1986-06-07', 2, '대전','user006@book.com'),
('user007', '1234', '박하혁', '2001-11-25', 1, '광주','user007@book.com'),
('user008', '1234', '박예은', '2006-03-27', 1, '공주','user008@book.com'),
('user009', '1234', '서은진', '1997-10-06', 2, '경주','user009@book.com'),
('user010', '1234', '임은우', '1995-09-10', 1, '포항','user010@book.com');

INSERT INTO book_db.book_review
(br_score, br_comment, br_mi_seq,br_bi_seq)
VALUES
(1, '몇줄 짜리 소재를 300페이지 가까이 늘여 쓸 수 있다는 작가의 능력에 경외감이 생긴다', 1,1),
(5, '마지막이 충격.. 아.. 스포.. ', 1,1),
(3, '뒤로 갈수록 흥미 떨어져서 꾸역꾸역 읽음', 1,1),
(5, '너무 재밌게 읽었어요.', 1,1),
(5, '정말 재밌어요~ 한번쯤 고민했을 법한 문제를 재밌게 풀어놓은 책.', 1,1),
(5, '정말 재밌게 읽은 책. 중후반부터 예상치못한 전개가 신선했습니다', 1,1);

select * from book_review br ;

alter table book_info change bi_author bi_auther_seq int;
update book_detail set bd_sales = 425352 where bd_bi_seq=1;

select bi.bi_title , bi.bi_sub_title , bi.bi_pay , bd.bd_sales , ai.ai_name , avg(br.br_score) as score
from book_info bi join book_detail bd 
on bi.bi_seq = bd.bd_bi_seq join auther_info ai 
on bi.bi_auther_seq = ai.ai_seq 
join book_review br 
on bi_seq = br.br_bi_seq 
group by br.br_bi_seq;



