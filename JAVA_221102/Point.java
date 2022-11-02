import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Point {
  int x, y;
  public Point(){

  }
  public Point(int x, int y){
    this.x=x;
    this.y=y;
  }
  void printPoint(){
    System.out.println("("+x+", "+y+")");
  }
  public static void main(String[] args) {
    List<Point> ptList = new ArrayList<Point>();
    Point pt = new Point(1,2);
    ptList.add(pt);
    System.out.println(ptList); //[Point@2f92e0f4]출력
    System.out.println(pt); //Point@2f92e0f4 출력
    ptList.get(0).printPoint(); //(1, 2) 출력
    ptList.add(pt);
    System.out.println(ptList); //[Point@2f92e0f4, Point@2f92e0f4] 출력
    System.out.println(pt); //Point@2f92e0f4 출력
    ptList.get(1).printPoint(); //(1, 2) 출력
    pt.x=10;
    pt.y=20;
    System.out.println(ptList); //[Point@2f92e0f4, Point@2f92e0f4] 출력
    System.out.println(pt); //Point@2f92e0f4 출력
    ptList.get(1).printPoint(); //(10, 20) 출력
    ptList.get(0).printPoint(); //(10, 20) 출력 배열1,2의 값모두 동일한 pt의 주소값을 받아와서 모두 바뀜
    
    ptList.set(1,new Point(3, 4)); //새로운 주소값으로 갱신해줌
    System.out.println(ptList);//[Point@2f92e0f4, Point@28a418fc] 출력. 두개의 주소값이 달라짐
    pt.x=100;
    ptList.get(0).printPoint(); //(100, 20) 출력
    ptList.get(1).printPoint(); //(3, 4) 출력
    
    
    Point pt1 = new Point(20,30);
    Point pt2 = new Point(30,40); //값을 수정할 수 있는 경로가 늘어남
    ptList.add(pt1);
    ptList.add(pt2);
    System.out.println(ptList); //[Point@2f92e0f4, Point@28a418fc, Point@5305068a, Point@1f32e575]
    ptList.get(0).printPoint(); //100,20
    ptList.get(1).printPoint(); //3,4 
    ptList.get(2).printPoint(); //20,30
    ptList.get(3).printPoint(); //30,40
    System.out.println();
    ptList.add(2, new Point(50,60)); //값을 수정할 수 있는 경로가 줄어 오류가 줄어듬
    System.out.println(ptList); //[Point@2f92e0f4, Point@28a418fc, Point@279f2327, Point@5305068a, Point@1f32e575] 
    //2번째 자리에 추가. 뒤로 한칸씩 밀림
    ptList.get(0).printPoint(); //100,20
    ptList.get(1).printPoint(); //3,4
    ptList.get(2).printPoint(); //50,60
    ptList.get(3).printPoint(); //20,30
    ptList.get(4).printPoint(); //30,40
    String list = ptList.toString();
    System.out.println(list); //[Point@2f92e0f4, Point@28a418fc, Point@279f2327, Point@5305068a, Point@1f32e575]
    System.out.println(Arrays.asList(ptList)); //[[Point@2f92e0f4, Point@28a418fc, Point@279f2327, Point@5305068a, Point@1f32e575]]
    System.out.println(ptList.get(0).toString()); //Point@2f92e0f4
    //값만 전체 출력하려면 어케하냐고
    //구글링해보니 toStirng 오버라이딩하란다
    ptList.clear(); //전부 삭제
    System.out.println(ptList); //[] 출력 
    // System.out.println(Arrays.toString(ptList));

  }
}
