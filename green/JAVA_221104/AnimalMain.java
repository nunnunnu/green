import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnimalMain {
  public static void main(String[] args) {
    //변수타입 - Animal / 객체타입 - Animal
    Animal a = new Animal("동물1", "흰색");
    a.makeSound();
    //변수타입 - Dog / 객체타입 - Dog
    Dog d = new Dog("멍멍이", "검정", "중형");
    d.makeSound();
    //변수타입 - Animal / 객체타입 - Dog  -> 다형성. 
    Animal a1 = new Dog("강쥐", "흰색", "소형");
    a1.makeSound();

    Map<String, Object> map = new LinkedHashMap<String, Object>(); //key - String, value - object
    map.put("animal", a);
    map.put("dog", d);
    List<String> list = new ArrayList<String>();
    list.add("1");
    list.add("2");
    list.add("3");
    map.put("list",list);
    map.put("integer", 123);
    System.out.println(map);  //{animal=Animal@5305068a, dog=Dog@1f32e575, list=[1,2,3], integer=123} 출력
    // 집어넣는건 가능한데 꺼낼때 곤란해짐. 형변환도 정확하지않으면 에러남
    // 프론트엔드에 넘겨주면 됨. JSON에서는 보임

    Animal a2 = new Cat("냥이", "삼색", "암컷");

    a2.makeSound();

    List<Animal> aniList = new ArrayList<Animal>();
    aniList.add(a);
    aniList.add(a1);
    aniList.add(a2);
    aniList.add(new Lion("사자", "누렁이", "암컷", 5)); 
    System.out.println("---------------------");
    for(Animal am : aniList){
      am.makeSound();
      System.out.println();
    }
    System.out.println("---------------------");
    Cat l = new Lion("사장", "노랑", "수컷", 11);
    l.makeSound();
  
    // Lion a3 = new Animal("동뮬", "갈색"); //불가능. 
    //하위클래스(Sub Class)타입으로 상위클래스(Super Class) 타입의 객체를 저장할 수 없음

  }
}
