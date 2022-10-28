import java.util.Scanner;

public class ConditionCheck222222 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("선택(1~4) : > ");
        int input = s.nextInt();

        if(input == 1 )      System.out.println("1번을 선택하셨습니다.");
        else if(input == 2 ) System.out.println("2번을 선택하셨습니다.");
        else if(input == 3 ) System.out.println("3번을 선택하셨습니다.");
        else if(input == 4 ) System.out.println("4번을 선택하셨습니다.");
        else                 System.out.println("잘못된 번호 선택입니다.");
        
        switch(input){
            case   1: System.out.println("1번 기능"); break;
            case   2: System.out.println("2번 기능"); break;
            case   3: System.out.println("3번 기능"); break;
            case   4: System.out.println("4번 기능"); break;
            default : System.out.println("잘못된 번호 선택입니다.");
        }
        s.close();
    }
}
