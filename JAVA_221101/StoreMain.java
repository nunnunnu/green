public class StoreMain {
  public static void main(String[] args) {
    StoreInfo store = new StoreInfo();
    String[] payments={"바로결제","만나서결제"};
    StoreBasicInfo basicInfo = new StoreBasicInfo("store.jpg", "교촌치킨 송현점", 4.9, 16000, payments, 38, 53, 2000, 3000);
    store.store_basic = basicInfo;
    System.out.println(basicInfo);
    DeliveryBoundary[] boundaries = {
      new DeliveryBoundary(50000, 2000),
      new DeliveryBoundary(16000, 3000)
    };
    StoreDetailInfo detailInfo = new StoreDetailInfo("바쁘면 오래걸림, 따뜻한 치킨 배달하겠음",
      "교촌치킨 송현1호점", "12:30", "23:35", null, "050-6115-1090", "송현1동 송현2동 본동일부 상인동 대명동", 
      "포장은 접수번호를 말하세요, 귀찮으면 전번 알려주세요", boundaries);
      store.store_detail=detailInfo;
      StoreBusinessInfo businessInfo = new StoreBusinessInfo("노경곤", "교촌치킨 송현 1호점", "대구광역시 달서구 송현동 207-2", "541-25-55195");
      store.store_business = businessInfo;
      System.out.println(store);
  }
}
