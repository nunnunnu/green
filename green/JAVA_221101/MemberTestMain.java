import java.util.LinkedList;
import java.util.List;

public class MemberTestMain {
  public static void main(String[] args) {
    List<MemberInfo> mList = new LinkedList<MemberInfo>();
    for(int i=0;i<10;i++){
      mList.add(new MemberInfo("user0"+i,"123456","사용자"+i));
    }
    System.out.println(mList);
    System.out.println(mList.get(5));
    MemberInfo m= mList.get(5);
    System.out.println(m);
    m.setId("iiiiiiiiiiiiii");
    System.out.println(m);
    System.out.println(mList.get(5)); //같은 메모리주소라서 둘다 바뀜. 앞데이터를 삭제하면 5번을 지우려했는데 4번이 지워질수도
    mList.get(5).setId("vvvvvvvvvvvvvvvvvv");
    System.out.println(m);
    System.out.println(mList.get(5));
    
  }
}
