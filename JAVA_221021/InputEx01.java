import java.util.Scanner;

public class InputEx01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("숫자를 입력하세요 : > ");
        int n=0;
        try{
            n=s.nextInt();
        }catch(Exception e){
            System.out.println("잘못된 입력값입니다.");
            s.close();
            // return;
        }
        System.out.println(n);
        
        s.close();
    }
}
