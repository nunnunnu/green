public class StoreDetailInfo {
  String introduce;
  String origin_name;
  String open_time;
  String close_time;
  String[] close_day;
  String phone;
  String delivery_area;
  String notice;
  // int[][] delivery_boundary;
  DeliveryBoundary[] delivery_boundaries;
  
  public StoreDetailInfo(
    String introduce, String origin_name, String open_time, String close_time, String[] close_day, String phone, 
    String delivery_area, String notice, DeliveryBoundary[] delivery_boundaries
  ){
    this.introduce = introduce;
    this.origin_name = origin_name;
    this.open_time = open_time;
    this.close_time = close_time;
    this.close_day=close_day;
    this.phone = phone;
    this.delivery_area = delivery_area;
    this.notice = notice;
    this.delivery_boundaries =delivery_boundaries;
  }

  public String toString(){
    String str="";
    str += "가게소개 \n";
    str +=introduce+"\n";
    str = "영업정보\n";
    str = "상호명 : "+origin_name+"\n";
    str = "영업시간 : "+open_time+" ~ "+close_time+"\n";
    str = "휴무일 : ";
    if(close_day == null){
      str+="연중무후";
    }else{
      str+=close_day+"/n";
    }
    str = "전화번호 : "+phone+"\n";
    str = "배달지역 : "+delivery_area+"\n";
    str = "배달팁\n";
    if(delivery_area == null){
      str+="무료";
    }else{
      for(int i=0;i<delivery_boundaries.length;i++){
        str+=delivery_boundaries[i].boundary+"원 이상 : ";
        str+=delivery_boundaries[i].price+"원\n";
      }
    }

    return str;
  }

}
