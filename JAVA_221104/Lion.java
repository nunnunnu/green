public class Lion extends Cat{
  Integer age;
  public Lion(){}
  public Lion(String name, String color, String gen, Integer age){ 
    super(name, color, gen);
    this.age = age;
  }

  @Override
  void makeSound() {
    System.out.println(gen+"사자 "+name+"이(가) 어흥하고 소리를 냅니다." );
  } //오버라이딩안해주면 Cat클래스의 makesound를 실행함.
  
}
