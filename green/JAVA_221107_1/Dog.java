public /* abstract */ class Dog extends Animal { //Dog도 추상클래스로 만들면 makeSound안만들어도됨
  @Override
  public void makeSound() {
    // TODO Auto-generated method stub
    System.out.println("이름 : "+name+" / 색깔 : "+color);
    System.out.println("멍멍");
  }
  
}
