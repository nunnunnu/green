import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreService {
  public static List<Store> storeList = new ArrayList<Store>(); //static이라서 단 하나의 객체만 생성가능(singletone과 다를바없음)
  public static Store selectedStore = null;
  public static void showStoreList(){
    if(storeList.size()==0){
      System.out.println("등록된 가게가 없습니다.");
    }else{
      for(Store s : storeList){
        System.out.println(s.basicInfo);
      }
    }
  }
  public static void addStore(/* Store store */){
    Integer[] deliveryTime={30,50}; 
    Map<String, Integer> dPrice = new HashMap<String, Integer>();
    dPrice.put("min", 2000); //map은 값에 의미부여를 데이터를 저장할때 부터 가능함.
    dPrice.put("max", 3000);
    Map<String, String> openClose = new HashMap<String, String>();
    openClose.put("open", "13:30");
    openClose.put("close", "23:30");
    
    Store s = new Store(new StoreBasicInfo("가게 이름", 0.0, 16000, deliveryTime, dPrice),
      new StoreDetialInfo("가게 소개글", "가게 공지사항", openClose, "연중무후", "053-123-4567", "대구 중구"),
      new StoreBusinessInfo("곽두팔", "치킨집", "대구광역시 중구 중앙대로 394", "456-87-457857"));
    storeList.add(s);
  }
  public static void selectedStore(){
    Integer sel = 0;
    selectedStore = storeList.get(sel);
  }
  public static void showStoreMenus(){
      if(selectedStore.menus.size()==0){
        System.out.println("등록된 메뉴 없음");
      }else{
        for(int i=0;i<selectedStore.menus.size();i++){
          System.out.println(i+"번 메뉴\n"+selectedStore.menus.get(i));
      }
    }
  }
  public static void addStoreMenu(){
    selectedStore.menus.add(new StoreMenu("menu.jpg", "후라이드", "튀긴거", 13000));
  }
  public static void showStoreReview(){
    if(selectedStore.reviews.size()==0){
      System.out.println("등록된 리뷰 없음");
    }else{
      for(int i=0;i<selectedStore.reviews.size();i++){
        System.out.println(i+"번 리뷰\n"+selectedStore.reviews.get(i));
      }
    }
  }
  public static void addStoreRevie(){
    selectedStore.reviews.add(new Review("user001", 5, "잘먹었습니다."));
  }
  
}
