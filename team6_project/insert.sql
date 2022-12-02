-- 제품정보 입력
INSERT INTO coupang_db.manufactor_info
(manu_name)
VALUES('플레이맥스'); 

INSERT INTO coupang_db.store_info
(si_name)
VALUES('(주)플레이맥스'); 

INSERT INTO coupang_db.product_basic_info
(pbi_cate_seq, pbi_title, 
pbi_price, pbi_wow_price, pbi_delivery_seq, pbi_dis_price, pbi_store_seq,
pbi_stock, pbi_ship_seq, pbi_manu_seq)
VALUES(3, '플레이맥스 싹둑요리 과일자르기 놀이 세트',15860, null, 2, 15860, 22,100,1,17); 

INSERT INTO coupang_db.product_detail_info
(pdi_pbi_seq, pdi_country, pdi_laws, pdi_importor, pdi_weight, pdi_distribute_days, pdi_built_date)
VALUES(17, '중국', null, 'Playmax.inc/(주)플레이맥스', '690g', null, null);

INSERT INTO coupang_db.product_img
(pi_rew_img, pi_pbi_seq)
VALUES('baby2.jpg', 17);

INSERT INTO coupang_db.coupang_review
(cr_mi_seq, cr_score, cr_option, cr_title, cr_view, cr_pbi_seq)
VALUES
(20, 5,  null, '좋아용','울애기 소근육발달하라고 서줬습니다.',17),
(17, 5,  null, '가성비 최고❤', '❤❤가성비 최고의 장난김이예요. 진짜추천합니다❤❤',17),
(6, 5,  null, '공부도 되고, 놀이도 되고!! 일석이조!!', '마침 과일, 야채 등등 먹는 사물 알려주고 있었는데 놀이도 하면서 공부도하는 놀이가 되니 너무 좋아요',17);

INSERT INTO coupang_db.review_img
(ri_img, ri_cr_seq)
VALUES
('baby2_review1.jpg', 12),
('baby2_review2.jpg', 13);

INSERT INTO coupang_db.product_ask
( pa_explain, pa_mi_seq, pa_pbi_seq, pa_answer,pa_ask_date , pa_answer_date)
VALUES
('보관통 크기 알 수 있을까요??',
11, 17, '플레이맥스 싹둑요리 과일자르기 놀이 세트 상품의 보관통 사이즈는 가로 14cm, 세로 22.5cm인 점 상세페이지 내 안내드리고 있으니 참고하여 이용 부탁드립니다.',
'2022/11/30 14:19:38', '2022/11/30 14:30:22'),
('받고 나서 별도 살균 소독하나요 ?아니면 바로 갖고 놀아도 되는지요 ?',
4, 17, '플레이맥스 싹둑요리 과일자르기 놀이 세트 상품은 제품 사용 시 살균 소독보다는 장난감 세정제를 수건에 적셔서 닦아주는 것을 권장하는 점 참고 부탁드립니다',
'2022/08/31 12:05:35', '2022/08/31 13:22:31');
 
INSERT INTO coupang_db.coupang_explain
(ce_cate, ce_view, ce_pbi_seq)
VALUES(1, 'baby2exp.jpg', 17);


-- 상품평가 정보
INSERT INTO coupang_db.review_evaluation
(re_pbi_seq, re_evaluation)
VALUES
(3, '사이즈'),
(3, '색상'); 

INSERT INTO coupang_db.evaluation_detail
(ed_re_seq, ed_detail)
VALUES
(2, '예상보다 작아요'),
(2, '정사이즈예요'),
(2, '예상보다 커요'),
(3, '화면과 비슷해요'),
(3, '화면과 같아요'),
(3, '화면과 달라요');

INSERT INTO coupang_db.user_evaluation
(ue_re_seq, ue_ed_seq, ue_mi_seq)
VALUES
(2, 2, 0),
(2, 2, 0),
(2, 2, 0),
(3, 1, 0),
(3, 2, 0),
(3, 2, 0);

-- 리뷰 도움이돼요/안돼요 입력
INSERT INTO coupang_db.review_help
(rh_mi_seq, rh_cr_seq, rh_type)
VALUES
(1, 1, 1),
(2, 1, 1),
(3, 1, 3),
(4, 1, 1),
(5, 1, 2),
(6, 1, 1),
(7, 1, 1),
(8, 1, 2),
(9, 1, 1),
(10, 1, 1);
