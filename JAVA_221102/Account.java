import java.text.DecimalFormat;

public class Account {
  private String owner;
  private Integer balance;
  
  public Account(){
  }
  public Account(String owner, Integer balance){
    setBalance(balance);
    setowner(owner);

  }
  public void setBalance(Integer balance) {
    this.balance = balance;
  }
  public void setowner(String owner) {
    this.owner = owner;
  }
  public Integer getBalance() {
    return balance;
  }
  public String getowner() {
    return owner;
  }

  public void showInfo() {
    DecimalFormat formatter = new DecimalFormat("###,###");
    System.out.println("예금주 : "+owner+" / 잔액 : "+formatter.format(balance)+"원");
  }
  // public String toString() {
  //   DecimalFormat formatter = new DecimalFormat("###,###");
  //   return "예금주 : "+owner+" / 잔액 : "+formatter.format(balance)+"원";
  // }
}
