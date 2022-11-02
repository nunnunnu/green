import java.util.ArrayList;
import java.util.List;

public class CollectionEx3 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list); //[10, 20, 30]으로 출력됨. toString써줄필요없는듯? 아 이거 int라서 주소값이 없나
    
    List<String> strlist = new ArrayList<String>();

    strlist.add("abcde"); //"abcde"객체의 주소를 ArrayList객체의 첫번째 배열에 저장, ArrayList객체의 주소를 strlist에 저장
    strlist.add("fghij"); //"abcde"객체의 주소를 ArrayList객체의 두번째 배열에 저장, ArrayList객체의 주소를 strlist에 저장
    strlist.add("klmno"); //"abcde"객체의 주소를 ArrayList객체의 세번째 배열에 저장, ArrayList객체의 주소를 strlist에 저장
    strlist.add("pqrst");
    strlist.add("uvwsyz");
    System.out.println(strlist); 

    

  }
}
