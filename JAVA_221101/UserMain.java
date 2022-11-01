public class UserMain{
  public static void main(String[] args) {
    // UserInfo u1 = new UserInfo();
    // u1.id = "user001";
    // u1.pwd = "123456";
    // u1.name = "사용자";
    // System.out.println("ID : "+u1.id);
    // System.out.println("Name : "+u1.name);
    
    UserInfo u2 = new UserInfo("user002","123456","사용자2");
    // System.out.println("ID : "+u2.id);
    // System.out.println("Name : "+u2.name);
    System.out.println(u2.getId());
    System.out.println(u2);
    System.out.println(u2.account.no);
    UserInfo u3 = new UserInfo("user003","123456","사용자3");
    u3.account.setNo(("123456789654"));
    System.out.println(u3.account.no);
  }
}