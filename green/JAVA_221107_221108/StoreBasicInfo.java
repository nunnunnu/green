import java.util.Map;

public class StoreBasicInfo {
  public String name;
  public Double score;
  public Integer min_order_price;
  public Integer[] delivery_time;
  // public Integer[] delivery_price;
  public Map<String, Integer> delivery_price;

  public StoreBasicInfo(){}
  public StoreBasicInfo(String name, Double score, Integer min_order_price, Integer[] delivery_time, Map<String, Integer> delivery_price){
    this.name = name;
    this.score = score;
    this.min_order_price = min_order_price;
    this.delivery_time = delivery_time;
    this.delivery_price = delivery_price;
    
  }
  @Override
  public String toString(){
    String str="";
    str+="가게이름 : "+name+" / 별점 : "+score+"\n";
    str+="최소 주문 금액 : "+min_order_price+"원\n";
    str+="배달시간 : "+delivery_time[0]+" ~ "+delivery_time[1]+"분\n";
    str+="배달팁 : "+delivery_price.get("min")+" ~ "+delivery_price.get("max")+"원\n";

    return str;
  }

}
