import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Hello를 입력하세요. : >");
        String input = s.nextLine();
        if(input.equalsIgnoreCase("Hello")) System.out.println("안녕하세요.");
        else System.out.println("안녕히가세요.");

        //equalsIgnoreCase : 대소문자 무시비교

        s.close();
    }
}
