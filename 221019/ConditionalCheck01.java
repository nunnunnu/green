import java.util.Scanner;

public class ConditionalCheck01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("점수를 입력하세요 > ");
        double score = s.nextDouble();
        final int PASS_SCORE = 60;
        
        if(score>100){
            System.out.println("입력값이 잘못되었습니다.");
        }else if(score >=PASS_SCORE) {
            //score의 값이 PASS_SCORE이상일때 실행
            System.out.println("합격입니다.");
            if(score<=100 && score>=90){
                System.out.print("A"+(score>=95?"+":"0"));
                // if(score>=95){
                //  System.out.println("+");
                // }else if(score<95){
                //     System.out.println("0");
                // }
            }else if(score>=80) {
                System.out.print("B");
            }else if(score>=70) {
                System.out.print("c");
            }else if(score>=60) {
                System.out.print("d");
            }
        }else{
            System.out.println("불합격입니다");
         }
        s.close();
    }
}