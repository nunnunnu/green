public class Account {
  private int balance; //계좌 잔액
  private String owner;  // 계좌 소유자 이름

  public Account(int balance, String owner){
    setBalance(balance);;
    this.owner = owner;
  }
  public Account(){
  }

  void setBalance(int balance){
    if(balance<0){
      System.out.println("입력값이 잘못되었습니다.");
      return;
    }
    this.balance = balance;
  }
  int getBalance(){
    return this.balance; //일반적으로 this 붙임
  }
  void setOwner(String owner){
    this.owner = owner;
  }
  String getOwner(){
    return this.owner;
  }
  void withdraw(int money){
    System.out.println("출금 신청 액 : "+money+"원");
    if(money<0){
      System.out.println("출금액이 잘못 입력되었습니다.");
      return;
    }
    if(this.balance<money){
      System.out.println("잔액이 부족합니다.");
      return;
    }
    this.balance -= money;
    System.out.println(money+"원을 출금하였습니다. (잔액 : "+balance+"원)");
  }
  void deposit(int money){
    System.out.println("입금 신청 액 : "+money+"원");
    if(money<0){
      System.out.println("입금액이 잘못 입력되었습니다.");
      return;
    }
    this.balance += money;
    System.out.println(money+"원을 입금하였습니다. (잔액 : "+balance+"원)");
  }
  void showInfo(){
    System.out.println("소유주 : "+this.owner+" / 잔액 : "+this.balance);
  }
}
