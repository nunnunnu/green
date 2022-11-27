public class GameMain {
  public static void main(String[] args) {
    GameCharacter c = new GameCharacter(new Weapon("롱소드", 15, "검"));
    c.attack();
    c.w.hit();
  }
}
