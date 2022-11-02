import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionEx {
  public static void main(String[] args) {
    Integer[] arr = {10,20,30}; //크기변경 불가
    System.out.println(arr);
    // List<Integer> list = new ArrayList<Integer>(); //제일많이씀
    //<>사이에 무조건 클래스만 들어감
    // List<Integer> list = new LinkedList<Integer>(); //위에꺼 주석하고 했는데도 전부 정상 작동함. 출력값 다른것도없음
    List<Integer> list = new Vector<Integer>(); //마찬가지로 전부 정상 작동함. 출력값 다른것도없음

    list.add(10);
    list.add(20);
    list.add(30);
    
    for(int i=0;i<list.size();i++){ 
      System.out.println(list.get(i));
    }
    System.out.println("-----------------------");
    list.add(40); //배열크기 추가 가능
    for(int i=0;i<list.size();i++){ 
      System.out.println(list.get(i));
    } 
    System.out.println("-----------------------");
    // list.remove(30); //에러남. 30번째 데이터 삭제라는 뜻
    Integer rm = 30;
    list.remove(rm);
    for(int i=0;i<list.size();i++){ 
      System.out.println(list.get(i));
    } 
    System.out.println("-----------------------");
    list.remove((Integer)20); //오 된다
    for(int i=0;i<list.size();i++){ 
      System.out.println(list.get(i));
    } 
    System.out.println("-----------------------");
    list.remove(0); //첫번째 제거
    for(int i=0;i<list.size();i++){ 
      System.out.println(list.get(i));
    } 
    Integer target=30;
    //현재 list에 Integer값 30이 있는가?
    System.out.println(list.contains(target)); //false출력.
    System.out.println(list.contains((Integer)40)); //true출력
    //아이디 중복검사할때 유용함
    
    System.out.println("-----------------------");
    list.add(10);
    list.add(20);
    list.add(30);
    System.out.println(list.size());
    list.removeAll(list); //전체삭제
    System.out.println(list.size());
    list.add(10);
    list.add(20);
    list.add(40);
    System.out.println("-----------------------");
    List<Integer> list2 = new ArrayList<Integer>();
    list2.add(10);
    list2.add(40);
    list2.add(50);
    System.out.println(list2.size());
    list.removeAll(list2);
    System.out.println(list2.size()); //삭제안됨
    System.out.println(list.size()); //1출력. list와 list2에서 겹치는값만 삭제(차집합)
    // System.out.println(Arrays.toString(list));  //안되는구만
    System.out.println(list2.toString()); //되는구만
    List<Integer> list3 = new LinkedList<Integer>();
    System.out.println(list3); //[] 출력됨
    
    

  }
}
