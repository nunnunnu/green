import java.util.ArrayList;
import java.util.List;

public class SeatEx {
  public static void main(String[] args) {
    List<String> stuList = new ArrayList<String>();

    stuList.add("이호진");
    stuList.add("주봉진");
    stuList.add("정아미");
    stuList.add("김호혁");
    stuList.add("이민석");
    stuList.add("유지은");
    stuList.add("김성민");
    stuList.add("차대군");
    stuList.add("유상연");
    stuList.add("권영장");
    stuList.add("신래은");
    stuList.add("박정은");
    stuList.add("류승지");
    stuList.add("이영은");
    stuList.add("이찬희");
    stuList.add("이태훈");
    stuList.add("박진희");
    stuList.add("박진혁");
    stuList.add("정인원");
    stuList.add("문주영");
    stuList.add("남현우");
    stuList.add("이영준");
    stuList.add("김동현");
    stuList.add("우민경");
    stuList.add("우현주");
    stuList.add("차경준");
    stuList.add("김한수");
    stuList.add("이도영");
    
    int num = 1;
    while(stuList.size()>0){
        int n = (int)(Math.random()*stuList.size());
        // System.out.println(stuList.get(n)); //이렇게하면 무한반복임
        String name = stuList.remove(n);
        System.out.println(num+". "+name);
        num++;
      }
      // while(num<28){
        //   int n = (int)(Math.random()*stuList.size());
    //   System.out.println(num+". "+stuList.get(n));  //이렇게하면 중복값나옴
    //   num++;
    // }
  }
}
