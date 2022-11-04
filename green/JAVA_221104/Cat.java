public class Cat extends Animal {
  String gen;
  public Cat(){}
  public Cat(String name, String color, String gen){
    super(name, color);
    this.gen = gen;
  }

  void makeSound(){
    System.out.println(gen+"고양이 "+name+"이(가) 야옹소리를 냅니다.");
  }
}
