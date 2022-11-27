package service;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import data.Review;
import data.Store;
import data.StoreBasicInfo;
import data.StoreBusinessInfo;
import data.StoreDetialInfo;
import data.StoreMenu;

public class StoreService {
  public static Scanner scan = new Scanner(System.in);
  public static List<Store> storeList = new ArrayList<Store>(); //static이라서 단 하나의 객체만 생성가능(singletone과 비슷한효과)
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

    Integer[] deliveryTime={0,0}; 
    Map<String, Integer> dPrice = new HashMap<String, Integer>();
    // dPrice.put("min", 2000); //map은 값에 의미부여를 데이터를 저장할때 부터 가능함.
    // dPrice.put("max", 3000);
    Map<String, String> openClose = new HashMap<String, String>();
    // openClose.put("open", "13:30");
    // openClose.put("close", "23:30");

    System.out.println("==========가게 기본 정보=========");
    System.out.print("상호 명 : ");
    String store_name = scan.nextLine();
    System.out.print("최소 주문 금액 : ");
    Integer store_min_order_price = scan.nextInt();
    System.out.print("최소 배달시간(분) : ");
    deliveryTime[0] = scan.nextInt();
    System.out.print("최대 배달시간(분) : ");
    deliveryTime[1] = scan.nextInt();
    System.out.print("배달 팁 최소 : ");
    Integer dPriceMin = scan.nextInt();
    System.out.print("배달 팁 최대 : ");
    Integer dPriceMax = scan.nextInt();
    scan.nextLine();
    dPrice.put("min", dPriceMin);
    dPrice.put("max", dPriceMax);
    System.out.println("==========가게 상세 정보=========");
    System.out.print("가게 소개 글 : ");
    String introduce = scan.nextLine();
    System.out.print("가게 공지사항 : ");
    String notice = scan.nextLine();
    System.out.print("개점 시간(00:00) : ");
    String open = scan.nextLine();    
    System.out.print("폐점 시간(00:00) : ");
    String close = scan.nextLine();
    System.out.print("휴무일 : ");
    String off = scan.nextLine();
    System.out.print("가게 전화번호 : ");
    String phone = scan.nextLine();
    System.out.print("배달 가능 지역 : ");
    String area = scan.nextLine();
    openClose.put("open", open);
    openClose.put("close", close);
    System.out.println("==========사업자 정보=========");
    System.out.print("대표자 : ");
    String owner = scan.nextLine();  
    System.out.print("사업자 명 : ");
    String store = scan.nextLine();  
    System.out.print("주소 : ");
    String address = scan.nextLine();  
    System.out.print("사업자 번호 : ");
    String regNo = scan.nextLine();
    
    Store s = new Store(new StoreBasicInfo(store_name, 0.0, store_min_order_price, deliveryTime, dPrice),
      new StoreDetialInfo(introduce, notice, openClose, off, phone, area),
      new StoreBusinessInfo(owner, store, address, regNo));
    storeList.add(s);
    BufferedWriter w = null;
    try{
      w = new BufferedWriter(
        new OutputStreamWriter(
          new FileOutputStream(
            new File("store.dat"), true
          ),"UTF-8"
        )
      );
      w.write(s.basicInfo.getDataString()+";"+s.detialInfo.getDataString()+";"+s.businessInfo.getDataString()+"\r\n");
    } catch(Exception e){
      System.out.println(e.getMessage());
    }finally{
      try{
        w.close();
      }catch(Exception e){}
    }
  }
  public static void selectStore(){
    System.out.print("가게 선택 (0 ~ "+(storeList.size()-1)+") : ");
    Integer sel = scan.nextInt();
    scan.nextLine();
    if(sel<0 || sel >= storeList.size()){
      System.out.println("잘못된 번호선택입니다.");
      return;
    }
    selectedStore = storeList.get(sel);
    System.out.println(selectedStore.basicInfo);
  }
  public static void showStoreMenus(){
    if(selectedStore == null){
      System.out.println("먼저 가게를 선택하세요");
      return;
    }
    if(selectedStore.menus.size()==0){
      System.out.println("등록된 메뉴 없음");
    }else{
      for(int i=0;i<selectedStore.menus.size();i++){
        System.out.println(i+"번 메뉴\n"+selectedStore.menus.get(i));
      }
    }
  }
  public static void addStoreMenu(){
    if(selectedStore == null){
      System.out.println("먼저 가게를 선택하세요");
      return;
    }
    System.out.print("메뉴 이미지 : ");
    String img = scan.nextLine();
    System.out.print("메뉴 이름 : ");
    String name = scan.nextLine();
    System.out.print("메뉴 설명 : ");
    String desc = scan.nextLine();    
    System.out.print("가격 : ");
    Integer price = scan.nextInt();
    scan.nextLine();
    selectedStore.menus.add(new StoreMenu(img, name, desc, price));
  }
  public static void showStoreReview(){
    if(selectedStore == null){
      System.out.println("먼저 가게를 선택하세요");
      return;
    }
    if(selectedStore.reviews.size()==0){
      System.out.println("등록된 리뷰 없음");
    }else{
      for(int i=0;i<selectedStore.reviews.size();i++){
        System.out.println(i+"번 리뷰\n"+selectedStore.reviews.get(i));
      }
    }
  }
  public static void addStoreRevie(){
    if(selectedStore == null){
      System.out.println("먼저 가게를 선택하세요");
      return;
    }
    System.out.print("작성자 명 : ");
    String id = scan.nextLine();    
    System.out.print("평점(1~5) : ");
    Integer score = scan.nextInt();
    scan.nextLine();
    System.out.print("리뷰내용 : ");
    String content = scan.nextLine();
    selectedStore.reviews.add(new Review(id, score, content));
    int sum=0;
    for(Review r : selectedStore.reviews){
      sum += r.score;
    }
    selectedStore.basicInfo.score = sum/(double)selectedStore.reviews.size();
  }
  public static void storeInfoInitialize() { //파일을 읽어와서 storeList에 추가하는 메소드
    BufferedReader reader = null;
    try{
      reader = new BufferedReader(
        new InputStreamReader(
          new FileInputStream(
            new File("store.dat")
          ),"UTF-8"
        )
      );
      while(true){
        String line = reader.readLine();
        if(line == null) break;
        String[] split = line.split(";");
        String name = split[0];
        Integer min_order_price = Integer.parseInt(split[1]);
        Integer[] delivery_time = { Integer.parseInt(split[2]), Integer.parseInt(split[3])};
        Map<String, Integer> delivery_price = new HashMap<String, Integer>();
        delivery_price.put("min", Integer.parseInt(split[4]));
        delivery_price.put("max", Integer.parseInt(split[5]));
        String introduce = split[6];
        String notice = split[7];
        Map<String, String> openclose = new HashMap<String, String>();
        openclose.put("open", split[8]);
        openclose.put("close", split[9]);
        String offDay = split[10];
        String phone = split[11];
        String delivery_area = split[12];

        String owner = split[13];
        String businessName = split[14];
        String businessPhone = split[15];
        String regNo = split[16];
        Store s = new Store(
          new StoreBasicInfo(name, 0.0, min_order_price, delivery_time, delivery_price),
          new StoreDetialInfo(introduce, notice, openclose, offDay, phone, delivery_area),
          new StoreBusinessInfo(owner, businessName, businessPhone, regNo));
          storeList.add(s);
        }
    }catch(Exception e){
      
    }finally{
      try{ reader.close();}
      catch(Exception e){}
    }
  }
  
}
