public class ExceptionEx {
  public static void main(String[] args) {
    int a=10;
    int b=0;
    int[] arr={10,20};
    try {
      //예외가 발생할 수도 있는 명령문은 try안에
      System.out.println(a/b);
      System.out.println(arr[3]); //ArrayIndexOutOfBoundException발생(위에코드가 예외가 뜨면 작동되지 않음)
    // } catch (ArithmeticException e) { //괄호 안쪽은, 처리할 예외의 종류를 씀(산술연산 예외) 
    //   //a/b했을때 발생할 수 있는 예외 - ArithmeticException이므로, 여기에서 예외처리됨
    //   System.out.println("0으로 나눌 수 없습니다.");
    }catch(ArrayIndexOutOfBoundsException e){
      System.out.println("배열범위를 넘어섰습니다.");
    }catch(Exception e){
      System.out.println("뭔가 터졌다");
    }
  }
}