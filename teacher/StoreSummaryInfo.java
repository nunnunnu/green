public class StoreSummaryInfo {
    // Summary Info
    String store_img; // 가게 이미지
    String store_title; // 가게 이름
    double store_score; // 가게 평점
    String store_phone; // 가게 전화번호
    
    int store_like; // 가게 좋아요 수
    int store_min_order_price; // 가게 최소 주문 금액
    int store_min_delivery_time; // 가게 최소 배달 시간
    int store_max_delivery_time; // 가게 최대 배달 시간

    int[] store_payment; // 결제 방법
    
    public StoreSummaryInfo(String img, String title, double score, String phone, int like, int min_price, int min_delivery_time, int max_delivery_time, int[] payment) {
        this.store_img = img;
        this.store_title = title;
        this.store_score = score;
        this.store_phone = phone;
        this.store_like = like;
        this.store_min_order_price = min_price;
        this.store_min_delivery_time = min_delivery_time;
        this.store_max_delivery_time = max_delivery_time;
        this.store_payment = payment;
    }
    @Override
    public String toString() {
        String info = "----------------------- 기본정보 ----------------------\n";
        info += "가게 이미지 : "+store_img+"\n";
        info += "가게 이름 : "+store_title+"\n";
        info += "평점 : "+store_score+" / ";
        info += "전화번호 : "+store_phone+" / ";
        info += "좋아요 : "+store_like+"\n";
        info += "최소주문금액 : "+store_min_order_price+"원\n";
        info += "배달시간 : "+store_min_delivery_time+" ~ "+store_max_delivery_time+"분";
        return info;
    }
}
