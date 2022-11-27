public class USBMouse extends USBDevice {
  String sensor;
  String wireless; //유무선

  public USBMouse(){}
  public USBMouse(String type, String version, String sensor, String wireless){
    super(version, type); //상위(super) 클래스의 생성자 호출
    this.sensor = sensor;
    this.wireless = wireless;
  }
  void input(){
    super.input(); //오버라이딩한 상위 클래스의 메소드를 먼저 실행
    System.out.println("마우스 버튼 입력");
  }
  void output(){

  }
  void mousewheel(){
    System.out.println("마우스 휠 돌리기");
  }
  public String toString(){
    return "마우스 정보 출력";
  }

}
