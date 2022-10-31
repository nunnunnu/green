package JAVA_221028;

public class Object_mouseTestEx01 {
  
  public static void main(String[] args) {
    Mouse m1 = new Mouse(); // 클래스의 인스턴스화(메모리에 생성) - 사용가능한상태

    m1.wireless = false;
    m1.wheel = true;
    m1.leftBtn = true;
    m1.rightBtn = true;
    m1.sensor = 0;
    m1.shape = 0;
    System.out.println(m1.wireless);
    System.out.println(m1.wheel);
    System.out.println(m1.leftBtn);
    System.out.println(m1.rightBtn);
    System.out.println(m1.sensor);
    System.out.println(m1.shape);
    Mouse m2 = null;
    // m2.leftBtn = false; //NullPointerException 에러. 객체생성이안된상태에서 사용하려고해서 에러남
    m2.count = 2;
    System.out.println(m2.count); // 객체생성없이 사용가능

    m1.count = 10;
    m2.count = 5;
    // m1, m2의 count값이 둘다 5로 바뀜 - static이라서
    System.out.println(m1.count);
    System.out.println(m2.count);

    Mouse.count = 7;
    System.out.println(m1.count);
    System.out.println(m2.count);
    System.out.println(Mouse.count); // 객체 생성없이 사용가능해서 클래스이름을 바로 적어줌
    // 전부 7로 바뀜

    System.out.println(Integer.MAX_VALUE); // Integer클래스의 MAX_VALUE 클래스변수

    System.out.println(Mouse.VALUE);
    // Mouse.VALUE = 50; //에러, 상수라서 수정불가

    m1.mouseClick(0);
    m1.mouseClick(1);
    m1.mouseClick(2); // Mouse클래스안의 mouseClick메소드 호출
    System.out.println();
    // Mouse.mouseClick(2); // 에러. static이 없어서 인스턴스메소드임 = 객체생성필요 or mouseClick메소드에
    // static붙이기
    m1.printInfo();
    // m2.printInfo(); //null에러 값을 모두 안채워줌
    // Mouse.printInfo(); //사용불가
    System.out.println();
    m2 = new Mouse();
    m2.wireless = true;
    m2.wheel = false;
    m2.leftBtn = false;
    m2.rightBtn = false;
    m2.sensor = 1;
    m2.shape = 1;
    m2.printInfo();
    System.out.println();
    m1.deviceConnectToggle();
    m1.changeMousePos(960, 540);
    m1.rollingMouseWheel(-240);
    m1.showStatus();
    
  }
}
