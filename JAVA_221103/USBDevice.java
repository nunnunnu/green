public class USBDevice {
    public static final USBMouse wireless = null;
    String version;
    String type; //A B(프린터에꼽는거) C
    public USBDevice(){}
    public USBDevice(String version, String type){
      this.version = version;
      this.type = type;
    }
    void input(){
      System.out.println("USB장치 -> 컴퓨터 입력");
    }
    void output(){
      System.out.println("USB장치 <- 컴퓨터 출력");

    }
}
