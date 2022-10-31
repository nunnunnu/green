public class AccountEx {
  public static void main(String[] args) {
    Account account = new Account(10000,"빅데이터");
    account.showInfo();
    account.withdraw(100000);
    account.withdraw(-100000);
    account.withdraw(1000);
    account.deposit(35000);
    account.deposit(-10000);
    account.showInfo();
    account.setBalance(-1000);
    account.showInfo();
  }
}
