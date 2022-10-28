package JAVA_221028;

public class Mouse {

  //클래스 상수
  final static int VALUE = 100;

  //클래스변수
  //static - 정적메모리(프로그램 실행시에 생성됨)
  //모든 인스턴스가 공유하는 변수
  static int count = 0;

  //인스턴스변수(Mouse클래스의 멤버변수)
  //인스턴스화가 되어야 사용가능(메모리에 생성되어야 사용가능)
  boolean wireless;
  boolean wheel;
  boolean leftBtn;
  boolean rightBtn;
  int sensor; //0.광 / 1.레이저 / 2.트랙패드 / 3.트랙볼
  int shape; //0.일반 / 1.인체공학 / 2.게이밍 / 3.패드

  boolean connect;
  int posX;
  int posY;
  int wheelDelta; //휠을 아래로돌렸는지 위로돌렸는지, 속도는 어느정도인지

  void deviceConnectToggle() {
    connect = !connect;
  }

  void changeMousePos(int x, int y) {
    posX = x;
    posY = y;
  }

  void rollingMouseWheel(int delta) {
    wheelDelta = delta;
  }

  void showStatus() {
    System.out.println("장치 연결 상태 : " + (connect ? "연결됨" : "연결안됨"));
    if (connect) {
      System.out.println("마우스 위치 : (" + posX + ", " + posY + ")");
      System.out.println("휠 변화량 : "+wheelDelta);
    }
  }

  void printInfo() {
    System.out.println("마우스 연결 방식 : " + (wireless ? "무선" : "유선"));
    System.out.println("마우스 휠 유무 : "+(wheel?"있음":"없음"));
    System.out.println("마우스 버튼(왼쪽) : "+(leftBtn?"있음":"없음"));
    System.out.println("마우스 버튼(오른쪽) : " + (rightBtn ? "있음" : "없음"));
    if(sensor==0) System.out.println("감응방식 : 광");
    else if(sensor==1) System.out.println("감응방식 : 레이저");
    else if(sensor==2) System.out.println("감응방식 : 트랙패드");
    else if(sensor==3) System.out.println("감응방식 : 트랙볼");
    
    if(sensor==0) System.out.println("마우스 형태 : 일반");
    else if(sensor==1) System.out.println("마우스 형태 : 인체공학");
    else if(sensor==2) System.out.println("마우스 형태 : 게이밍");
    else if(sensor==3) System.out.println("마우스 형태 : 패드");
  }

  void mouseClick(int btn) {
    if (btn == 0) {
      System.out.println("왼쪽 클릭");
    }
    else if (btn == 1) {
      System.out.println("오른쪽 클릭");
    }
    else if (btn == 2) {
      System.out.println("휠버튼 클릭");
    }
  }
  public static void main(String[] args) {
  }
}
