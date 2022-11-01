public class StoreInfo {
  StoreBasicInfo store_basic;
  StoreDetailInfo store_detail;
  StoreBusinessInfo store_business;
  public String toString(){
    String str ="";
    str+=store_basic.toString();
    str+=store_detail.toString();
    str+=store_business.toString();
    return str;
  }

}
