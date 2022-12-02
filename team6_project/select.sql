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
having total>1;
-- 문의 중복 검사
SELECT pa_explain, count(*) as total, GROUP_CONCAT(pa_seq) from product_ask 
GROUP BY pa_explain
having total>1;
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
left outer join (
SELECT cr_pbi_seq, avg(cr_score) as avg_score from coupang_review  
group by cr_pbi_seq
)e on e.cr_pbi_seq = a.pbi_seq 
order by a.pbi_seq ;
-- 리뷰별 좋아요 싫어요 조회(view생성함)
-- create view review_like_cnt_view as
SELECT a.rh_cr_seq,a.rh_type, count(*) as like_cnt, c.unlike_cnt FROM review_help a 
left outer join (
SELECT b.rh_cr_seq, b.rh_type, count(*) as unlike_cnt FROM review_help b
where b.rh_type =2
group by b.rh_cr_seq, b.rh_type
) c on c.rh_cr_seq = a.rh_cr_seq 
where a.rh_type =1
group by a.rh_cr_seq, a.rh_type 
UNION 
SELECT a.rh_cr_seq,a.rh_type, ifnull(count(*),0) as like_cnt, c.unlike_cnt FROM review_help a 
right outer join (
SELECT b.rh_cr_seq, b.rh_type, ifnull(count(*),0) as unlike_cnt FROM review_help b
where b.rh_type =2
group by b.rh_cr_seq, b.rh_type
) c on c.rh_cr_seq = a.rh_cr_seq 
where a.rh_type =1
group by a.rh_cr_seq, a.rh_type ;
-- 모든 제품 리뷰 모아보기
SELECT b.pbi_title ,c.mi_id, a.cr_title ,a.cr_view ,a.cr_date,a.cr_score
,ifnull(e.like_cnt,0) as like_cnt
, ifnull(e.unlike_cnt,0) as unlike_cnt
from coupang_review a
right outer join product_basic_info b on a.cr_pbi_seq = b.pbi_seq 
join member_info c on c.mi_seq = a.cr_mi_seq  
left outer join review_like_cnt_view e on e.rh_cr_seq = a.cr_seq 
order by b.pbi_seq;
-- 특정 제품 리뷰 모아보기
SELECT b.pbi_title ,c.mi_id, a.cr_title ,a.cr_view ,a.cr_date,a.cr_score
,ifnull(e.like_cnt,0) as like_cnt
, ifnull(e.unlike_cnt,0) as unlike_cnt
from coupang_review a
right outer join product_basic_info b on a.cr_pbi_seq = b.pbi_seq 
join member_info c on c.mi_seq = a.cr_mi_seq 
left outer join review_like_cnt_view e on e.rh_cr_seq = a.cr_seq 
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
-- 내보내기용?
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
-- 기본가 쿠팡판매가 같은거 조회(할인율 안나와서 오류잡으려고 만들었음)
SELECT * from product_basic_info pbi 
where pbi_price = pbi_dis_price;
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
-- 특정제품의 특정 평가항목에 등록된 평가 수
SELECT ue_re_seq,count(*) as cnt from user_evaluation 
where ue_re_seq =1
group by ue_re_seq ;
-- 특정제품의 특정 평가항목에 특정평가를 남긴 사람 수
SELECT a.ue_ed_seq, b.ed_detail , count(*) as cnt from user_evaluation a 
join evaluation_detail b on b.ed_seq = a.ue_ed_seq 
where a.ue_ed_seq =1
group by a.ue_ed_seq;
-- 제품별 평가 항목
SELECT a.pbi_seq, a.pbi_title,b.re_evaluation,d.ed_detail, (d.child_cnt/c.cnt)*100 as '평가'
from product_basic_info a
join review_evaluation b on b.re_pbi_seq = a.pbi_seq 
join (
SELECT ue_re_seq,count(*) as cnt from user_evaluation 
group by ue_re_seq
) c on b.re_seq = c.ue_re_seq
join (
SELECT a.ue_re_seq, b.ed_detail , count(*) as child_cnt from user_evaluation a 
join evaluation_detail b on b.ed_seq = a.ue_ed_seq 
group by a.ue_re_seq, b.ed_detail
)d on d.ue_re_seq = c.ue_re_seq;
-- 특정 제품 평가 항목
SELECT a.pbi_seq, a.pbi_title,b.re_evaluation,d.ed_detail, (d.child_cnt/c.cnt)*100 as '평가'
from product_basic_info a
join review_evaluation b on b.re_pbi_seq = a.pbi_seq 
join (
SELECT ue_re_seq,count(*) as cnt from user_evaluation 
group by ue_re_seq
) c on b.re_seq = c.ue_re_seq
join (
SELECT a.ue_re_seq, b.ed_detail , count(*) as child_cnt from user_evaluation a 
join evaluation_detail b on b.ed_seq = a.ue_ed_seq 
group by a.ue_re_seq, b.ed_detail
)d on d.ue_re_seq = b.re_seq
where a.pbi_seq =3;