import java.util.Calendar;
import java.util.Scanner;

public class ConditionalCheck01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // System.out.print("점수를 입력하세요 > ");
        // double score = s.nextDouble();
        // final int PASS_SCORE = 60;
        
        // if(score>100 || score<0){
        //     System.out.println("잘못된 점수입니다.");
        // }else if(score >=PASS_SCORE) {
        //     //score의 값이 PASS_SCORE이상일때 실행
        //     System.out.println("합격입니다.");
        //     if(score>=90){
        //         System.out.print("A"+(score>=95?"+":"0"));
        //         // if(score>=95){
        //         //  System.out.println("+");
        //         // }else if(score<95){
        //         //     System.out.println("0");
        //         // }
        //     }else if(score>=80) {
        //         System.out.print("B");
        //     }else if(score>=70) {
        //         System.out.print("c");
        //     }else if(score>=60) {
        //         System.out.print("d");
        //     }
        // }else{
        //     System.out.println("불합격입니다");
        //     System.out.println("f");
        //  }
        // String grade = "";
        // if(score>100 || score<0)        grade ="잘못된 입력값입니다";
        // else if(score >=90)             grade ="A";
        // else if(score >=80)             grade ="B";
        // else if(score >=70)             grade ="C";
        // else if(score >=60)             grade ="D";
        // else if(score >=0)              grade ="F";
        // System.out.println(grade);

        //생년월일 입력하기, 현재 연도와 계산 후 나이를 구함
        //어린이, 청소년, 성인을 판별하여 표시하는 프로그램을 작성하세요
        //어린이 0~13세, 청소년 14~17세, 성인 18세 이상
        //입력한 생년이 현재 연도보다 큰 경우 오류로 처리한다.
        //계산한 연령이 120세를 넘으면 오류로 처리한다
        
        //추가사항) 연령대를 표시한다. 생년을 2000을 입력했을 경우, "20대입니다" 표시

        System.out.println("태어난년도를 입력하세요 > ");
        int birthyear = s.nextInt();
        Calendar c = Calendar.getInstance();
        final int CURRENT_YEAR = c.get(Calendar.YEAR);
        int age = CURRENT_YEAR-birthyear;
        
        s.close();

        if(birthyear>CURRENT_YEAR) {
            System.out.println("입력값이 잘못되었습니다. 출생년도는 현재년도보다 높을 수 없습니다.");
            // return;
        }
        else if(age>=120) {
            System.out.println("출생년도 입력 오류입니다.");
            // return;
        }
        else if(age<=13) System.out.println("어린이입니다");
        else if(age<=17) System.out.println("청소년입니다");
        else System.out.println("성인입니다.");

        if(!(birthyear>CURRENT_YEAR || age>=120))
        System.out.println(age/10*10+"대 입니다.");
        
    }
}