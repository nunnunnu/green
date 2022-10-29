import java.util.Scanner;

public class MarketTest {
    public static void main(String[] args) {
        MarketClass m = new MarketClass();
        
        while(true){
            Scanner s = new Scanner(System.in);
            System.out.print("[메뉴] 1.상품입력, 2.상품정보 수정, 3.등록상품조회, 0.종료 >> ");
            System.out.println();
            int n = s.nextInt();
            if(n==0){
                System.out.println("처음으로 돌아갑니다.");
                s.close();
                return;
            }
            switch(n){
                case 1 :
                    m.input_item();
                    break;
                case 2:
                    m.change_pick();
                    break;
                case 3:
                    m.showInfo();
                    break;
                default : 
                    System.out.println("0~4 중 선택해주세요.");
            }
        }
    }
}
