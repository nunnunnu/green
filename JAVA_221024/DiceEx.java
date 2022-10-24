package JAVA_221024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceEx {
    public static void main(String[] args) throws IOException {
        int dice1 = (int)(Math.random()*6)+1;
        int dice2 = (int)(Math.random()*6)+1;
        
        System.out.println("주사위의 눈금은 "+dice1+"입니다.");
        System.out.println();
        System.out.println("=====if문 사용=====");
        if(dice1==1) System.out.println("주사위의 눈금은 1입니다.");
        else if(dice1==2) System.out.println("주사위의 눈금은 2입니다.");
        else if(dice1==3) System.out.println("주사위의 눈금은 3입니다.");
        else if(dice1==4) System.out.println("주사위의 눈금은 4입니다.");
        else if(dice1==5) System.out.println("주사위의 눈금은 5입니다.");
        else System.out.println("주사위의 눈금은 6입니다.");
        System.out.println();
        System.out.println("=====switch문 사용=====");
        switch(dice1){
            case 1: 
                System.out.println("주사위의 눈금은 1입니다.");
                break;
            case 2: 
                System.out.println("주사위의 눈금은 2입니다.");
                break;
            case 3: 
                System.out.println("주사위의 눈금은 3입니다.");
                break;
            case 4: 
                System.out.println("주사위의 눈금은 4입니다.");
                break;
            case 5: 
                System.out.println("주사위의 눈금은 5입니다.");
                break;
                default : 
                System.out.println("주사위의 눈금은 6입니다.");
            }

            int sum = dice1+dice2;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("홀짝을 입력하세요. (홀 : 1, 짝 : 0) >>");
            int input=0;

            while(true){
                input = Integer.parseInt(br.readLine());
                if(input==0 || input ==1) {
                    break;
                }else {
                    System.out.println("입력값이 잘못되었습니다");
                    continue;
                }
            }
            
            int result= sum%2;
            System.out.println("주사위 눈의 합 : "+sum);
            System.out.println("=====if문 사용=====");
            if(result == input) System.out.println("사용자 승");
            else System.out.println("컴퓨터 승");
            System.out.println();
            
            System.out.println("=====switch문 사용=====");
            switch(result){
                case 1:
                    switch(input){
                        case 1:
                            System.out.println("사용자 승");
                            break;
                        default:
                            System.out.println("컴퓨터 승");
                    }
                    break;
                default : 
                    switch(input){ 
                        case 0 : 
                            System.out.println("사용자 승");
                            break;
                        default : 
                            System.out.println("컴퓨터 승");
                    }
            }
            br.close();
    }
}
