public class StoreDetailInfo {
    // Detail Info
    String store_introduce; // 가게 소개 글
    String store_origin_name; // 가게 이름 (원본)
    String store_open_time; // 가게 개점 시간
    String store_close_time; // 가게 폐점 시간
    String store_delivery_area; // 가게 배달 가능 지역
    String store_notice; // 가게 공지사항

    int[] store_close_days; // 가게 휴무일
    DeliveryBoundary[] store_delivery_boundaries; // 주문금액에 따른 배달비

    public StoreDetailInfo(
        String intro, String name, String open, String close, String area, String notice, int[] close_days, DeliveryBoundary[] boundaries
    ) {
        this.store_introduce = intro;
        this.store_origin_name = name;
        this.store_open_time = open;
        this.store_close_time = close;
        this.store_delivery_area = area;
        this.store_notice = notice;
        this.store_close_days = close_days;
        this.store_delivery_boundaries = boundaries;
    }
    @Override
    public String toString() {
        String info = "----------------------- 상세정보 ----------------------\n";
        info += "가게소개 =======\n";
        info += store_introduce+"\n";
        info += "상호명 : "+store_origin_name+"\n";
        info += "운영시간 : "+store_open_time+" ~ "+store_close_time+"\n";
        if(store_close_days == null) {
            info += "휴무일 : 연중 무휴\n";
        }
        else {
            info += "휴무일 : ";
            for(int i : store_close_days)  {
                info += StoreValues.CLOSE_DAY[i]+" ";
            }
            info += "\n";
        }
        info += "배달지역 : "+store_delivery_area+"\n";
        info += "안내 및 혜택\n";
        info += store_notice+"\n";
        if(store_delivery_boundaries == null) {
            info += "배달비 : 무료\n";
        }
        else {
            info += "배달비 : ";
            for(DeliveryBoundary boundary : store_delivery_boundaries) {
                info += boundary.boundary+"원 이상 => "+boundary.price+"원 ";
            }
            info += "\n";
        }
        return info;
    }
}
