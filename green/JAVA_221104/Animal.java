public class Animal {
  String name;
  String color;
  public Animal(){}
  public Animal(String name, String color){
    this(); //생성자. 위의 매개변수없는 기본생성자를 가르킴. 맨위에 써줘야함
    // this(name, color); //무한반복에걸려서 에러
    //this 포인터
    // this; //현재 이 클래스 전체를 의미
    if(name.length()==0){
      this.name = "동물";
    }else{
      this.name = name;
    }
    this.color = color;
    // this.someMethod();
  }
  // public void someMethod(){
  //   System.out.println("some Method");
  // }

  void makeSound(){
    System.out.println("동물 "+name+"이(가) 소리를 냅니다.");
  }
}