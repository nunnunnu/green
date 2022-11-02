import java.util.Scanner;

public class SwitchEx {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("      1. 1번 기능");
        System.out.println("      2. 2번 기능");
        System.out.println("      3. 3번 기능");
        System.out.println("      4. 4번 기능");
        System.out.print("선택 : >");
        int sel = s.nextInt();

        // switch(sel){
        //     case 1: 
        //         System.out.println("1번 기능 선택됨");
        //         break;
        //     case 2: 
        //         System.out.println("2번 기능 선택됨");
        //         break;
        //     case 3: 
        //         System.out.println("3번 기능 선택됨");
        //         break;
        //     case 4: 
        //         System.out.println("4번 기능 선택됨");
        //         break;
        //     default:
        //         System.out.println("잘못된 번호 선택입니다.");
        // }
        if(sel ==1 )        System.out.println("1번 기능 선택됨");
        else if(sel ==2 )   System.out.println("2번 기능 선택됨");
        else if(sel ==3 )   System.out.println("3번 기능 선택됨");
        else if(sel ==4 )   System.out.println("4번 기능 선택됨");
        else                System.out.println("잘못된 번호 선택입니다.");

        s.close();
    }
}
