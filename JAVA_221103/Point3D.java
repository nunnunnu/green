public class Point3D extends Point {
  int z;
  public Point3D(){}
  public Point3D(int x, int y, int z){
    super(x,y);
    this.z = z;
  }
  void printPoint(){
    System.out.println("("+x+", "+y+", "+z+")");
  }

}
