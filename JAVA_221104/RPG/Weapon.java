
public class Weapon {
  String name;
  Integer dmg;
  String type;
  public Weapon(){}
  public Weapon(String name, Integer dmg, String type){
    this.name = name;
    this.dmg = dmg;
    this.type = type;
  }
  void hit(){
    System.out.println(dmg+"의 대미지를 줍니다.");
  }
}
