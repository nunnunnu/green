public class Rectangle extends Point {
  int width;
  int height;
  public Rectangle(){}
  public Rectangle(int x, int y, int width, int height){
    super(x, y);
    this.width = width;
    this.height = height;
  }
  int getArea(){
    return width * height;
  }
  void printPoint(){
    System.out.println("("+x+", "+y+") w: "+width+" / h: "+height);
  }
}
