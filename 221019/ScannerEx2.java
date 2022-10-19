import java.util.Scanner;

public class ScannerEx2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("정수값을 입력해주세요 > ");
        int input_value=s.nextInt();
        final int MAX_VALUE = 255;
        System.out.println("입력 값이 최대 값을 초과하는가? "+(input_value>MAX_VALUE));
        System.out.println("입력 값이 최대 값을 이하인가? "+(input_value<=MAX_VALUE));
        s.close();
    }
}
