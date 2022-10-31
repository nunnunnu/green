import java.util.InputMismatchException;
import java.util.Scanner;

public class ConditionCheck02 {
    public static void main(String[] args) throws InputMismatchException{
        System.out.print("1.추가 2.수정 3.조회 4.삭제 : > ");
        Scanner s = new Scanner(System.in);
        int n=s.nextInt();

        if(n==1) System.out.println("추가기능 실행");
        else if(n==2) System.out.println("수정기능 실행");
        else if(n==3) System.out.println("조회기능 실행");
        else if(n==4) System.out.println("삭제기능 실행");
        else System.out.println("1~4중 하나를 선택하세요");

        switch(n){
            case 1:
                System.out.println("추가 기능 실행");
                break;
            case 2:
                System.out.println("수정 기능 실행");
                break;
            case 3:
                System.out.println("조회 기능 실행");
                break;
            case 4:
                System.out.println("삭제 기능 실행");
                break;
            default:
                System.out.println("1~4중 하나를 선택하세요");
        }
        s.close();
    }
}
