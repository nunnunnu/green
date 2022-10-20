import java.util.Scanner;

public class ConditionCheck {
    public static void main(String[] args) {
        final int MAX_VALUE = 255;
        Scanner s = new Scanner(System.in);
        System.out.println("값을 입력하세요(최대 0 ~ 255) : > ");
        int input =s.nextInt();

        // if(input > MAX_VALUE) System.out.println("입력값은 최대 값을 넘습니다.");
        // // if(input <=MAX_VALUE) System.out.println("입력한 값 : "+input);
        // else if(input<0) System.out.println("입력값은 최소 값 미만입니다.");
        // else System.out.println("입력한 값 : "+input);
        
        if(input >MAX_VALUE || input < 0 ) System.out.println("입력값이 범위를 넘어섭니다. (범위 0 ~ 255)");
        else System.out.println("입력한 값 : "+input); 

        s.close();
    }
}