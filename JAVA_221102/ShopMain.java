import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopMain {
  static List<ProductInfo> prodList = new ArrayList<ProductInfo>();
  static Integer no = 0; //중간에 데이터가 삭제돼도 제품번호를 당기지는 않음
  static Scanner s = new Scanner(System.in);
  public static void main(String[] args) {
    for(int i=0;i<10;i++){
      initializeData(); //10개의 데이터추가 10번 반복
    }
    //1.제품추가, 2.제품삭제, 3.제품수정, 4.제품목록
    while(true){
      System.err.print("1.제품추가, 2.제품삭제, 3.제품수정, 4.제품목록, 0.종료 >> " );
      int sel = s.nextInt();
      s.nextLine();
      if(sel==0){
        System.out.println("프로그램을 종료합니다.");
        s.close();
        return;
      }
      else if(sel ==1){
        addProduct();
      }
      else if(sel ==2){
        deletedProduct();
      }
      else if(sel==3){
        updateProduct();
      }
      else if(sel ==4){
        showProductList();
      }
    }
  }
  public static void addProduct(){
    System.out.print("제품 명 : ");
    String name = s.nextLine();
    System.out.print("가격 : ");
    Integer price = s.nextInt();
    System.out.print("재고 : ");
    Integer stock = s.nextInt();
    System.out.print("할인률(%) : ");
    Integer dc_percent = s.nextInt();

    prodList.add(new ProductInfo(no, name, price, stock, dc_percent/100.0));
    no++;
    System.out.println("제품정보가 등록되었습니다.");
  }
  public static void deletedProduct(){
    System.out.print("삭제할 제품의 번호("+(prodList.get(0).prod_no+"-"+(prodList.get(prodList.size()-1).prod_no)+") : >> "));
    int n = s.nextInt();
    s.nextLine();
    int index=0;
    boolean check=false;
    for(int i=0;i<prodList.size();i++){
      if(prodList.get(i).prod_no == n){
        index = i;
        check = true;
        break;
      }
    }
    if(!check){
      System.out.println("등록된 제품번호가 아닙니다.");
      return;
    }
    // if(n>= prodList.size()){
    //   System.out.println("잘못된 제품번호입니다.");
    //   return; //메소드 종료
    // }
    ProductInfo p = prodList.get(index);
    p.showInfo();
    System.out.print("삭제하시겠습니까? (y/n) >");
    String confirm = s.nextLine();
    if(confirm.equalsIgnoreCase("y")){
      prodList.remove(index);
      System.out.println("삭제하였습니다.");
    }else {
      System.out.println("삭제가 취소되었습니다.");
    }
  }
  public static void updateProduct(){
    System.out.print("수정할 제품의 번호("+(prodList.get(0).prod_no+"-"+(prodList.get(prodList.size()-1).prod_no)+") : >> "));
    int n = s.nextInt();
    s.nextLine();
    int index=0;
    boolean check=false;
    for(int i=0;i<prodList.size();i++){
      if(prodList.get(i).prod_no == n){
        index = i;
        check = true;
        break;
      }
    }
    if(!check){
      System.out.println("등록된 제품번호가 아닙니다.");
      return;
    }
    ProductInfo p = prodList.get(index);
    p.showInfo();
    System.out.println("=======수정 정보 입력=========");
    System.out.print("제품명 (기존 : "+p.prod_name+") : >> ");
    String name = s.nextLine();
    if(name.length()==0){ //입력안했을때
      name = p.prod_name; //기존정보 유지
    }
    System.out.print("가격 (기존 : "+p.prod_price+"원) : >> ");
    Integer price = s.nextInt();
    s.nextLine();
    System.out.print("재고 (기존 : "+p.prod_stock+"개) : >> ");
    Integer stock = s.nextInt();
    s.nextLine();
    System.out.print("할인율 (기존 : "+p.prod_dc_rate+"%) : >> ");
    Integer dc_percent = s.nextInt();
    s.nextLine();
    System.out.print("수정하시겠습니까? (y/n) >");
    String confirm = s.nextLine();
    if(confirm.equalsIgnoreCase("y")){
      prodList.set(index, new ProductInfo(index, name, price, stock, dc_percent/100.0));
      System.out.println("수정하였습니다.");
    }else {
      System.out.println("수정이 취소되었습니다.");
    }
    
    
    
    
    
  }
  public static void showProductList(){
    // for(ProductInfo p : prodList){
    //   System.out.println("-------------------");
    //   p.showInfo();
    //   System.out.println("할인 적용가 : "+p.getDiscountedPrice()+"원");
    // } //인덱스 번호 표시못함.
    for(int i=0;i<prodList.size();i++){
      System.out.println("========["+i+"]========");
      prodList.get(i).showInfo();
      System.out.println("할인 적용가 : "+prodList.get(i).getDiscountedPrice()+"원");
    }//인덱스 번호 표시가능
  }
  public static void initializeData(){
    prodList.add(new ProductInfo(no, "입욕제 굿나잇 4구 세트", 19500, 50, 0.0));
    no++;
    prodList.add(new ProductInfo(no, "편백 스프레이 3종", 24900, 50, 0.20));
    no++;
    prodList.add(new ProductInfo(no, "볶음밥 5종", 19980, 50, 0.36));
    no++;
    prodList.add(new ProductInfo(no, "국산 콩두부 300g", 1900, 50, 0.0));
    no++;
    prodList.add(new ProductInfo(no, "머스크 멜론 1.5kg", 9990, 50, 0.0));
    no++;
    prodList.add(new ProductInfo(no, "유정란 20구", 9550, 50, 0.07));
    no++;
    prodList.add(new ProductInfo(no, "한우양지국거리 200g", 12900, 50, 0.28));
    no++;
    prodList.add(new ProductInfo(no, "실속 바나나 1kg", 3700, 50, 0.15));
    no++;
    prodList.add(new ProductInfo(no, "갈비탕", 12000, 50, 0.0));
    no++;
    prodList.add(new ProductInfo(no, "깐대파 500g", 2990, 50, 0.0));
    no++;
  }
}
