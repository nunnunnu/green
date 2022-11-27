public class ExceptionEx2 {
  public static void main(String[] args) /* throws Exception */ { //운영체제로 예외를 던짐 -> 아무 처리하지않은상태와 같음 = 실행불가
    // divide(10, 0); //예외처리안해서 에러
    try {
      divide(10, 0); 
      
    } catch (Exception e) {
      e.printStackTrace(); //어떤 오류인지 출력. ArithmeticException 출력됨
      System.out.println("0으로 나눌 수 없음");
      return;
    }finally{
      System.out.println("예외 발생, return과 상관없이 실행");
      //try-catch구문에 return이 있어도 실행이된다. 그 외에는 finally없이 밑에 적어줘도 크게 다르지않음
    }
  }
  public static void divide(int a, int b) throws Exception{ //밖에서 예외를 처리하라는 구문. (밖에서는 무조건 처리해야함.)
    // try {
      System.out.println(a/b);
    // } catch (Exception e) {
    //   System.out.println("0으로 나눌 수 없음");
    // }
  }
}
