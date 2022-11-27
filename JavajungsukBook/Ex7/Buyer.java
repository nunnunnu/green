package Ex7;

import java.util.ArrayList;
import java.util.List;

public class Buyer {
  int money = 1000;
  List<Product> cart = new ArrayList<Product>();

  void buy(Product p){
    if(money<p.price){
      System.out.println("돈이 부족해서"+p+"을(를) 구매할 수 없습니다.");
      return;
    }
    money -= p.price;
    add(p);
    System.out.println(p+"을(를) 구매했습니다.");
  }
  void add(Product p){
    cart.add(p);
  }

  void summary(){
    System.out.print("구입한 물건 : ");
    int sum=0;
    for(Product p : cart){
      System.out.print(p+", ");
      sum+=p.price;
    }
    System.out.println();
    System.out.println("사용한 금액 : "+sum);
    System.out.println("남은 금액 : "+money);
  }
  
}
