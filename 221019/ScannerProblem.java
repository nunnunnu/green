import java.util.Scanner;

public class ScannerProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("숫자 입력 > ");
        int number =s.nextInt();
        System.out.print("문자열 입력 > ");
        // String str =s.nextLine(); 
        //문자열을 입력받기 전에 종료해버림.
        //number값을 받은 후 입력한 enter를 str값으로 인식한것임
        s.nextLine();
        String str =s.nextLine(); 
        //number뒤에 온 enter를 따로 처리해줌
        s.close();
    }
}
