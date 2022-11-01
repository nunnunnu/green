public class UserInfo {
  private String id;
  private String pwd;
  private String name;
  //포함관계(클래스안에 다른 클래스를 포함 중)
  AccountInfo account;

  public UserInfo(){
    System.out.println("UserInfo기본생성자");
    account = new AccountInfo("123456789132",0L);
  }
  public UserInfo(String id, String pwd, String name){
    setId(id);
    setPwd(pwd);
    setName(name);
    account = new AccountInfo("123456789132",0L);
    
  }
  void setId(String id){
    if(id.length() < 6){
      System.out.println("ID는 6자 이상이어야 합니다.");
    }else{
      this.id = id;
    }
  }
  void setPwd(String pwd){
    if(pwd.length() < 6){
      System.out.println("비밀번호는 6자 이상이어야 합니다.");
    }else{
      this.pwd = pwd;
    }
  }
  void setName(String name){
    if(name.length() == 0){
      System.out.println("이름으로 공백을 지정할 수 없습니다. 올바르게 입력해주세요");
    }else{
      this.name = name;
    }
  }
  String getId(){
    return this.id;
  }
  String getName(){
    return this.name;
  }
  String getPwd(){
    return this.pwd;
  }
  public String toString(){ //미리만들어진 toString오버로딩. 원래는 UserInfo@28a418fc식으로 주소값출력
    //메소드 재정의, 덮어쓰기 (overwrite)
    return "ID : "+id + " / Name : "+ name;
  }

  public static void main(String[] args) {
  }
}
