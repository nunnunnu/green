public class StoreMain {
    public static void main(String[] args) {
        int[] payment = {0,1};
        StoreSummaryInfo summary = new StoreSummaryInfo(
            "store.jpg", "교촌치킨 송현점", 4.9, "053-123-4567", 1746, 16000, 38, 53, payment
        );
        DeliveryBoundary[] boundary_list = {
            new DeliveryBoundary(16000, 3000),
            new DeliveryBoundary(50000, 2000)
        };
        StoreDetailInfo detail = new StoreDetailInfo(
            "가게 바쁜 시간에 시간이 많이 걸릴수도 있습니다 시간은 오래 걸려도 따뜻한 치킨을 배달 하겠습니다^^",
            "교촌치킨 송현1호점",
            "12:30",
            "23:35",
            "송현1동 송현2동 본동일부 상인동 대명동",
            "고객님 포장 주문시 접수번호를 먼저 말씀하셔야 합니다 혹 그것이 귀찮을 시 안심번호 하시지 마시고 휴대폰번호 하시면 편리합니다.",
            null,
            boundary_list
        );
        StoreBusinessInfo business = new StoreBusinessInfo(
            "노경곤",
            "교촌치킨 송현1호점",
            "대구광역시 달서구 송현동 207-2",
            "514-25-55195"
        );
        StoreInfo info = new StoreInfo(summary, detail, business);
        System.out.println(info);
    }
}
