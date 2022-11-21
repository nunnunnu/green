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
select * from category_info ci ;
delete from category_info where ci_seq=3;

INSERT INTO book_db.publisher_info
(pi_name)
VALUES('곰출판');
select * from publisher_info;

INSERT INTO book_db.auther_info
(ai_name, ai_introduce)
VALUES('룰루 밀러', '‘방송계의 퓰리처상’으로 불리는 피버디상(Peabody Awards)을 수상한 과학 전문기자로, 15년 넘게 미국공영라디오방송국(NPR)에서 일하고 있다.
인간의 행동을 형성하는 ‘보이지 않는 힘들’에 관한 이야기를 나누는 NPR의 〈인비저빌리아(Invisibilia)〉의 공동 기획자');

INSERT INTO book_db.translation_info
(ti_name)
VALUES('정지인');
select * from translation_info; 


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
delete from book_detail where bd_seq=2;

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


INSERT INTO category_info
(ci_cate)
VALUES('자기계발');

INSERT INTO book_db.publisher_info
(pi_name)
VALUES('현대지성');
select * from publisher_info;

INSERT INTO book_db.auther_info
(ai_name, ai_introduce)
VALUES('데일 카네기', '1888년 미국 미주리주에서 태어나 워렌스버그 주립대학을 졸업한 후 교사·세일즈맨 등으로 일하며 수많은 실패를 경험했다. 1912년 뉴욕 YMCA에서 대화 및 연설 기술을 강연하면서 이름이 점차 알려지게 되었다. 사례 중심으로 펼쳐지는 그의 강의는 인간관계를 잘하기 위한 실질적 기술들을 제시하면서 선풍적인 인기를 끌었다. 그의 강연은 사람들이 자신의 경험과 성취를 나누는 나눔의 장이 되었다. 이어서 그는 카네기 연구소를 설립해 인간 경영과 자기 계발 분야에서 기념비적인 업적을 남겼다. 처세, 자기 관리, 화술, 리더십 등에 대한 그의 가르침은 지금까지도 수많은 사람들을 성공으로 이끌고 있다. 1936년에 출간된 『카네기 인간관계론』은 전 세계적으로 6,000만 부나 판매되는 경이로운 기록을 세웠다.

카네기 최고의 장점은 바로 단순, 명료함에 있다. 많은 문제에 단순하지만 진리가 되는 철학들을 제시, 스스로 풀어나갈 수 있도록 도우며 전 세계 사람들에게 많은 영감과 도움을 주었다.

카네기의 책들은 핵심을 찌르는 원칙들로 정평이 나 있다. 그가 펴낸 책 중에서도 『데일 카네기 인간관계론』, 『데일 카네기 자기관리론』, 『데일 카네기 성공대화론』 삼부작은 불후의 고전으로 평가받고 있으며, 특히 『데일 카네기 인간관계론』은 처음 출간된 이래 전 세계적으로 6천만 부 이상 판매된 최고의 인간관계 바이블이다. 『성공대화론』은 대중 앞에서 자신 있고 설득력 있게 말하는 방법을 알려주는 책으로 그는 이 책을 통해 ‘효과적으로 말하는 빠르고 쉬운 방법’을 알려주었고 세계로 번역되어 사랑받고 있다.

');

INSERT INTO book_db.translation_info
(ti_name)
VALUES('임상훈');
select * from translation_info; 


INSERT INTO book_info
(bi_title, bi_publisher, bi_pub_dt, bi_cate, bi_auther_seq, bi_pay, bi_status, bi_translation)
VALUES('데일 카네기 자기관리론', 2, '2021-01-13', 2, 2, 10350, 0,2);
select * from book_info bi ;

INSERT INTO book_db.book_detail
(bd_page, bd_weight, bd_size, bd_title, bd_detail, bd_sales, bd_bi_seq)
VALUES(424, 542, '150*225*30mm', '『인간관계론』과 짝을 이루는 데일 카네기 최고의 역작
걱정이 내 인생을 망치기 전에 반드시 읽어야 할 책!', '워런 버핏이 직접 적용한, 걱정 없는 인생의 핵심 원리
세계 최초의 ‘걱정 극복 실험실’에서 탄생한 마법의 공식 수록!

현대지성에서는 출간 즉시 베스트셀러가 된 『데일 카네기 인간관계론』에 이어 저자의 또 다른 역작 『데일 카네기 자기관리론』을 펴냈다. 이 책은 국내에서 유일하게 1948년 초판의 10부까지 고스란히 담은 ‘오리지널’ 초판 완역본이다.

벼락을 맞아도 끄떡없고, 숱한 폭풍우를 꿋꿋이 견뎌낸 아름드리 고목이 사람의 손가락 마디만 한 딱정벌레의 공격을 받아 맥없이 쓰러진다. 사자도 함부로 덤비지 못할 만큼 전투력이 강한 코끼리가 꿀벌의 가느다란 침에 속수무책으로 당한다. 우리 인생도 다르지 않다. “개미구멍 하나가 큰 제방 둑을 무너뜨린다”라는 속담처럼 사소한 걱정에 쉽게 마음을 내주어 인생을 망치는 사람이 수두룩하다. 걱정은 내일의 슬픔을 덜어주지 않고 도리어 오늘 살아갈 힘을 앗아가기에, 걱정이 인생을 좀먹도록 내버려둔다면 언젠가 큰 대가를 치르게 된다.

베스트셀러 『인간관계론』 저자인 데일 카네기는 성인들에게 화술과 인간관계를 가르치는 동안 ‘걱정’이 모든 인생 문제의 주원인이자 자기관리의 핵심 요소임을 깨달았다. 그래서 ‘걱정을 멈추고 새로운 인생을 사는 법’을 교육하기로 마음먹었다. 하지만 문제가 생겼다. 교과서로 삼기에 적합한 책을 찾을 수 없었던 것이다. 결국 직접 쓸 수밖에 없었다. 이것이 또 한 권의 세계적인 베스트셀러가 탄생하게 된 배경이다.

그는 동서고금의 온갖 자료를 샅샅이 훑으면서 각 분야의 전문가에게 조언을 들었다. 뿐만 아니라 170여 개 도시에서 열린 강좌를 ‘걱정 극복 실험실’로 삼아 수많은 사례를 수집하고 분석한 끝에 ‘마법의 공식’을 도출했다. 준비 기간 포함 7년에 걸쳐 집필한 이 책에는 걱정을 떨쳐내게 해줄 모든 지혜가 간결하고도 명확하게 담겨 있다. 또한 각계각층의 명사들 및 평범한 이웃들의 생생한 사례와 함께 당장 적용할 수 있는 구체적인 해결책을 제시했다. 모두 그가 활동하던 20세기 초부터 한 세기에 걸쳐 효과가 입증된 방법들이다.

걱정 없이 살게 해줄 가장 적실하고 효과적인 실행법을 수록한 이 책은 카네기의 또 다른 역작 『인간관계론』과 함께 자기계발서의 원전(原典)으로 손꼽힌다. 지금의 나를 넘어 보다 행복한 인생을 꿈꾼다면, 핵심을 콕콕 집어 전달하면서 무기력한 일상을 깨우고 변화의 길로 이끄는 카네기의 조언에 귀를 기울여보자.', 
286440,2);
select * from book_detail bd ;
delete from book_detail where bd_seq=2;

INSERT INTO book_db.book_review
(br_score, br_comment, br_mi_seq,br_bi_seq)
VALUES
(5, '스테디는 이유가 있음', 1,2),
(4, '읽은 후 실천이 중요할 것 같아요.', 2,2),
(5, '자기관리를 어떻게 하는지 알려줍니다.', 3,2),
(5, '도움이 많이 됩니다.', 6,2),
(5, '무조건 읽는 것을 추천합니다', 4,2),
(5, '두려움과 불안에 대해 잘 소개하고 있습니다.', 5,2);
select * from book_review br ;

select bi.bi_title , bi.bi_sub_title , bi.bi_pay , bd.bd_sales , ai.ai_name , avg(br.br_score) as score
from book_info bi join book_detail bd 
on bi.bi_seq = bd.bd_bi_seq
join auther_info ai 
on bi.bi_auther_seq = ai.ai_seq 
join book_review br
on bi_seq = br.br_bi_seq 
group by br.br_bi_seq;

select * from auther_info ai ;


INSERT INTO category_info
(ci_cate)
VALUES('심리학');

INSERT INTO book_db.publisher_info
(pi_name)
VALUES('알마');
select * from publisher_info;

INSERT INTO book_db.auther_info
(ai_name, ai_introduce)
VALUES('올리버 색스', '1933년 영국 런던에서 태어났다. 옥스퍼드 대학 퀸스칼리지에서 의학 학위를 받았고, 미국으로 건너가 샌프란시스코와 UCLA에서 레지던트 생활을 했다. 1965년 뉴욕으로 옮겨 가 이듬해부터 베스에이브러햄 병원에서 신경과 전문의로 일하기 시작했다. 그 후 알베르트 아인슈타인 의과대학과 뉴욕 대학을 거쳐 2007년부터 2012년까지 컬럼비아 대학에서 신경정신과 임상 교수로 일했다. 2012년 록펠러 대학이 탁월한 과학 저술가에게 수여하는 ‘루이스 토머스상’을 수상했고, 모교인 옥스퍼드 대학을 비롯한 여러 대학에서 명예박사 학위를 받았다. 2015년 안암이 간으로 전이되면서 향년 82세로 타계했다.

올리버 색스는 신경과 전문의로 활동하면서 여러 환자들의 사연을 책으로 펴냈다. 인간의 뇌와 정신 활동에 대한 흥미로운 이야기들을 쉽고 재미있게 그리고 감동적으로 들려주어 수많은 독자들에게 큰 사랑을 받았다. 〈뉴욕타임스〉는 이처럼 문학적인 글쓰기로 대중과 소통하는 올리버 색스를 ‘의학계의 계관시인’이라고 불렀으며, 〈로스앤젤레스타임스〉는 “색스는 독자들을 다른 사람의 마음속으로 초대하여 근본적인 형태의 공감을 느끼게 해준다”고 썼다. 그는 왕립내과학회, 미국문화예술아카데미, 미국예술과학아카데미의 회원이었으며, 2008년 엘리자베스 2세는 그에게 대영제국 명예기사 작위를 수여했다.

지은 책으로 베스트셀러 《아내를 모자로 착각한 남자》를 비롯해 《색맹의 섬》 《뮤지코필리아》 《환각》 《마음의 눈》 《목소리를 보았네》 《나는 침대에서 내 다리를 주 웠다》 《깨어남》 《편두통》 등 10여 권이 있다. 생을 마감하기 전에 자신의 삶과 연구, 저술 등을 감동적으로 서술한 자서전 《온 더 무브》와 삶과 죽음을 담담한 어조로 통찰한 칼럼집 《고맙습니다》, 인간과 과학에 대한 무한한 애정이 담긴 과학에세이 《의식의 강》, 자신이 평생 사랑하고 추구했던 것들에 관한 우아하면서도 사려 깊은 에세이집 《모든 것은 그 자리에》를 남겨 잔잔한 감동을 불러일으켰다.

');
 

INSERT INTO book_info
(bi_title, bi_publisher, bi_pub_dt, bi_cate, bi_auther_seq, bi_pay, bi_status)
VALUES('아내를 모자로 착각한 남자', 3, '2016-08-18', 3, 3, 16650, 0);
select * from book_info bi ;

INSERT INTO book_db.book_detail
(bd_page, bd_weight, bd_size, bd_title, bd_detail, bd_sales, bd_bi_seq)
VALUES(396, 632, '142*225*30mm', '우리 시대의 위대한 의사, 별이 되다
인간을 보는 새롭고 따뜻한 눈을 제시한 올리버 색스의 대표작.
2016월드일러스트레이션 어워즈 수상작가 이정호의 그림과 만나다.', '이 시대 가장 영향력 있는 신경학자이자 베스트셀러 저술가였던 올리버 색스. 1985년 영국 현지 출간 이래 30년 넘게 전 세계 독자들에게 폭 넓게 사랑받았으며 국내 독자들에게도 널리 알려진 대표작 《아내를 모자로 착각한 남자》 개정판이 출간되었다. 일상생활에 불편을 겪는 경증 환자부터 현실과 완전히 격리될 정도로 중증의 정신질환을 겪는 환자들까지… 올리버 색스가 엄밀히 관찰하고 따뜻하게 써낸 ‘우리와는 조금 다른’ 사람들의 독특한 임상 기록은, 인간 뇌에 관한 현대의학의 이해를 바꾸었다는 평가와 더불어 의학적·문학적으로 최고의 가치를 인정받고 있다. ‘알마’에서는 올리버 색스의 타계 1주기를 맞아 글과 디자인을 세심히 다듬은 개정판을 마련하였다. 누구보다 앞선 시선을 가졌던 작가의 목소리가 오늘의 독자들에게 온전히 전해질 수 있도록.'
,30738,3);
select * from book_detail bd ;
delete from book_detail where bd_seq=2;

INSERT INTO book_db.book_review
(br_score, br_comment, br_mi_seq,br_bi_seq)
VALUES
(4, '재밌게 잘 읽었습니다.', 1,2),
(5, '정신과 관련된 병을 차분하게 잘 써내려간 책입니다.', 2,2),
(5, '마음을 지켜야 합니다', 3,2),
(4, '뇌에 자극을 주는 책', 6,2),
(5, '아주 좋습니다.', 4,2),
(5, '드디어 샀다 ㅎㅎㅎㅎㅎ', 5,2);
select * from book_review br ;
