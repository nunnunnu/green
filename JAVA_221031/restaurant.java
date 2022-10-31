public class restaurant {


  final String[] pay = {"만나서 결제, 바로결제","매장, 포장"};
  private int min_amount;
  private int min_time;
  private int max_time;
  private int min_delivery_tips;
  private int max_delivery_tips;
  private int pickup_amount;
  private int pickup_min_time;
  private int pickup_max_time;
  private String address;
  private String img;
  private String name;
  private String open_time;
  private String close_time;
  private String delivery_area;
  private String notice;

  restaurant(){}
  restaurant(String attr[],int min_amount, int min_time, int max_time, 
            int min_delivery_tips, int max_delivery_tips, int pickup_amount, int pickup_min_time, 
            int pickup_max_time,String address)
    {
    this.img = attr[0];
    this.name = attr[1];
    this.open_time = attr[2];
    this.close_time = attr[3];
    this.delivery_area = attr[4];
    this.notice = attr[5];
    setMinAmount(min_amount);
    setMinTime(min_time);
    setMaxTime(max_time);
    setMinDeliveryTips(min_delivery_tips);
    setMaxDeliveryTips(max_delivery_tips);
    setPickUpAmount(pickup_amount);
    setPickUpMinTime(min_time);
    setPickUpMinTime(max_time);
    setPickUpMinTime(pickup_min_time);
    setPickUpMaxTime(pickup_max_time);
    setAddress(address);
  }
  
  void setName(String name){
    this.name = name;
  }
  void setMinAmount(int min_amount){
    if(min_amount<0){
      System.out.println("입력금액이 잘못되었습니다. 양수로 입력해주세요");
    }
    this.min_amount = min_amount;
  }
  void setAddress(String address){
    this.address = address;
  }
  void setMinTime(int min_time){
    if(min_time<0){
      System.out.println("입력시간이 잘못되었습니다. 양수로 입력해주세요");
      return;
    }
    this.min_time = min_time;
  }
  void setMaxTime(int max_time){
    if(max_time<0){
      System.out.println("입력시간이 잘못되었습니다. 양수로 입력해주세요");
      return;
    }
    this.max_time = max_time;
  }
  void setMinDeliveryTips(int min_delivery_tips){
    if(min_delivery_tips<0){
      System.out.println("입력시간이 잘못되었습니다. 양수로 입력해주세요");
      return;
    }
    this.min_delivery_tips = min_delivery_tips;
  }
  void setMaxDeliveryTips(int max_delivery_tips){
    if(max_delivery_tips<0){
      System.out.println("입력시간이 잘못되었습니다. 양수로 입력해주세요");
      return;
    }
    this.max_delivery_tips = max_delivery_tips;
  }
  void setPickUpAmount(int pickup_amount){
    if(pickup_amount<0){
      System.out.println("입력금액이 잘못되었습니다. 양수로 입력해주세요");
      return;
    }
    this.pickup_amount = pickup_amount;
  }
  void setPickUpMinTime(int pickup_min_time){
    if(pickup_min_time<0){
      System.out.println("입력시간이 잘못되었습니다. 양수로 입력해주세요");
      return;
    }
    this.pickup_min_time = pickup_min_time;
  }
  void setPickUpMaxTime(int pickup_max_time){
    if(pickup_max_time<0){
      System.out.println("입력시간이 잘못되었습니다. 양수로 입력해주세요");
      return;
    }
    this.pickup_max_time = pickup_max_time;
  }
  void showInfo(){
    System.out.println("이미지 : "+img);
    System.out.println("상호 : "+name);
    System.out.println("운영시간 : "+open_time+" ~ "+close_time);
    System.out.println("배달가능지역 : "+delivery_area);
    System.out.println("공지 : "+notice);
    System.out.println("===배달주문===");
    System.out.println("최소 주문 금액 : "+min_amount);
    System.out.println("결제방법 : "+pay[0]);
    if(min_time == 0){
      System.out.println("배달시간 : "+max_time+"분 소요 예상");
    }else{
      System.out.println("배달시간 : "+min_time+"~"+max_time+"분 소요 예상");
    }
    if(min_delivery_tips == 0){
      System.out.println("배달팁 : "+max_delivery_tips+"원");
    }else{
      System.out.println("배달팁 : "+min_delivery_tips+"~"+max_delivery_tips+"원");
    }

    System.out.println("===포장/방문주문===");
    if(pickup_amount != 0){
      System.out.println("할인 : "+pickup_amount+"("+min_amount+"원 이상 포장시 할인됩니다.)");
    }
    System.out.println("최소 주문 금액 : 없음");
    System.out.println("이용방법 : "+pay[1]);
    if(pickup_min_time == 0){
      System.out.println("픽업시간 : "+pickup_max_time+"분 소요 예상");
    }else{
      System.out.println("픽업시간 : "+pickup_min_time+"~"+pickup_max_time+"분 소요 예상");
    }
    System.out.println("주소 : "+address);
    System.out.println();
    showMenu();
    System.out.println();
  }

  private String[][] menu = new String[10][2];
  private int index;
  void addmenu(String item_name, String price){
    if(index>=menu.length){
      System.out.println("상품을 등록할 수 없습니다. 관리자에게 문의하세요");
      index=9;
      return;
    }
    if(Integer.parseInt(price)<0){
      System.out.println("입력금액이 잘못되었습니다. 양수로 입력해주세요");
      return;
    }
    menu[index][0]=item_name;
    menu[index][1]= (String)price;
    index++;
  }
  void showMenu(){
    System.out.println("=======메뉴=======");
    for(int i=0;i<=index;i++){
      if(menu[i][0]==null){
        System.out.println("아직 등록된 메뉴가 없습니다.");
        System.out.println("==================");
        continue;
      } 
      System.out.println("상품 : "+menu[i][0]);
      System.out.println("가격 : "+menu[i][1]);
      System.out.println("===================");
    }
  }
  void order(String item_name, int num, int delivery_type){
    for(int i=0;i<=index;i++){
      if(item_name.equals(menu[i][0])){
        int sum = num*Integer.parseInt(menu[i][1]);
        if(sum<min_amount){
          System.out.println("최소주문금액보다 주문금액이 적습니다.");
          return;
        }
        if(sum>=20000){
          System.out.println((sum)+"원 주문하셨습니다");
          System.out.println("주문 메뉴 : "+menu[i][0]);
          System.out.println("주문 수량 : "+num);
          if(delivery_type==0){
            System.out.println("배달비 : "+min_delivery_tips);
            System.out.println("총 결제금액 : "+(sum+min_delivery_tips));
          }else{
            System.out.println("총 결제금액 : "+sum);
          }
        }else{
          System.out.println((sum)+"원 주문하셨습니다");
          System.out.println("주문 메뉴 : "+menu[i][0]);
          System.out.println("주문 수량 : "+num);
          if(delivery_type==0){
            System.out.println("배달비 : "+max_delivery_tips);
            System.out.println("총 결제금액 : "+(sum+max_delivery_tips));
          }else{
            System.out.println("총 결제금액 : "+sum);
          }
        }
        return;
      }
    }
    System.out.println("메뉴를 잘못입력하셨습니다.");
  }
}
