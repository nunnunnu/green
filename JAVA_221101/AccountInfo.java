public class AccountInfo {
  String no;
  long balance;

  public AccountInfo(){
  }
  public AccountInfo(String no, long balance){
    setNo(no);
    setBalance(balance);
  }
  void setNo(String no){
    if(no.length()<12){
      System.out.println("잘못된 계좌번호입니다.");
    }else{
      this.no = no;
    }
  }
  void setBalance(long balance){
    if(balance<0){
      System.out.println("잘못된 잔액정보입니다.");
    }else{
      this.balance = balance;
    }
  }
}
