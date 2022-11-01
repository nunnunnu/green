public class restaurantEx {
  public static void main(String[] args) {
    String attr[] = {"cafe.jpg","커피홀","오전 8:50","오후 11:00","내당동, 비산동, ...","디저트만 배달이 불가합니다. 음료와 함께 주문해주세요"};
    restaurant cafe = new restaurant(attr,10000,9,24,1000,2500,0,5,15,"대구 서구 내당동 890-37");
    cafe.showInfo();
    System.out.println();
    // restaurant chicken = new restaurant();
    // chicken.setName("동근이숯불두마리치킨");
    // chicken.setMinAmount(16000);
    // chicken.setMinTime(49);
    // chicken.setMaxTime(64);
    // chicken.setMaxDeliveryTips(2000);
    // chicken.setPickUpAmount(1000);
    // chicken.setAddress("대구광역시 북구 고성동2가 114-9 1층");
    // chicken.setPickUpMaxTime(32);
    // chicken.setPickUpMinTime(22);
    // chicken.showInfo();
    // System.out.println();
    
    cafe.addmenu("아메리카노", "3700");
    cafe.addmenu("바닐라라떼", "4500");
    cafe.addmenu("흑당카페라떼", "5300");
    cafe.addmenu("제주한라봉스무디", "5300");
    cafe.addmenu("콜드브루 아인슈페너", "5500");
    cafe.addmenu("홍시주스", "5500");
    cafe.addmenu("초코렛라떼", "4300");
    cafe.addmenu("그린티라떼", "4300");
    cafe.addmenu("캐모마일허브티", "4300");
    cafe.addmenu("망고쥬스", "5500");
    cafe.addmenu("레몬에이드", "5000");
    System.out.println();
    System.out.println();
    cafe.showInfo();

    cafe.addcart("아메리카노", 2,0);
    System.out.println();
    cafe.addcart("아메", 2,1);
    System.out.println();
    cafe.addcart("바닐라라떼", 10,1);
    System.out.println();
    cafe.addcart("콜드브루 아인슈페너", 3,0);

    cafe.order(0);
    System.out.println();
    cafe.order(1);

  }
}
