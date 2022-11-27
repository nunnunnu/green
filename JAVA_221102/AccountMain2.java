import java.util.ArrayList;
import java.util.List;

public class AccountMain2 {
  public static void main(String[] args) {
    List<Account> accList = new ArrayList<Account>();
    accList.add(new Account("aaa",50000));
    accList.add(new Account("bbb",4600000));
    accList.add(new Account("ccc",1000));
    accList.add(new Account("ddd",100000000));

    System.out.println("accList의 크기 : "+accList.size());
    for(int i=0;i<accList.size();i++){
      accList.get(i).showInfo();
    } 
    System.out.println();
    for(Account a:accList){
      a.showInfo();
    } //위 for문이랑 같음. 짧아서 씀
    System.out.println();
    accList.remove(1);
    for(Account a:accList){
      a.showInfo();
    }
    System.out.println();
    Account acc =accList.remove(1); //제거한 값 변수에 저장. 잘 안쓰긴함
    for(Account a:accList){
      a.showInfo();
    }
    System.out.println();
    acc.showInfo(); //삭제한 값 출력
    System.out.println();
    
    accList.set(0, new Account("급여통장", 10000000)); //0번째의 데이터/객체를 새로 만들어서 교체. 인덱스값넘으면 에러남. 추가안됨
    for(Account a:accList){
      a.showInfo();
    }
    System.out.println();
    Account old = accList.set(0, new Account("생활비통장", 500000)); //교체 전 값 저장
    for(Account a:accList){
      a.showInfo();
    }
    System.out.println();
    old.showInfo(); //교체 전 값 출력
    
    System.out.println();
    
    accList.add(1, old); //교체 전 값 1번에다가 집어넣고 뒷데이터들은 인덱스가 하나씩 밀림
    for(Account a:accList){
      a.showInfo(); 
    }
    
    
  }
}
