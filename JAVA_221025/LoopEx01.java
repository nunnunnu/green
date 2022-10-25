package JAVA_221025;

import java.util.Scanner;

public class LoopEx01 {
    public static void main(String[] args) {
        //3번 Hello World를 화면에 표시
        for(int i=0;i<3;i++){
            System.out.println("Hello World");
        }

        String str = "Hello World! java";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'a'){
                System.out.println("'a' detected!");
                break;
            }
            System.out.println(i+" : "+str.charAt(i));
        }
        for(int i=1;i<=100;i++){
            if(i%2==1) continue;
            System.out.printf("%5d",i);
            if(i%10==0) System.out.println();
        }

        Scanner s = new Scanner(System.in);
        int sum = 0, count=0;
        // while(true){
        //     System.out.print("입력 (0 to quit) : > ");
        //     int input = s.nextInt();
        //     if(input == 0){
        //         break;
        //     }
        //     sum+=input;
        //     count++;
        // }
        // System.out.println("합계 : "+sum+" / 평균 : "+sum/(double)count);
        
        // int input = 0;
        // do{
        //     System.out.print("입력 (0 to quit) : > ");
        //     input = s.nextInt();
        //     if(input == 0){
        //         break;
        //     }
        //     sum+=input;
        //     count++;
        // }while(input !=0);
        int input = -1;
        while(input!=0){
            System.out.print("입력 (0 to quit) : > ");
            input = s.nextInt();
            if(input == 0){
                break;
            }
            sum+=input;
            count++;
        }
        System.out.println("합계 : "+sum+" / 평균 : "+sum/(double)count);
        s.close();
    }
}
