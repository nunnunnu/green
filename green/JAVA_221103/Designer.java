public class Designer extends Person {
  String tool; //사용 툴

  public Designer(){
    //super()가 생략된 상태. 다 만들거나 다 만들지 말거나
  }
  public Designer(String name, String gen, String tool){
    super(name, gen);
    this.tool = tool;
  }

  @Override
  public void work(){
    System.out.println("디자이너 "+name+"가(이) "+tool+"(으)로 디자인을 한다.");
  }
}
