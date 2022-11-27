public class SubClass extends SuperClass { // SuperClass에 final을 붙여서 상속금지임(주석처리함)
  int b;

  void printInfo(){ //SuperClass 메소드에 final붙어서 에러남(주석처리함)
    System.out.println("Subclass");
  }

}
