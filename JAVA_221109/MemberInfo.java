public class MemberInfo {
  public static final int MIN_LENGTH=6;
  private String id;
  private String pwd;


  public String getId() {
    return this.id;
  }

  public void setId(String id) throws Exception {
    if(id.length()<MIN_LENGTH){
      throw new InputValueLengthException();
    }
    this.id = id;
  }
  
  public String getPwd() {
    return this.pwd;
  }
  
  public void setPwd(String pwd) throws Exception {
    if(pwd.length()<MIN_LENGTH){
      throw new InputValueLengthException();
    }
    this.pwd = pwd;
  }

}
