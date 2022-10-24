package JAVA_221024;

import java.util.Scanner;

public class InfiniteLoop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int dice1,dice2;
        int total=0,user_win=0;
        while(true){
                dice1 = (int)(Math.random()*6)+1;
                dice2 = (int)(Math.random()*6)+1;
                int sum = dice1+dice2;
                int input=0;
                while(true){
                    System.out.print("홀짝을 입력하세요. (홀 : 1, 짝 : 0) >>");
                    input = s.nextInt();
                    if(input==0 || input ==1) {
                        break;
                    }else {
                        System.out.println("입력값이 잘못되었습니다");
                        System.out.println();
                        continue;
                    }
                }
                
                int result= sum%2;
                System.out.println("주사위 눈의 합 : "+sum);

                if(result == input) {
                    System.out.println("사용자 승");
                    user_win++;
                }
                else{
                    System.out.println("컴퓨터 승");
                }
                total++;
                System.out.println();
                System.out.println("다시 하시겠습니까?(0:아니오 / 계속하려면 아무키나 누르세요.");
                input = s.nextInt();
                if(input==0) {
                    System.out.println("프로그램을 종료합니다.");
                    s.close();
                    break;
                }
        }
        System.out.println("총 시도 : "+total+" / 승률 : "+user_win/(double)total*100+"%");
    }
}


