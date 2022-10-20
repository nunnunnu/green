package Ex4;

import java.util.Scanner;

public class Ex4_18 {
    public static void main(String[] args) {
        int menu = 0;
        int num = 0;

        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("(1) square");
            System.out.println("(2) square root");
            System.out.println("(3) log");

            String tmp = s.nextLine();
            menu = Integer.parseInt(tmp);

            if(menu ==0){
                System.out.println("프로그램을 종료합니다.");
                break;
            }else if(!(1<=menu && menu <=3)){
                System.out.println("메뉴를 잘못선택하셨습니다. (종료는 0)");
                continue;
            }
            System.out.println("선택하신 메뉴는 "+menu+"번입니다.");
        }
    }
    
}
