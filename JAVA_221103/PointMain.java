public class PointMain{
  public static void main(String[] args) {
    Point pt = new Point(1, 2);
    pt.printPoint(); //(1, 2) 출력
    
    Point3D pt3d = new Point3D(10, 20, 30);
    
    pt3d.printPoint(); //(10, 20) 출력
    //Point에서 만든거라 z값은 출력안됨 -> Point3D에서 오러라이딩해줘서 z까지 출력됨. (10, 20, 30) 출력
    //위 printPoint와 다른메소드임.
    
    Rectangle rect = new Rectangle(20, 30, 5, 10);
    Circle c = new Circle(50, 50, 3.0);
    rect.printPoint();
    System.out.println(rect.getArea()); //(오버라이딩 후 (20, 30) w: 5 / h: 10 출력
    c.printPoint(); //오버라이딩 후 (50, 50) r: 3.0 출력
    System.out.println(c.getArea());
    
    // Point pt2 = new Point(1, 2);
    Point pt3d2 = new Point3D(10, 20, 30);
    // Point rect2 = new Rectangle(20, 30, 5, 10);
    // Point c2 = new Circle(50, 50, 3.0);
    System.out.println();
    // System.out.println(pt3d2.z); //pt3d2는 Point의 변수라서 Point3d의 z는 사용불가
    pt3d2.printPoint(); //(10, 20, 30) 출력

    Point[] arr_pt = {
      new Point(10, 20),
      new Point3D(10, 20,30),
      new Rectangle(20,30,5,10),
      new Circle(50,50,3.0)
    };
    for(Point p : arr_pt){
      p.printPoint();
    }
    /*(10, 20, 30)
      (10, 20) 
      (10, 20, 30) 
      (20, 30) w: 5 / h: 10 
      (50, 50) r: 3.0   출력됨.*/ //같은 명령문으로 다른 기능을 사용가능함.

    // c2.getArea();  //불가능
    //오버라이딩을 했다면 조상클래스의 메소드가아닌 자신의 메소드를 실행함.
    //회원등급별로 허용되는 기능이 다를때 등 사용
  }
}