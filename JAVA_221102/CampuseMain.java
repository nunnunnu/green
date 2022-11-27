import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CampuseMain {
  public static void main(String[] args) {
    List<Campuse> camList = new ArrayList<Campuse>();

    camList.add(new Campuse(20220001, "남형남", 1, "전산공학"));
    camList.add(new Campuse(20220002, "조현숙", 3, "정보공학"));
    camList.add(new Campuse(20220003, "남희준", 2, "물리학"));
    camList.add(new Campuse(20220004, "윤상원", 2, "국어교육과"));
    camList.add(new Campuse(20220005, "문용태", 3, "전산공학"));
    camList.add(new Campuse(20220006, "사공채은", 4, "정보공학"));
    camList.add(new Campuse(20220007, "정문옥", 1, "경영학"));
    camList.add(new Campuse(20220008, "황상훈", 2, "국어국문학"));
    camList.add(new Campuse(20220009, "탁희아", 2, "국어국문학"));
    camList.add(new Campuse(20220010, "봉성훈", 4, "정보공학")); 
    //컬럼이름 = 멤버변수
    //1학년 학생수, 전산공학 학생수, 남씨 학생 수 등 여러값을 구할수있음

    for(Campuse c : camList){
      System.out.println(c);
    }
    
    //학년 별 학생 수
    // for(Campuse c : camList){
    //   System.out.println(c.grade); //학년만 출력
    // }
    
    // Integer grade1 = 0;
    // Integer grade2 = 0;
    // Integer grade3 = 0;
    // Integer grade4 = 0;
    // for(Campuse c : camList){
    //   if(c.grade == 1){
    //     grade1++;
    //   }else if(c.grade == 2){
    //     grade2++;
    //   }else if(c.grade == 3){
    //     grade3++;
    //   }else if(c.grade == 4){
    //     grade4++;
    //   }
    // }
    // System.out.println("1학년 : "+grade1+"명");
    // System.out.println("2학년 : "+grade2+"명");
    // System.out.println("3학년 : "+grade3+"명");
    // System.out.println("4학년 : "+grade4+"명");
    
    int[] grade_cnt = {0,0,0,0};
    for(Campuse c : camList){
      grade_cnt[c.grade-1]++;
    }
    System.out.println(Arrays.toString(grade_cnt));
    
    for(int i=0;i<grade_cnt.length;i++){
      System.out.print((i+1)+"학년 : "+grade_cnt[i]+"명");
      if(i!=grade_cnt.length-1){
        System.out.print(" / ");
      }
    }
  }
}