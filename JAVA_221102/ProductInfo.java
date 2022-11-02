public class ProductInfo {
  Integer prod_no; //제품번호
  String prod_name; //제품명
  Integer prod_price; //가격
  Integer prod_stock; //재고 
  Double prod_dc_rate; //할인율
  
  public ProductInfo(){}
  public ProductInfo(Integer prod_no, String prod_name, Integer prod_price, Integer prod_stock, Double prod_dc_rate){
    this.prod_no = prod_no;
    this.prod_name = prod_name;
    this.prod_price = prod_price;
    this.prod_stock = prod_stock;
    this.prod_dc_rate = prod_dc_rate;
  }

  void showInfo(){
    System.out.println("제품번호 : "+prod_no);
    System.out.println("제품명 : "+prod_name);
    System.out.println("가격 : "+prod_price);
    System.out.println("재고 : "+prod_stock);
    System.out.println("할인률 : "+(int)(prod_dc_rate*100)+"%");
  }
  int getDiscountedPrice(){
    return (int)(prod_price*(1-prod_dc_rate));
  }

  public static void main(String[] args) {
    
  }
}
