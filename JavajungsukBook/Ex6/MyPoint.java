public class MyPoint {
  int x;
  int y;
  
  MyPoint(int x, int y){
    this.x=x;
    this.y=y;
  }
  double getDistance(int x1, int y1){
    return Math.sqrt((x1-x) + (y1-y));
  }
}
