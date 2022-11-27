public class ShopLogin implements LoginInterface {

  private String id;
  private String pwd;
  

  @Override
  public boolean connect() {
    return false;
  }
  @Override
  public boolean authorication() {
    return false;
  }
  @Override
  public void showLoginInfo() {
    
  }  
  @Override
  public boolean logout() {
    return false;
  }
  @Override
  public boolean discounnect() {
    return false;
  }
}
