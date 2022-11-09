public class MyException extends Exception {
  @Override
  public String getMessage() {
    return "내가 만든 예외클래스";
  }
}
