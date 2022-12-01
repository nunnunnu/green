insert into shipping_info (ship_name)
values
('CJ대한통운'),
('롯데글로벌로지스'),
('한진'),
('우체국택배'),
('로젠택배'),
('경동택배'),
('대신택배');
SELECT * FROM shipping_info si ;
SELECT * from delivery_info di ;

INSERT INTO coupang_db.member_info
(mi_id, mi_pwd, mi_name, mi_date, mi_gender, mi_phone, mi_address)
VALUES
('user011', '1234', '최서아', '1998-04-24', 2, '010-0011-0011', '서울'),
('user012', '1234', '이우영', '1982-01-20', 1, '010-0012-0012', '대전'),
('user013', '1234', '윤지우', '1987-08-09', 2, '010-0013-0013', '대구'),
('user014', '1234', '신현우', '1968-05-09', 1, '010-0014-0014', '부산'),
('user015', '1234', '신예현', '2002-05-15', 1, '010-0015-0015', '제주'),
('user016', '1234', '박우영', '1986-08-28', 2, '010-0016-0016', '인천'),
('user017', '1234', '장우우', '1971-11-24', 1, '010-0017-0017', '경기'),
('user018', '1234', '임현유', '2001-04-08', 1, '010-0018-0018', '광주'),
('user019', '1234', '최서후', '1997-12-21', 1, '010-0019-0019', '경주'),
('user020', '1234', '최현진', '1990-06-14', 2, '010-0020-0020', '포항');

INSERT INTO coupang_db.delivery_info
(di_type, di_peroid, di_delivery_price, di_region, di_return_price)
VALUES('무료배송', 7, 0, '전국', 7000);


SELECT * from category_info ci ;
SELECT * from member_info mi ;
SELECT * FROM manufactor_info mi;
SELECT * from store_info si ;
SELECT * FROM delivery_info di ;
SELECT * from product_basic_info pbi ;
SELECT * from product_buy_option pbo ;
SELECT * FROM product_detail_info pdi ;
INSERT INTO coupang_db.manufactor_info
(manu_name)
VALUES('고스트리퍼플릭');

INSERT INTO coupang_db.store_info
(si_name)
VALUES('주식회사 티알엔');

INSERT INTO coupang_db.product_basic_info
(pbi_cate_seq, pbi_title, 
pbi_price, pbi_wow_price, pbi_delivery_seq, pbi_dis_price, pbi_store_seq,
pbi_stock, pbi_ship_seq, pbi_manu_seq)
VALUES(1, '고스트리퍼블릭 세미 스트라이프 앰보 오버핏 반팔 티셔츠 GT-3145 1+1 패키지',45900, null, 7, null, 1,100,1,1);

INSERT INTO coupang_db.product_buy_option
(pbo_title, pbo_price, pbo_pbi_seq)
VALUES
('블랙ⓢ:02.네이비', 45900, 1),
('블랙ⓢ:02.블랙', 45900, 1);

INSERT INTO coupang_db.product_detail_info
(pdi_pbi_seq, pdi_country, pdi_laws, pdi_importor, pdi_weight, pdi_distribute_days, pdi_built_date)
VALUES(1, '한국', null, '고스트리퍼블릭', null, null, null);

INSERT INTO coupang_db.product_img
(pi_rew_img, pi_pbi_seq)
VALUES('T.jpg', 1);

INSERT INTO coupang_db.coupang_explain
(ce_cate, ce_view, ce_pbi_seq)
VALUES(1, 'texp.jpg', 1);



SELECT * from category_info ci ;
SELECT * from member_info mi ;
SELECT * FROM manufactor_info mi;
SELECT * from store_info si ;
SELECT * FROM delivery_info di ;
SELECT * from product_basic_info pbi ;
SELECT * from product_buy_option pbo ;
SELECT * FROM product_detail_info pdi ;
SELECT * from product_buy_option pbo ;
SELECT * from coupang_review cr ;
SELECT * from review_img ri ;
SELECT * FROM product_ask pa ;
delete from product_ask where pa_seq = 5;

INSERT INTO coupang_db.manufactor_info
(manu_name)
VALUES('언더아머');

INSERT INTO coupang_db.store_info
(si_name)
VALUES('제임스컴퍼니');

INSERT INTO coupang_db.product_basic_info
(pbi_cate_seq, pbi_title, 
pbi_price, pbi_wow_price, pbi_delivery_seq, pbi_dis_price, pbi_store_seq,
pbi_stock, pbi_ship_seq, pbi_manu_seq)
VALUES(1, '언더아머 아웃스트링 기모 조거팬츠 검정 기모',79000, null, 7, 46800, 3,100,1,3);

