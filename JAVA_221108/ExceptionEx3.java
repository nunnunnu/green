import java.util.Scanner;

public class ExceptionEx3 {
  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    while(true){
      int n = s.nextInt();
      if(n==0){
        s.close();
        throw new MyException();
        //0이 입력됐을때 예외를 발생시킴. 거의안씀
      }
    }
  }
}
