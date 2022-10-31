public class KurlyMain {
  public static void main(String[] args) {
    // KurlyProduct prod1 = new KurlyProduct();
    String[] attr = {
      "product.jpg","루메나","루메나 FAN STAND 3X 무선 써큘레이터","감성 캠핑의 완성","컬리","1개","-","-"
    };
    KurlyProduct prod1 = new KurlyProduct(attr, 39900,0.12,0.05,2,10);
    
    // prod1.printProductInfo(false);
    // System.out.println();
    // prod1.printProductInfo(true);
    // System.out.println();
    
    // prod1.prod_img = "product.jpg";
    // prod1.prod_manufacturer = "루메나";
    // prod1.prod_title = "루메나 FAN STAND 3X 무선 써큘레이터";
    // prod1.prod_sub_title = "감성 캠핑의 완성";
    // prod1.prod_seller = "컬리";
    // prod1.prod_unit = "1개";
    // prod1.prod_quantity = "-";
    // prod1.prod_notice = "-";
    // prod1.prod_price = -50000; //에러, private를 붙여서 직접접근 불가능함. KurlyProduct클래스 안에서만 접근 가능 
    // System.out.println(prod1.prod_price); //에러. 직접접근 불가능

    //setter mothod (속성이 private인 멤버변수의 값을 설정하는 용도)
    // prod1.setProductPrice(39900);
    // prod1.setProductDiscountRate(0.1253);
    // prod1.setProductPointRate(0.05);
    // prod1.setProductDeliveryType(2);
    // prod1.setProductStock(10);

    boolean login = true;
    // login = false;
    System.out.println();
    prod1.printProductInfo(login);

    int order = 8;
    //getter method : 값을 내어보이는 역할을 하는 메소드
    if(prod1.productOrder(order)){
      System.out.println("총 구매 금액 : "+prod1.getDiscountedPrice(login)*order+"원");
    }
    order = 5;
    if(prod1.productOrder(order)){
      System.out.println("총 구매 금액 : "+prod1.getDiscountedPrice(login)*order+"원");
    }
    order = 2;
    if(prod1.productOrder(order)){
      System.out.println("총 구매 금액 : "+prod1.getDiscountedPrice(login)*order+"원");
    }

    prod1.setProductPointRate(15);
    prod1.setProductDiscountRate(20);
    prod1.printProductInfo(login);
  }
} 