INSERT INTO coupang_db.product_buy_option
(pbo_title, pbo_price, pbo_pbi_seq)
VALUES
('2XL(35_36)', 46800, 2),
('L(31_32)', 46800, 2);

INSERT INTO coupang_db.product_detail_info
(pdi_pbi_seq, pdi_country, pdi_laws, pdi_importor, pdi_weight, pdi_distribute_days, pdi_built_date)
VALUES(2, null, null, '미국 캄보디아 인도네시아 등', null, null, null);

INSERT INTO coupang_db.product_img
(pi_rew_img, pi_pbi_seq)
VALUES('pants.jpg', 2);

INSERT INTO coupang_db.coupang_review
(cr_mi_seq, cr_score, cr_option, cr_title, cr_view)
VALUES
(1, 5,  3, '너무잘샀어요 운동할때도 평소에도 잘 입을것같아요', null),
(5, 5,  3, null, null);

INSERT INTO coupang_db.review_img
(ri_img, ri_cr_seq)
VALUES
('pant_review1.jpg', 1),
('pant_review2.jpg', 2);

INSERT INTO coupang_db.product_ask
( pa_explain, pa_mi_seq, pa_pbi_seq, pa_answer,pa_ask_date , pa_answer_date)
VALUES
('키185 체중82에 허리사이즈34~35입니다 사이즈선택이 애매합니다 XL해도 되겠습니까?',
3, 11, '안녕하세요 xxl 추천드립니다.','2022/11/12 01:31:04', '2022/11/13 11:11:19');
-- ('키165 몸무베88키로 나가는데 XL입으면 되겠죠? 평소바지 사이즈도 XL입습니다ᆢ일자바지는 기장줄여서 입는데 이바지는 밑단에 시보리가 있어서 안줄여입어도 되겠죠?혹시 기장이 많이긴가요? 다리근육이 많아 굵은데 종아리 허벅지가 많이 조이나요?',
-- 3, 2, '안녕하세요 고객님 문의하신 제품은 조거팬츠로 종아리 단면이 xl경우 약18cm입니다. 제품주문시 참고하시면 좋을거같아요 감사합니다.','2022/11/22 03:25:18', '2022/11/22 10:00:30'),

INSERT INTO coupang_db.coupang_explain
(ce_cate, ce_view, ce_pbi_seq)
VALUES(1, 'pantexp.jpg', 2);



SELECT * from category_info ci ;
SELECT * from member_info mi ;
SELECT * FROM manufactor_info mi;
SELECT * from store_info si ;
SELECT * FROM delivery_info di ;
SELECT * from product_basic_info pbi ;
SELECT * from product_buy_option pbo ;
SELECT * FROM product_detail_info pdi ;
SELECT * from product_buy_option pbo ;
SELECT * from coupang_review cr ;
SELECT * from review_img ri ;

-- UPDATE coupang_review set cr_pbi_seq = 2 where cr_pbi_seq=0;

INSERT INTO coupang_db.manufactor_info
(manu_name)
VALUES('마르시끄'); -- 15

INSERT INTO coupang_db.store_info
(si_name)
VALUES('(주)한국콜마'); -- 7

INSERT INTO coupang_db.product_basic_info
(pbi_cate_seq, pbi_title, 
pbi_price, pbi_wow_price, pbi_delivery_seq, pbi_dis_price, pbi_store_seq,
pbi_stock, pbi_ship_seq, pbi_manu_seq)
VALUES(2, '마르시끄 래쉬 앤 브로우 홈 스파 블랙 세럼 속눈썹 영양제',32000, null, 2, 24800, 7,100,1,15); -- 7

-- INSERT INTO coupang_db.product_buy_option
-- (pbo_title, pbo_price, pbo_pbi_seq)
-- VALUES
-- ('2XL(35_36)', 46800, 2),
-- ('L(31_32)', 46800, 2);

INSERT INTO coupang_db.product_detail_info
(pdi_pbi_seq, pdi_country, pdi_laws, pdi_importor, pdi_weight, pdi_distribute_days, pdi_built_date)
VALUES(7, null, null, null, '7.5ml', null, null);

INSERT INTO coupang_db.product_img
(pi_rew_img, pi_pbi_seq)
VALUES('beauty1.jpg', 7);

INSERT INTO coupang_db.coupang_review
(cr_mi_seq, cr_score, cr_option, cr_title, cr_view, cr_pbi_seq)
VALUES
-- (6, 5,  null, '**눈알샷 무서움주의', '한달에 한번씩 속눈썸펌하고있는데 속눈썹펌하고 마스카라하면 안좋다는얘기를들어서..영양제를발라고면어떨까하고 구매했는데 엄청 쳐발쳐발했음에도 티가별로안나네요ㅜㅜ',7),
-- (4, 5,  null, null, '마스카라보다 영양제에 더 가까워요ㅋ',7),
(3, 5,  null, null, null,7);

