public class StaticTest {
  int a; //인스턴스변수 - 생성된 객체 수 만큼 존재
  static int b; //클래스변수 - 단 1개만 생성 = 공유변수
  static final int VALUE = 100; //클래스 상수 - 단 1개만 생성 = 공유상수

  void nonStaticMethod(){ //클래스매소드
    System.out.println("non static Method");
    StaticMethod();
    //인스턴스메소드에서는 같은 클래스 내의 static메소드와 인스턴스 메소드 모두 사용 가능
  }
  static void StaticMethod(){ //인스턴스메소드(객체메소드)
    System.out.println("static Method");
    // nonStaticMethod(); //불가능. 
    //Static메소드에서는 같은 클래스 내의 인스턴스 메소드 사용 불가



  }
}
