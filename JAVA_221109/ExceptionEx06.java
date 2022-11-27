import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx06 {
  public static void main(String[] args) throws Exception {
    try{
      calc();
    }catch(Exception e){
      System.out.println(e.getMessage());
    } 
  }
  public static void calc() throws Exception { //main에 Exception처리를 강제함.(타입미스매치 등을 썼을땐 오류안떳음)
    Scanner s = new Scanner(System.in);
    System.out.print("입력 : ");
    int n1 = s.nextInt();
    System.out.print("입력 : ");
    int n2 = s.nextInt();
    System.out.print("연산(1.+, 2.-, 3.*, 4./) : ");
    int op = s.nextInt();

    int result=0;
    if(op==1) {
      result=n1+n2;
    }else if(op==2) {
      result=n1-n2;
    }else if(op==3) {
      result=n1*n2;
    }else if(op==4) {
      result=n1/n2;
    }
    System.out.println("결과 : "+result);
  } //n2에 0이들어왔을때 나누기실행 or 문자열입력 두가지의 예외위험있음
}