INSERT INTO coupang_db.review_img
(ri_img, ri_cr_seq)
VALUES
('beauty1_review1.jpg', 1),
('beauty1_review2.jpg', 2);

-- INSERT INTO coupang_db.product_ask
-- ( pa_explain, pa_mi_seq, pa_pbi_seq, pa_answer,pa_ask_date , pa_answer_date)
-- VALUES('키165 몸무베88키로 나가는데 XL입으면 되겠죠? 평소바지 사이즈도 XL입습니다ᆢ일자바지는 기장줄여서 입는데 이바지는 밑단에 시보리가 있어서 안줄여입어도 되겠죠?혹시 기장이 많이긴가요? 다리근육이 많아 굵은데 종아리 허벅지가 많이 조이나요?',
-- 3, 2, '안녕하세요 고객님 문의하신 제품은 조거팬츠로 종아리 단면이 xl경우 약18cm입니다. 제품주문시 참고하시면 좋을거같아요 감사합니다.','2022/11/22 03:25:18', '2022/11/22 10:00:30');
-- 
-- INSERT INTO coupang_db.coupang_explain
-- (ce_cate, ce_view, ce_pbi_seq)
-- VALUES(1, 'pantexp.jpg', 2);


SELECT * from category_info ci ;
SELECT * from member_info mi ;
SELECT * FROM manufactor_info mi;
SELECT * from store_info si ;
SELECT * FROM delivery_info di ;
SELECT * from product_basic_info pbi ;
SELECT * from product_buy_option pbo ;
SELECT * FROM product_detail_info pdi ;
SELECT * from product_buy_option pbo ;
SELECT * from coupang_review cr ;
SELECT * from review_img ri ;
SELECT * from product_ask pa ;

INSERT INTO coupang_db.manufactor_info
(manu_name)
VALUES('아멜리'); -- 18

INSERT INTO coupang_db.store_info
(si_name)
VALUES('코스맥스(주)'); -- 10

INSERT INTO coupang_db.product_basic_info
(pbi_cate_seq, pbi_title, 
pbi_price, pbi_wow_price, pbi_delivery_seq, pbi_dis_price, pbi_store_seq,
pbi_stock, pbi_ship_seq, pbi_manu_seq)
VALUES(2, '아멜리 베이크드파우더 6.2g',34000, null, 2, 30600, 10,100,1,18); -- 11

INSERT INTO coupang_db.product_buy_option
(pbo_title, pbo_price, pbo_pbi_seq)
VALUES
('001 내추럴베이지 * 1개', 30600, 11), -- 9
('003 밀키바이올렛 * 1개', 30600, 11); -- 10

INSERT INTO coupang_db.product_detail_info
(pdi_pbi_seq, pdi_country, pdi_laws, pdi_importor, pdi_weight, pdi_distribute_days, pdi_built_date)
VALUES(11, '한국', null, null, '6.2g', 515, null);

INSERT INTO coupang_db.product_img
(pi_rew_img, pi_pbi_seq)
VALUES('beauty2.jpg', 11);

INSERT INTO coupang_db.coupang_review
(cr_mi_seq, cr_score, cr_option, cr_title, cr_view, cr_pbi_seq)
VALUES
-- (13, 4,  10, '제품은 엄청 좋아요','유분기번들거리는화장을 좋아하는데 톤업이 자연스럽게되고 화사해지니 너무 만족이에요.',11),
-- (20, 4,  9, '은은한 광으로 가볍고 마스크에 일도 안묻는ㅋ', '광고와 같이 사용시 투명에 가깝네요 사용해보니 붉은기는 잡아줍니다. 막 하해지거나하진안치만...보송보송하니 티도 안나고 좋아요',11);
(7, 5,  9, '이거 진짜 괜찮음', '얇게 얹어진 것에 비해 출근 후 시간이 꽤 플렀음에도 탄탄하게 잘 유지 중 만족하므로 앞으로 이것으로 갈아탈 예정',11);

INSERT INTO coupang_db.review_img
(ri_img, ri_cr_seq)
VALUES
('beauty2_review1.jpg', 1),
('beauty2_review2.jpg', 2);

INSERT INTO coupang_db.product_ask
( pa_explain, pa_mi_seq, pa_pbi_seq, pa_answer,pa_ask_date , pa_answer_date)
VALUES
('리뉴얼 된거로 오나요!??',
15, 11, '아멜리 베이크드파우더 6.2g 상품은 리뉴얼 전 제품인 점 참고하여 이용 부탁드립니다',
'2022/07/12 08:17:41', '2022/07/12 11:00:19'),
('리뉴얼 버전인가요 구 버전인가요??',
15, 11, '아멜리 베이크드파우더 6.2g 상품은 리뉴얼 전 제품인 점 참고하여 이용 부탁드립니다',
'2022/07/01 00:49:35', '2022/07/01 11:27:49');

