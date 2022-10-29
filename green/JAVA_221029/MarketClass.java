import java.util.Scanner;

public class MarketClass{
    final int MAX_VALUE=2;
    String name;
    String msg;
    int price;
    int sale;
    int discount;
    String shipping;
    String pack; //포장타입

    void input_item(){
        System.out.println("==상품 정보를 입력합니다.==");
        String input;
        int input2;
        Scanner s = new Scanner(System.in);
        System.out.print("상품이름을 입력하세요 : >");
        input = s.nextLine();
        this.name = input;
        System.out.print("상품메세지를 입력하세요 : >");
        input = s.nextLine();
        this.msg = input;
        System.out.print("상품가격을 입력하세요 : >");
        input2 = s.nextInt();
        this.price = input2;
        System.out.print("할인률을 입력하세요 : >");
        input2 = s.nextInt();
        this.sale = input2;
        this.discount= (int)(this.price*(1-(sale/100.0)));
        this.sale = input2;
        System.out.print("배송타입을 입력하세요 : >");
        s.nextLine();
        input = s.nextLine();
        this.shipping = input;
        System.out.print("포장타입을 입력하세요 : >");
        input = s.nextLine();
        this.pack = input;
    }
    void showInfo(){
        if(name==null){
            System.out.println("등록된 상품정보가 없습니다.");
            return;
        }
        System.out.println("등록된 상품정보를 조회합니다.");
        System.out.println("===상품정보===");
        System.out.println("상품 이름 : "+name);
        System.out.println("상품 메세지 : "+msg);
        System.out.println("상품 가격 : "+price);
        System.out.println("할인률  : "+sale+"%");
        System.out.println("할인혜택이 적용된 최종가격 : "+discount);
        System.out.println("배송형태 : "+shipping);
        System.out.println("포장타입 : "+pack);
    }
    void change_name(){
        System.out.println("상품 이름을 변경합니다. 새로운 상품이름을 등록해주세요");
        Scanner s = new Scanner(System.in);
        name = s.nextLine();
        // this.name = name;
    }
    void change_msg(){
        System.out.println("상품 메세지를 변경합니다. 새로운 상품 메세지를 등록해주세요");
        Scanner s = new Scanner(System.in);
        msg = s.nextLine();
    }
    void change_price(){
        System.out.println("상품 가격을 변경합니다. 새로운 상품 가격을 등록해주세요");
        Scanner s = new Scanner(System.in);
        price = s.nextInt();
        this.discount = (int)(price*(1-(sale/100.0)));
    }
    void change_sale(){
        System.out.println("할인률을 변경합니다. 새로운 할인률을 등록해주세요");
        Scanner s = new Scanner(System.in);
        sale = s.nextInt();
        this.discount = (int)(this.price*(1-(sale/100.0)));
    }
    void change_shipping(){
        System.out.println("배송정보를 변경합니다. 새로운 배송정보를 등록해주세요");
        Scanner s = new Scanner(System.in);
        shipping = s.nextLine();
    }
    void change_pack(){
        System.out.println("포장형태를 변경합니다. 새로운 포장형태를 등록해주세요");
        Scanner s = new Scanner(System.in);
        pack = s.nextLine();
    }
    void change_pick(){
        if(name==null){
            System.out.println("등록된 상품정보가 없습니다.");
            return;
        }
        System.out.println("수정할 카테고리를 입력하세요.");
        System.out.print("1.상품 이름, 2.상품메세지, 3.상품가격, 4.할인률, 5.배송형태, 6.포장타입, 0.종료    >>>    ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        if(n==1){
            change_name();
        }
        else if(n==2){
            change_msg();
        }
        else if(n==3){
            change_price();
        }
        else if(n==4){
            change_sale();
        }
        else if(n==5){
            change_shipping();
        }
        else if(n==6){
            change_pack();
        }
        else if(n==0){
            System.out.println("프로그램을 종료합니다.");
            return;
        }else{
            System.out.println("입력번호가 잘못되었습니다. 처음부터 다시 시도해주세요.");
        }
    }
    public static void main(String[] args) {
        
    }
}