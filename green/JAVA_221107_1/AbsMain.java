public class AbsMain {
  public static void main(String[] args) {
    // AbstractSuperClass superClass = new AbstractSuperClass(); //불가능. 메소드가 구현안된 상태이기때문. 
    AbstractSuperClass obj = new SubClass(); //객체생성은 못하지만 하위클래스타입의 객체를 담는 변수타입으로는 사용가능
    //추상클래스 = 상속 / 다형성 전용

    obj.x = 10;
    obj.showInfo();

    Animal animal = new Dog();
    Animal animal2 = new Cat();
    animal.name = "멍멍이";
    animal.color = "흰색";
    animal.makeSound(); //멍멍출력
    animal2.name = "야옹이";
    animal2.color = "치즈";
    animal2.makeSound(); //야옹출력

    // Animal a = new Animal(); //불가능.   
    }
}