INSERT INTO coupang_db.coupang_explain
(ce_cate, ce_view, ce_pbi_seq)
VALUES(1, 'beautyexp.jpg', 11);



SELECT * from category_info ci ;
SELECT * from member_info mi ;
SELECT * FROM manufactor_info mi;
SELECT * from store_info si ;
SELECT * FROM delivery_info di ;
SELECT * from product_basic_info pbi ;
SELECT * from product_buy_option pbo ;
SELECT * FROM product_detail_info pdi ;
SELECT * from product_buy_option pbo ;
SELECT * from coupang_review cr ;
SELECT * from review_img ri ;
SELECT * from product_ask pa ;

INSERT INTO coupang_db.manufactor_info
(manu_name)
VALUES('하기스'); -- 21

INSERT INTO coupang_db.store_info
(si_name)
VALUES('유한킴벌리'); -- 16

INSERT INTO coupang_db.product_basic_info
(pbi_cate_seq, pbi_title, 
pbi_price, pbi_wow_price, pbi_delivery_seq, pbi_dis_price, pbi_store_seq,
pbi_stock, pbi_ship_seq, pbi_manu_seq)
VALUES(3, '하기스 2022 보송보송 밴드형 기저귀 공용 소형 2단계(4~8kg)',38680, null, 2, 36800, 16,100,1,16); -- 16

INSERT INTO coupang_db.product_buy_option
(pbo_title, pbo_price, pbo_pbi_seq)
VALUES
('68매', 18920, 16), -- 11
('204매', 36800, 16); -- 12

INSERT INTO coupang_db.product_detail_info
(pdi_pbi_seq, pdi_country, pdi_laws, pdi_importor, pdi_weight, pdi_distribute_days, pdi_built_date)
VALUES(16, '대한민국', null, null, null, null, null);

INSERT INTO coupang_db.product_img
(pi_rew_img, pi_pbi_seq)
VALUES('baby1.jpg', 16);

INSERT INTO coupang_db.coupang_review
(cr_mi_seq, cr_score, cr_option, cr_title, cr_view, cr_pbi_seq)
VALUES
-- (8, 5,  11, '얇고 뽀송뽀송합니다','아기가 3박4일 응가를 한번에할때가있는데 하기스 2단계가 다 커버해줬습니다',16),
-- (16, 4,  12, '저렴, 발진도 없음, 많이움직이면 샘', '이미 재구매 여러번 했고 활동성이 많이질때까지는 재구매할거에요',16),
(9, 4,  12, '자주 갈아줘야 하는 아기에게 완전 딱!', '가격이 저렴해서 자주 갈아주기 좋고 예쁘고 발진이 생기지않으나 많은 양의 소면과 움직임은 감당 못해서 새기도 함',16);

INSERT INTO coupang_db.review_img
(ri_img, ri_cr_seq)
VALUES
('baby1_review1.jpg', 1),
('baby1_review2.jpg', 2);

INSERT INTO coupang_db.product_ask
( pa_explain, pa_mi_seq, pa_pbi_seq, pa_answer,pa_ask_date , pa_answer_date)
VALUES
('기저귀는 받앗는데 애기가 한달정도되니 너무딱맞아서 3단계로 교환할수없을까해서 문의드려요',
10, 16, '안녕하세요. 쿠팡고객센터로 문의바랍니다.',
'2022/10/21 12:04:36', '2022/10/21 13:07:38'),
('1박스면 몇매 선택해야하나요?',
12, 16, '1박스에 68매 *3 팩이며, 총 204매구매하시면 한박스로 출고됩니다.
감사합니다.',
'2022/07/26 15:23:48', '2022/07/26 23:57:27');

INSERT INTO coupang_db.coupang_explain
(ce_cate, ce_view, ce_pbi_seq)
VALUES(1, 'babyexp.jpg', 16);


SELECT * from category_info ci ;
SELECT * from member_info mi ;
SELECT * FROM manufactor_info mi;
SELECT * from store_info si ;
SELECT * FROM delivery_info di ;
SELECT * from product_basic_info pbi ;
SELECT * from product_buy_option pbo ;
SELECT * FROM product_detail_info pdi ;
SELECT * from product_buy_option pbo ;
SELECT * from coupang_review cr ;
SELECT * from review_img ri ;
SELECT * from product_ask pa ;

INSERT INTO coupang_db.manufactor_info
(manu_name)
VALUES('플레이맥스'); -- 22

