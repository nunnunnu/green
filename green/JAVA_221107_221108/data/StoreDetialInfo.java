package data;

import java.util.Map;

public class StoreDetialInfo {
  public String introduce;
  public String notice;
  public Map<String, String> openClose;
  public String offDay;
  public String phone;
  public String delivery_area;

  public StoreDetialInfo(){}
  public StoreDetialInfo(String introduce, String notice, Map<String, String> openClose, 
    String offDay, String phone, String delivery_area){
      this.introduce = introduce;
      this.notice = notice;
      this.openClose = openClose;
      this.offDay = offDay;
      this.phone = phone;
      this.delivery_area = delivery_area;
  }
  
  @Override
  public String toString(){
    String str = "";
    str += "가게소개\n";
    str += introduce+"\n";
    str += "공지사항\n";
    str += notice+"\n";
    str += "영업시간 : "+openClose.get("open")+" ~ "+openClose.get("close")+"\n"; 
    str += "휴무일 : "+offDay+"\n";
    str += "전화번호 : "+phone +"\n";
    str += "배달가능지역 : "+delivery_area+"\n";
    return str;
  }
  
}
