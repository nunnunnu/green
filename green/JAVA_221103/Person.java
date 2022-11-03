public class Person {
  String name;
  String gen;

  public Person(){}
  public Person(String name, String gen){
    this.name = name;
    this.gen = gen;
  }
  
  void work(){
    System.out.println("일을 시작합니다.");
  }

  public String toString() {
    return "이름 : "+name+" / 성별 : "+gen;
  }
}