INSERT INTO coupang_db.store_info
(si_name)
VALUES('(주)플레이맥스'); -- 17

INSERT INTO coupang_db.product_basic_info
(pbi_cate_seq, pbi_title, 
pbi_price, pbi_wow_price, pbi_delivery_seq, pbi_dis_price, pbi_store_seq,
pbi_stock, pbi_ship_seq, pbi_manu_seq)
VALUES(3, '플레이맥스 싹둑요리 과일자르기 놀이 세트',15860, null, 2, 15860, 22,100,1,17); -- 17

SELECT * from product_basic_info pbi ;

INSERT INTO coupang_db.product_detail_info
(pdi_pbi_seq, pdi_country, pdi_laws, pdi_importor, pdi_weight, pdi_distribute_days, pdi_built_date)
VALUES(17, '중국', null, 'Playmax.inc/(주)플레이맥스', '690g', null, null);

INSERT INTO coupang_db.product_img
(pi_rew_img, pi_pbi_seq)
VALUES('baby2.jpg', 17);

INSERT INTO coupang_db.coupang_review
(cr_mi_seq, cr_score, cr_option, cr_title, cr_view, cr_pbi_seq)
VALUES
-- (20, 5,  null, '좋아용','울애기 소근육발달하라고 서줬습니다.',17),
-- (17, 5,  null, '가성비 최고❤', '❤❤가성비 최고의 장난김이예요. 진짜추천합니다❤❤',17),
(6, 5,  null, '공부도 되고, 놀이도 되고!! 일석이조!!', '마침 과일, 야채 등등 먹는 사물 알려주고 있었는데 놀이도 하면서 공부도하는 놀이가 되니 너무 좋아요',17);

INSERT INTO coupang_db.review_img
(ri_img, ri_cr_seq)
VALUES
('baby2_review1.jpg', 12),
('baby2_review2.jpg', 13);

SELECT * from coupang_review cr ;
SELECT * from review_img ri ;
-- DELETE FROM review_img where ri_seq =2;

INSERT INTO coupang_db.product_ask
( pa_explain, pa_mi_seq, pa_pbi_seq, pa_answer,pa_ask_date , pa_answer_date)
VALUES
('보관통 크기 알 수 있을까요??',
11, 17, '플레이맥스 싹둑요리 과일자르기 놀이 세트 상품의 보관통 사이즈는 가로 14cm, 세로 22.5cm인 점 상세페이지 내 안내드리고 있으니 참고하여 이용 부탁드립니다.',
'2022/11/30 14:19:38', '2022/11/30 14:30:22'),
('받고 나서 별도 살균 소독하나요 ?아니면 바로 갖고 놀아도 되는지요 ?',
4, 17, '플레이맥스 싹둑요리 과일자르기 놀이 세트 상품은 제품 사용 시 살균 소독보다는 장난감 세정제를 수건에 적셔서 닦아주는 것을 권장하는 점 참고 부탁드립니다',
'2022/08/31 12:05:35', '2022/08/31 13:22:31');
-- 
INSERT INTO coupang_db.coupang_explain
(ce_cate, ce_view, ce_pbi_seq)
VALUES(1, 'baby2exp.jpg', 17);

-- 제품 중복 검사(이름 같은거 2개 이상이면 조회)
SELECT pbi_title, count(*) as total from product_basic_info 
group by pbi_title
having total >= 2;

-- 제품상세정보 중복 검사
SELECT a.pdi_pbi_seq ,b.pbi_title, GROUP_CONCAT(a.pdi_seq)  , count(*) as total from product_detail_info a join product_basic_info b 
on a.pdi_pbi_seq =b.pbi_seq 
group by pdi_pbi_seq 
having total >= 2;
-- 리뷰 중복 검사
SELECT cr_title, count(*) as total, GROUP_CONCAT(cr_seq) from coupang_review 
join product_basic_info b on b.pbi_seq = cr_pbi_seq
GROUP BY cr_title 
having total>1; -- 35 34 중복
-- DELETE from coupang_review where cr_seq = 34; -- 중복 삭제
SELECT * from coupang_review cr ;
-- 문의 중복 검사
SELECT pa_explain, count(*) as total, GROUP_CONCAT(pa_seq) from product_ask 
GROUP BY pa_explain
having total>1; -- 25 28  29 26  27 30 중복
SELECT * from product_ask;
-- DELETE from product_ask where pa_seq = 25;
-- DELETE from product_ask where pa_seq = 26;
-- DELETE from product_ask where pa_seq = 27; -- 중복 삭제

SELECT * from coupang_review cr ;

SELECT * from product_detail_info pdi ;

