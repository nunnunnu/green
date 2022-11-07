package Ex7;

import java.util.LinkedList;
import java.util.List;

class Unit{
  int x,y;
  void move(int x, int y){
    this.x=x;
    this.y=y;
    System.out.println("x, y("+x+", "+y+")로 이동");
  }
  void stop(){
    System.out.println("유닛정지");
  }
}

class Marine extends Unit{
  void stimPack(){
    System.out.println("스팀팩 사용");
  }
  
}

class Tank extends Unit{
  void changeMode(){
    System.out.println("탱크 모드 변경");
  }
}

class Dropship extends Unit{
  void load(){
    System.out.println("유닛 탑승");
  }
  void unload(){
    System.out.println("유닛 하차");
  }
}

public class Ex7_17 {
  public static List<Unit> unitList = new LinkedList<Unit>();
  public static void main(String[] args) {
    unitList.add(new Marine());
    unitList.add(new Tank());
    unitList.add(new Dropship());
    unitList.add(new Unit());
    for(Unit u : unitList){
      u.move(1, 5);
    }
  }
}
