public class StoreBasicInfo {
  String thumbnail;
  String name;
  Double score;
  Integer min_order_price;
  String[] payments;
  Integer min_delivery_time;
  Integer max_delivery_time;
  Integer min_delivery_price;
  Integer max_delivery_price;

  public StoreBasicInfo(  
    String thumbnail, String name, double score, int min_order_price, String[] payments, 
    int min_delivery_time, int max_delivery_time, int min_delivery_price, int max_delivery_price
  ){
    this.thumbnail=thumbnail;
    setName(name);
    setScore(score);
    setMinOrderPrice(min_order_price);
    setPayments(payments);
    setDeliveryTime(min_delivery_time, max_delivery_time);
    setDeliveryPrice(min_delivery_price, max_delivery_price);
  }

  void setName(String name){
    if(name.length() ==0){
      System.out.println("가게 이름을 올바르게 설정하세요.");
    }else{
      this.name = name;
    }
  }
  void setScore(double score){
    if(score<0 || score>5){
      System.out.println("별점을 올바르게 입력하세요");
    }else{
      this.score = score;
    }
  }
  void setMinOrderPrice(int min_order_price){
    if(min_order_price ==0){
      System.out.println("올바른 최소주문 금액을 입력하세요.");
    }else{
      this.min_order_price = min_order_price;
    }
  }
  void setPayments(String[] payments){
    if(payments==null || payments.length ==0){
      System.out.println("올바른 결제방법을 입력하세요.");
    }else{
      this.payments = payments;
    }
  }
  void setDeliveryTime(int min, int max){
    if(min<0){
      System.out.println("올바른 배달시간을 입력하세요.");
    }else{
      this.min_delivery_time = min;
      this.max_delivery_time = max;
    }
  }
  void setDeliveryPrice(int min, int max){
    if(min<0){
      System.out.println("올바른 배달팁을 입력하세요.");
    }else{
      this.min_delivery_price = min;
      this.max_delivery_price = max;
    }
  }
  public String toString(){
    String str ="";
    str += "=======================기존정보=======================\n";
    str += name+"\n";
    int nScore = (int)(Math.round(score));
    str += "별점 : ";
    for(int i=0;i<5;i++){
      if(i < nScore){
        str+="★ ";
      }else{
        str+="☆";
      }
    }
    str+=" "+score+"\n";
    str +="최소주문금액 : "+min_order_price+"원\n";
    str += "결제 방법 : ";
    for(int i=0;i<payments.length;i++){
      str += payments[i]+ " ";
    }
    str+="배달시간 : "+min_delivery_time+" ~ "+max_delivery_time+"분\n";
    str+="배달 팁 : "+min_delivery_price + " ~ "+max_delivery_price+"원\n";

    return str;
  }
}