-- 상세정보 입력 안된 제품 조회
SELECT a.pbi_title , b.pdi_seq  from product_basic_info a 
left outer join product_detail_info b on b.pdi_pbi_seq = a.pbi_seq 
where pdi_seq is null;

-- 제품명+제품가격+옵션명+옵션가격+카테고리+평점+리뷰등록개수 조회
SELECT a.pbi_title, a.pbi_price ,c.pbo_title ,c.pbo_price ,d.cate_name, e.avg_score
from product_basic_info a 
left outer join product_buy_option c on c.pbo_pbi_seq = a.pbi_seq 
join product_detail_info b on a.pbi_seq = b.pdi_pbi_seq 
join category_info d on a.pbi_cate_seq = d.cate_seq 
join (
SELECT cr_pbi_seq, avg(cr_score) as avg_score from coupang_review  
group by cr_pbi_seq
)e on e.cr_pbi_seq = a.pbi_seq 
order by a.pbi_seq ;

SELECT * from product_buy_option pbo ;
SELECT * from product_basic_info pbi ; -- 13->18  14->19
SELECT * from product_detail_info pdi ;
SELECT * from store_info si ;
SELECT * from manufactor_info mi ;
SELECT * from coupang_review cr ;
SELECT * from product_ask pa ;

-- UPDATE product_ask set pa_pbi_seq = 18 where pa_pbi_seq =13;
-- UPDATE product_ask set pa_pbi_seq = 19 where pa_pbi_seq =14;
-- UPDATE product_detail_info  set pdi_pbi_seq = 18 where pdi_pbi_seq =13;

-- 모든 제품 리뷰 모아보기
SELECT b.pbi_title ,c.mi_id, a.cr_title ,a.cr_view ,a.cr_date,a.cr_score  from coupang_review a
right outer join product_basic_info b on a.cr_pbi_seq = b.pbi_seq 
join member_info c on c.mi_seq = a.cr_mi_seq 
order by b.pbi_seq;
-- 특정 제품 리뷰 모아보기
SELECT b.pbi_title ,c.mi_id, a.cr_title ,a.cr_view ,a.cr_date,a.cr_score  from coupang_review a
right outer join product_basic_info b on a.cr_pbi_seq = b.pbi_seq 
join member_info c on c.mi_seq = a.cr_mi_seq 
where a.cr_pbi_seq = 2
order by b.pbi_seq;
-- 모든 제품 문의 모아보기
SELECT b.pbi_title ,c.mi_id, a.pa_explain ,a.pa_ask_date ,a.pa_answer ,a.pa_answer_date from product_ask a
right outer join product_basic_info b on a.pa_pbi_seq = b.pbi_seq 
join member_info c on c.mi_seq = a.pa_mi_seq 
order by b.pbi_seq;
-- 특정 제품 문의 모아보기
SELECT b.pbi_title ,c.mi_id, a.pa_explain ,a.pa_ask_date ,a.pa_answer ,a.pa_answer_date from product_ask a
right outer join product_basic_info b on a.pa_pbi_seq = b.pbi_seq 
join member_info c on c.mi_seq = a.pa_mi_seq  
where a.pa_pbi_seq = 2
order by b.pbi_seq;

-- 제품당 등록 옵션 개수 조회
SELECT pbo_pbi_seq ,count(*) as total from product_buy_option 
group by pbo_pbi_seq
order by pbo_pbi_seq;
-- 제품당 등록 문의 개수 조회
SELECT pa_pbi_seq  ,count(*) as total from product_ask 
group by pa_pbi_seq
order by pa_pbi_seq;
-- 제품당 등록 리뷰 개수 조회
SELECT cr_pbi_seq, count(*) as total from coupang_review 
group by cr_pbi_seq
order by cr_pbi_seq;
-- 제품 당 평균 평점 조회
SELECT a.cr_pbi_seq,b.pbi_title, avg(a.cr_score) as avg_score from coupang_review a join product_basic_info b
on b.pbi_seq = a.cr_pbi_seq 
group by cr_pbi_seq
order by cr_pbi_seq;


SELECT a.*, b.cate_name, c.review_cnt, 
concat(d.dis_percent,'%') as dis_per, e.avg_score  
from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq 
join (
SELECT cr_pbi_seq, count(*) as review_cnt from coupang_review 
group by cr_pbi_seq
) c on a.pbi_seq = c.cr_pbi_seq
join(
SELECT a.pbi_seq, b.cate_name, floor(((a.pbi_price -a.pbi_dis_price)/a.pbi_price)*100) as dis_percent  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq
) d on d.pbi_seq = a.pbi_seq 
join(
SELECT a.cr_pbi_seq, avg(a.cr_score) as avg_score from coupang_review a join product_basic_info b
on b.pbi_seq = a.cr_pbi_seq 
group by cr_pbi_seq
) e on e.cr_pbi_seq = a.pbi_seq;


