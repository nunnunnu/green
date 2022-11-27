import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx04 {
  public static void main(String[] args) {
    //Error / Exception
    //Error - 에러상황 복구불가
    //Complie time -실행파일 만드는 시간 / Runtime - 프로그램 사용 중  시간
    //Exception - 에러상황 복구가능
    //예외처리 - Exception이 발생했을때 대체코드를 실행함.
    // Scanner s = new Scanner(System.in);
    // try{
    //   System.out.print("최소 : ");
    //   int min = s.nextInt();
    //   System.out.print("최대 : "); //위에서 Exception이 일어나면 실행되지않음
    //   int max = s.nextInt();
    // }catch(InputMismatchException e){
    //   System.out.println("정수만 입력가능합니다.");
    // }
    // // System.out.println("min : "+min+" / max : "+max); //try-catch안에있어서 min, max 사용 불가
    // System.out.println("실행 후 문자열 출력");
    Scanner s = new Scanner(System.in);
    int min=0, max=0;
    String input = ""; //차라리 String으로 받아서 변환하는게 나을수도있음
    input = s.nextLine();
    
    int num = Integer.parseInt(input);
    System.out.println(num);

    try{
      System.out.print("최소 : ");
      min = s.nextInt();
    }catch(InputMismatchException e){
      System.out.println("정수만 입력가능합니다.");
      min=0;
    }finally{
      s.nextLine(); //위에서 에러가나서 처리하지못했을때 처리하지못한 문자열을 max가 먹음
      //성공여부에 상관없이 finally구분이 필요해짐
    }
    try{
      System.out.print("최대 : "); 
      max = s.nextInt();
    }catch(InputMismatchException e){
      System.out.println("정수만 입력가능합니다.");
      max = 255;
    }; 
    System.out.println("min : "+min+" / max : "+max);
    System.out.println("실행 후 문자열 출력");
    s.close();
    
  }
  
}