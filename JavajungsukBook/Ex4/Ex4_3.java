package Ex4;

import java.util.Scanner;

public class Ex4_3 {
    public static void main(String[] args) {
        System.out.println("숫자를 하나 입력하세요. > ");
        Scanner s = new Scanner(System.in);
        int input = s.nextInt();
        if(input==0){
            System.out.println("입력하신 숫자는 0입니다.");
        }else {
            System.out.println("입력하신 숫자는 0이 아닙니다.");
        }
        s.close();
    }
}
