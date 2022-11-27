public class Developer extends Person {
  String language; //프로그래밍언어

  public Developer(){
    //super()가 생략된 상태. 다 만들거나 다 만들지 말거나
  }
  public Developer(String name, String gen, String language){
    super(name, gen);
    this.language = language;
  }
  @Override
  public void work(){
    System.out.println("개발자 "+name+"가(이) "+language+"(으)로 프로그램을 개발한다.");
  }
}
