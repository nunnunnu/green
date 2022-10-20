package Ex4;

import java.util.Scanner;

public class Ex4_6 {
    public static void main(String[] args) {
        System.out.println("현재 월을 입력하세요 >");
        Scanner s = new Scanner(System.in);
        int month = s.nextInt();

        switch(month){
            case 3: case4 : case5 :
            System.out.println("현재의 계절은 봄입니다.");
            break;
            case 6: case 7 : case 8 :
            System.out.println("현재의 계절은 여름입니다.");
            break;
            case 9: case10 : case11 :
            System.out.println("현재의 계절은 가을입니다.");
            break;
            default:
            System.out.println("현재의 계절은 겨울입니다.");
        }
    }
}
