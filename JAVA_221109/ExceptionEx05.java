import java.util.Scanner;

public class ExceptionEx05 {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("최소 : ");
    int min = s.nextInt();
    System.out.print("최대 : "); 
    int max = s.nextInt();
    System.out.println("min : "+min+" / max : "+max);
    System.out.println("실행 후 문자열 출력");
    s.close();
    
  }
}