-- 상품명 검색 구문
SELECT a.*,b.cate_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq 
where a.pbi_title like '%티셔츠%';
-- 판매자 검색 구문
SELECT a.*,b.cate_name, c.si_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq
join store_info c on c.si_seq =a.pbi_store_seq 
where c.si_name like '%코스%';
-- 카테고리 선택 구문
SELECT a.*,b.cate_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq 
where b.cate_seq = 2;
-- 가격 범위 검색
SELECT a.*,b.cate_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq
where a.pbi_price BETWEEN 10000 and 20000;
-- 날짜범위 검색
SELECT a.*, b.cate_name from product_basic_info a
join category_info b on a.pbi_cate_seq =b.cate_seq 
where a.pbi_reg_dt BETWEEN '2021-01-01' and '2022-01-01';

-- 총 카운트 
SELECT count(*) from product_basic_info pbi ;

-- 페이지 카운트 
SELECT ceil(count(*)/10) as page_count from product_basic_info pbi ;

-- 페이징 처리(1페이지)
SELECT a.*, b.cate_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq 
order by a.pbi_seq limit 10;
-- 페이징 처리(2페이지)
SELECT a.*, b.cate_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq 
order by a.pbi_seq limit 10 offset 10;
-- 페이징 처리(3페이지)
SELECT a.*, b.cate_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq 
order by a.pbi_seq limit 10 offset 20;

-- 가격 기준 오름차순 검색
SELECT a.*, b.cate_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq 
order by a.pbi_price;
-- 가격 기준 내림차순 검색
SELECT a.*, b.cate_name  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq 
order by a.pbi_price desc;

-- 할인률 계산
SELECT a.*, b.cate_name, floor(((a.pbi_price -a.pbi_dis_price)/a.pbi_price)*100) as dis_percent  from product_basic_info a 
join category_info b on a.pbi_cate_seq = b.cate_seq;
-- 기본가 쿠팡판매가 같은거 조회
SELECT * from product_basic_info pbi 
where pbi_price = pbi_dis_price;

-- 무료배송빼고 다 쿠팡배송으로 변경
-- UPDATE product_basic_info  set pbi_ship_seq=8 where pbi_delivery_seq =8; 

-- alter table product_basic_info add column pbi_reg_dt date;
-- 제조사 입력 안된 제품 조회
SELECT a.pbi_title, b.manu_name from product_basic_info a left outer join manufactor_info b 
on a.pbi_manu_seq = b.manu_seq 
where pbi_manu_seq is null;
-- 제품을 등록한 적 없는 제조사 번호 조회
SELECT a.pbi_title, b.manu_name, b.manu_seq  from product_basic_info a right outer join manufactor_info b 
on a.pbi_manu_seq = b.manu_seq 
where a.pbi_seq is null;
-- 판매사 입력 안된 제품 조회
SELECT a.pbi_title, b.si_name  from product_basic_info a left outer join store_info b
on a.pbi_store_seq = b.si_seq  
where pbi_store_seq is null;
-- 제품을 등록한적없는 판매사 조회
SELECT a.pbi_title, b.si_name from product_basic_info a right outer join store_info b 
on a.pbi_store_seq = b.si_seq  
where a.pbi_seq is null;
-- 제품이름+판매자이름+제조사이름
SELECT a.pbi_title,b.si_name, c.manu_name  from product_basic_info a 
left outer join store_info b on a.pbi_store_seq = b.si_seq 
left outer join manufactor_info c on c.manu_seq = a.pbi_manu_seq ;

-- 모든 장바구니 조회
SELECT c.mi_name as name , ifnull(b.pbi_title,'합계') as title, sum(a.cc_count)
,sum(ifnull(b.pbi_dis_price,b.pbi_price)*a.cc_count) as total_price
from coupang_cart a 
join product_basic_info b on a.cc_pbi_seq = b.pbi_seq 
join member_info c on c.mi_seq = a.cc_mi_seq 
group by c.mi_name, b.pbi_title with rollup;

-- 회원별 장바구니 조회
SELECT c.mi_name as name , ifnull(b.pbi_title,'합계') as title, sum(a.cc_count)
,sum(ifnull(b.pbi_dis_price,b.pbi_price)*a.cc_count) as total_price
from coupang_cart a 
join product_basic_info b on a.cc_pbi_seq = b.pbi_seq 
join member_info c on c.mi_seq = a.cc_mi_seq 
where a.cc_mi_seq =1
group by c.mi_name, b.pbi_title with rollup;

