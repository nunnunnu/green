package JAVA3;

import JAVA4.Product;

public class Main {
  public static void main(String[] args) {
    // Product p = new Product();
    // p.name = "제품"; //default. 클래스파일을 다른곳으로 옮기니 에러
    // p.sub_title = "제품간략설명"; //public
    // p.price = 10000; //protected/ 같은 폴더위치에서는 사용가능, 클래스파일을 다른곳으로 옮기니 에러
    // p.stock = 100; 에러. private라서 안됨. 클래스내에 메소드를 만들어야 접근가능
    // p.showStock();//클래스파일을 다른곳으로 옮기니 에러

    //default와 protedcted는 같은 패키지 내에서만 사용가능
    
    Product p = new Product("제품","제품설명",12300,100);
    System.out.println(p.getName());
    

  }
}
