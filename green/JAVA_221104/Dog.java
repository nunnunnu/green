public class Dog extends Animal { //dog is a animal
  String size;
  public Dog(){}
  public Dog(String name, String color, String size){
    super(name, color); //Animal클래스안에 제약사항이 있어서 상위클래스에서 처리하는것이 효율적임.
    this.size = size;
  }
  @Override //오버라이딩, 기능재정의
  // dog타입의 객체들은 Animal클래스의 makeSound를 실행하지않고 아래의 makeSound를 실행함
  void makeSound(){
    System.out.println(size+"견 "+name+"이(가) 멍멍 짖습니다.");
  }
  
}
