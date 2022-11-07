public class PersonMain {
  public static void main(String[] args) {
    
    Person[] persons ={
      // new Person("박진희", "여"),
      new Designer("박진희", "여","photoshop"),
      new Developer("박진희", "여","JAVA")
    };
    for(Person p : persons){
      System.out.println(p.toString());
      p.work();
      System.out.println();
    } 
    /*이름 : 박진희 / 성별 : 여
    일을 시작합니다.
    
      이름 : 박진희 / 성별 : 여
      일을 시작합니다.
      디자이너 박진희가(이) photoshop(으)로 디자인을 한다.
      
      이름 : 박진희 / 성별 : 여
      일을 시작합니다.
      개발자 박진희가(이) JAVA(으)로 프로그램을 개발한다.*/ //출력됨
      
      //Person클래스 타입으로 Developer, Designer 클래스 타입의 객체를 생성가능 : 다형성. 상속관계에서만 사용가능
      // Person p1  = new Person("박진희", "여");
      Person p2 = new Designer("박진희", "여","photoshop");
      Person p3 = new Developer("박진희", "여","JAVA");
      // p1.work(); //Person의 work실행
      p2.work(); //Designer의 work실행
      p3.work(); //Developer의 work실행
      //기존클래스 Person의 work를 Developer와 Designer에서도 만들어줬다(재정의) : 오버라이딩

    }
}
