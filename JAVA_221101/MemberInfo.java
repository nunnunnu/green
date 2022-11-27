public class MemberInfo {
  private String id;
  private String pwd;
  private String name;

  public MemberInfo(){}
  public MemberInfo(String id, String pwd, String name){
    setId(id);
    setPwd(pwd);
    setName(name);
  }

  void setId(String id){
    if(id.length()<6){
      System.out.println("아이디는 6자리 이상입니다.");
    }else{
      this.id = id;
    }
  }
  void setPwd(String pwd){
    if(pwd.length()<6){
      System.out.println("비밀번호는 6자리 이상입니다.");
    }else{
      this.pwd = pwd;
    }
  }
  void setName(String name){
    if(name.length()==0){
      System.out.println("이름이 입력되지 않았습니다.");
    }else{
      this.name = name;
    }
  }
  public String toString(){
    return "아이디 : "+id+" / 이름 : "+name;
  }
  Boolean pwdCheck(String pwd){
    return this.pwd.equals(pwd);
  }
  
  public static void main(String[] args) {
    
  }
}
