public class ExceptionEx07 {
  public static final int MAX_VAlUE = 255;
  public static void main(String[] args) throws Exception{
    // try{
      myMethod(0);
      myMethod(1);
      myMethod(2);
      myMethod(10);
      myMethod(1000);
    // }catch(Exception e){
    //   System.out.println(e.getMessage());
    // }
  }
  public static void myMethod(int n) throws Exception {
    if(n>MAX_VAlUE){
      //예외 객체를 만들어서 throw
      // throw new Exception("최대값을 초과합니다. 최댓값 : "+MAX_VAlUE);
      throw new MyException();
    }
      System.out.println("n : "+n);
  }
}
