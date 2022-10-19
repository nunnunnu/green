import java.util.Scanner;

public class Ex2_6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("두자리 정수를 하나 입력해주세요. >");
        String input = s.nextLine();
        int num = Integer.parseInt(input);

        System.out.println("입력내용 : "+input);
        System.out.printf("num=%d%n",num);
    }
}
