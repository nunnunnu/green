public class KurlyProduct {

  final String[] delivery = {"일반택배","샛별배송","낮배송"};
  private String prod_img; //상품이미지
  private String prod_manufacturer; //상품제조사
  private String prod_title; //상품명
  private String prod_sub_title; //상품부제목
  private String prod_seller; //판매자
  private String prod_unit; //상품판매단위
  private String prod_quantity; //상품용량
  private String prod_notice; //안내사항
  
  //정보 은닉
  private int prod_price; //가격
  private double prod_discount_rate; //할인률
  private double prod_Point_rate; //적립률
  private int prod_delivery_type; //배송타입 0-일반택배/ 1-샛별배송 / 2-낮배송
  private int prod_stock; //재고

  public KurlyProduct(){}
  public KurlyProduct(String[] attr, int price, double discount, double point, int delivery_type, int stock){
    if(attr.length!=8){
      System.out.println("누락된 문자열 값이 있거나, 문자열 수가 많습니다.");
      System.out.println("8개 항목 : {이미지, 제조사, 제품명, 부제목, 판매자, 판매단위, 상품용량, 안내사항}");
    }else{
      prod_img = attr[0];
      prod_manufacturer = attr[1];
      prod_title = attr[2];
      prod_sub_title = attr[3];
      prod_seller = attr[4];
      prod_unit = attr[5];
      prod_quantity = attr[6];
      prod_notice = attr[7];
    }
    setProductPrice(price);
    setProductDiscountRate(discount);
    setProductPointRate(point);
    setProductDeliveryType(delivery_type);
    setProductStock(stock);
  }
  
  void printProductInfo(boolean login){
    System.out.println("제품 이미지 :"+prod_img);
    System.out.println("배송구분 :"+delivery[prod_delivery_type]);
    System.out.println("["+prod_manufacturer+"]"+prod_title);
    System.out.println(prod_sub_title);
    if(login){
      System.out.println("제품 원가 : "+prod_price+"원");
      System.out.println("할인률 : "+(int)(prod_discount_rate*100)+"%");
      System.out.println("할인 적용 가 : "+getDiscountedPrice(login)+"원");
      System.out.println("적립율 : "+(int)(prod_Point_rate*100)+"%");
      System.out.println("적립포인트 : "+getSavingPoint(login)+"점");
    }else{
      System.out.println("제품 가격 : "+prod_price+"원");
    }
    System.out.println("판매자 : "+prod_seller);
    System.out.println("판매단위 : "+prod_unit);
    System.out.println("제품용량 : "+prod_quantity);
    System.out.println("제품안내사항 : "+prod_notice);
  }
  int getDiscountedPrice(boolean login){
    if(login){
      return (int)(prod_price*(1-prod_discount_rate));
    }
    return prod_price;
    }
  int getSavingPoint(boolean login){
    if(login){
      return (int)(getDiscountedPrice(login)*prod_Point_rate);
    }
    return 0;
  }
  boolean isOrderAvailable(){ //재고가없으면 false
    return prod_stock>0;
  }
  boolean productOrder(int stock){
    if(prod_stock-stock>=0){
      System.out.println("제품을 "+stock+"개 주문했습니다.");
      prod_stock -= stock;
      return true;
    }
      System.out.println("제품의 재고가 부족합니다. (재고수량 : "+prod_stock+")");
      return false;
  }

  void setProductPrice(int price){
    if(price<0){
      prod_price = 0;
    }else {
      prod_price = price;
    }
  }
  void setProductDiscountRate(double discount_rate){
    if(discount_rate<0){
      prod_discount_rate = 0;
    }else if(discount_rate>=1){
      prod_discount_rate=1;
    }else {
      prod_discount_rate = discount_rate;
    }
  }
  void setProductDiscountRate(int discount_rate){
    if(discount_rate<0){
      prod_discount_rate = 0;
    }else if(discount_rate>=100){
      prod_discount_rate=1;
    }else {
      prod_discount_rate = discount_rate/100.0;
    }
  }
  void setProductPointRate(double point_rate){
    if(point_rate<0){
      prod_Point_rate = 0;
    }else if(point_rate>=1){
      prod_Point_rate=1;
    }else {
      prod_Point_rate = point_rate;
    }
  }
  void setProductPointRate(int point_rate){
    if(point_rate<0){
      prod_Point_rate = 0;
    }else if(point_rate>=100){
      prod_Point_rate=1;
    }else {
      prod_Point_rate = point_rate/100.0;
    }
  }
  void setProductDeliveryType(int delivery_type){
    if(delivery_type>=0 && delivery_type < delivery.length){
      prod_delivery_type = delivery_type;
    }else{
      prod_delivery_type=0;
    }
  }
  void setProductStock(int stock){
    if(stock<0){
      stock = 0;
    }else{
      prod_stock=stock;
    }
  }
}
