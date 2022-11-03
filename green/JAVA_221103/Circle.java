public class Circle extends Point {
  double r;
  public Circle(){}
  public Circle(int x, int y, double r){
    super(x, y);
    this.r = r;
  }
  double getArea(){
    return r*r*Math.PI;
  }
  void printPoint(){
    System.out.println("("+x+", "+y+") r: "+r);
  }
}
