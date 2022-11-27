import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class USBMain {
  public static void main(String[] args) {
    USBDevice d1 = new USBMouse("A","2.0","laser","no");
    d1.input();
    d1.output(); //오버라이딩 본문안에 구현을 안해놔서 상위클래스의 output실행
    // d1.mousewheel(); //에러. USBDevice에는 mousewheel없음
    // d1.sensor;//안됨. USBDevice에서는 하위클래스의 메소드 유무를 판단할수없음
    ((USBMouse)d1).mousewheel();
    ((USBMouse)d1).wireless="asd";
    
    List<String> list = new ArrayList<String>(); //List가 부모, ArrayList가 자식. 상속과 다형성. 
    //LinkedList로 바꿔도 작동했던게 list는 부모클래스인 List의 변수라서
    list.add(null);
    
    Object obj = new String("aaa");
    Object obj1 = new Date();
    Object obj2 = new ArrayList<String>();
    Object obj3 = new USBMouse();

    // obj.add("a"); //불가능
    // obj3.input(); //불가능
    System.out.println(obj.toString()); //Object로 유일하게 가능한 것
    System.out.println();
    
    System.out.println(obj); //aaa
    System.out.println(obj1); //Thu Nov 03 16:50:44 KST 2022
    System.out.println(obj2); //[]
    System.out.println(obj3); //USBMouse@1b28cdfa -> 오버라이딩 후 : 마우스 정보 출력 출력됨
    //오버라이딩 된 toString이 있다면 해당 toString형식에 맞춰서 출력됨
    
  }
}