SELECT * from order_detail od ;
SELECT * from product_basic_info;
SELECT * from store_info si ;
-- 주문 상세정보 조회
SELECT e.mi_name, c.si_name, ifnull(b.pbi_title,'합계') as title,count(a.od_count) as total_cnt,  sum(ifnull(b.pbi_dis_price,b.pbi_price)) as total  from order_detail a 
join product_basic_info b on a.od_pbi_seq = b.pbi_seq 
join store_info c on c.si_seq = b.pbi_store_seq 
join product_order d on d.po_seq = a.od_po_seq 
join member_info e on e.mi_seq = d.po_mi_seq 
group by e.mi_name, c.si_name, b.pbi_title with rollup;

-- 주문 번호별 합계 조회
-- create view order_price_sum_view as
SELECT a.od_po_seq, sum(ifnull(b.pbi_dis_price,b.pbi_price)) as total  from order_detail a 
join product_basic_info b on a.od_pbi_seq = b.pbi_seq 
group by a.od_po_seq;

-- 배송정보 조회
SELECT c.mi_name, c.mi_address, a.po_msg, a.po_status, b.total from product_order a
join order_price_sum_view b on b.od_po_seq = a.po_seq 
join member_info c on a.po_mi_seq = c.mi_seq ;

-- INSERT INTO coupang_db.review_evaluation
-- (re_pbi_seq, re_evaluation)
-- VALUES(16, '사이즈');
SELECT * from review_evaluation re ;
-- DELETE from review_evaluation where re_seq = 2;

INSERT INTO coupang_db.evaluation_detail
(ed_re_seq, ed_detail)
VALUES
(1, '예상보다 작아요'),
(1, '정사이즈예요'),
(1, '예상보다 커요');

SELECT * from coupang_review cr 
where cr_pbi_seq =16;

INSERT INTO coupang_db.user_evaluation
(ue_re_seq, ue_ed_seq, ue_mi_seq)
VALUES
(1, 2, 8),
(1, 2, 16),
(1, 1, 9);

-- 특정제품의 특정 평가항목에 등록된 평가 수
SELECT ue_re_seq,count(*) as cnt from user_evaluation 
where ue_re_seq =1
group by ue_re_seq ;
-- 특정제품의 특정 평가항목에 특정평가를 남긴 사람 수
SELECT a.ue_ed_seq, b.ed_detail , count(*) as cnt from user_evaluation a 
join evaluation_detail b on b.ed_seq = a.ue_ed_seq 
where a.ue_ed_seq =1
group by a.ue_ed_seq;

-- ??이렇게 길리가없을거같은데
SELECT a.pbi_seq, a.pbi_title 
,(d.child_cnt/c.cnt)*100 as '평가 사이즈-작아요 비율' 
,(e.child_cnt2/c.cnt)*100 as '평가 사이즈-적당해요 비율' from product_basic_info a
join review_evaluation b on b.re_pbi_seq = a.pbi_seq 
join (
SELECT ue_re_seq,count(*) as cnt from user_evaluation 
where ue_re_seq =1
group by ue_re_seq
) c on b.re_seq = c.ue_re_seq
join (
SELECT a.ue_re_seq, b.ed_detail , count(*) as child_cnt from user_evaluation a 
join evaluation_detail b on b.ed_seq = a.ue_ed_seq 
where a.ue_ed_seq =1
group by a.ue_re_seq
)d on d.ue_re_seq = b.re_seq 
join (
SELECT a.ue_re_seq, b.ed_detail , count(*) as child_cnt2 from user_evaluation a 
join evaluation_detail b on b.ed_seq = a.ue_ed_seq 
where a.ue_ed_seq =2
group by a.ue_re_seq
)e on d.ue_re_seq = b.re_seq ;

SELECT a.pbi_seq, a.pbi_title 
,(d.child_cnt/c.cnt)*100 as '평가'
from product_basic_info a
join review_evaluation b on b.re_pbi_seq = a.pbi_seq 
join (
SELECT ue_re_seq,count(*) as cnt from user_evaluation 
where ue_re_seq =1
group by ue_re_seq
) c on b.re_seq = c.ue_re_seq
join (
SELECT a.ue_re_seq, b.ed_detail , count(*) as child_cnt from user_evaluation a 
join evaluation_detail b on b.ed_seq = a.ue_ed_seq 
group by a.ue_re_seq, b.ed_detail
)d on d.ue_re_seq = b.re_seq 
join (
SELECT a.ue_re_seq, b.ed_detail , count(*) as child_cnt2 from user_evaluation a 
join evaluation_detail b on b.ed_seq = a.ue_ed_seq 
where a.ue_ed_seq =2
group by a.ue_re_seq
)e on d.ue_re_seq = b.re_seq ;





