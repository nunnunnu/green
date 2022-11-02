import java.util.List;
import java.util.Scanner;

public class CollectionEx2 {
  public static void main(String[] args) {
    //Wrapper Class타입
    //기본형 타입을 Reference형태로 만들어둔것
    // int a = null; //불가
    Integer b = null; //가능
    System.out.println(b);
    // b = new Integer(10);  //추천하지않아서 취소선 그어짐. 자바에서 비추
    b = 10; //자바 추천방법
    Scanner s = null; //가능. 메모리상에 객체가 만들어지기 전 상태
    s = new Scanner(System.in); //메모리에 Scanner 객체 생성

    // List<int> list = null; //int는 null사용불가 -> 에러
    List<Integer> list = null; //List도 Reference타입.
    String str = null; //Reference타입. null을 넣을수있다면 Reference타입임.
    System.out.println(list);
    System.out.println(str);

    s.close();
  }
}
