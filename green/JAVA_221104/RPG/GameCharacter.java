
public class GameCharacter {
  //무기, 방어구(머리, 몸통(상의, 하의), 다리, 팔 , 장신구)
  Weapon w;
  public GameCharacter(){}
  public GameCharacter(Weapon w){
    this.w = w;
  }
  void attack(){
    System.out.println("공격합니다");
    w.hit();
  }
    
  
  
}
