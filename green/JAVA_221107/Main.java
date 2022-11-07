import group1.AccessTest; //패키지가 나눠져있어서 import해야 사용가능

public class Main {
  public static void main(String[] args) throws Exception {
    // StaticTest.a=10; //직접접근 불가 = 인스턴스변수(객체변수)
    StaticTest.b=20; //직접접근 가능 = 클래스변수

    StaticTest obj1 = new StaticTest();
    obj1.a=10;  //인스턴스변수는 객체생성 후 접근 가능
    StaticTest obj2 = new StaticTest();
    obj2.a=20;
    System.out.println(obj1.a);
    System.out.println(obj2.a);//서로 다름

    obj1.b=50;

    System.out.println(obj1.b+", "+obj2.b+","+StaticTest.b); //전부 같음
    
    System.out.println(Integer.MIN_VALUE); //클래스변수
    
    System.out.println(obj1.VALUE+", "+obj2.VALUE+","+StaticTest.VALUE); //전부 같음
    
    StaticTest.StaticMethod();
    // StaticTest.nonStaticMethod(); //불가능
    obj1.nonStaticMethod();
    obj1.StaticMethod();

    System.out.println(AESAlgorithm.Encrypt("1234")); //4g9CwF3G17sk3kn/7DQTeQ== 출력
    System.out.println(AESAlgorithm.Decrypt("4g9CwF3G17sk3kn/7DQTeQ==")); //1234 출력

    AccessTest obj = new AccessTest();
    // obj.a=10; //default - 에러남. 다른패키지라서 사용불가. 같은 패키지 내에서는 사용가능
    // obj.b=20; //private - 에러남. 클래스외부에서 사용 불가능
    // obj.c=30; //protected - 에러남. 다른패키지라서 사용불가. 같은 패키지 내에서는 사용가능
    obj.d=40; //public 공개. 모은 곳에서 사용 가능
    //private와 public을 많이 씀
    // System.out.println(obj.getB()); //public이 빠져서 에러남.
  }
}
