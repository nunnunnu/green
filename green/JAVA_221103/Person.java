public abstract class Person {
  String name;
  String gen;

  public Person(){}
  public Person(String name, String gen){
    this.name = name;
    this.gen = gen;
  }
  
  abstract void work();

  public String toString() {
    return "이름 : "+name+" / 성별 : "+gen;
  }
}
