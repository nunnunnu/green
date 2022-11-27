package data;

public class Member {
  public String id;
  public String pwd;
  public String name;
  public Boolean isAdmin;

  public Member(String id, String pwd, String name, Boolean isAdmin) {
    this.id = id;
    this.pwd = pwd; //암호화
    this.name = name;
    this.isAdmin = isAdmin;
  }
  
  @Override
  public String toString() {
    String type = isAdmin?"관리자":"일반회원";
    return "아이디 : "+id+" / 이름 : "+name+" / 회원유형 : "+type/* +" / 비밀번호 : "+pwd */;
  }
  public String makeDataString(){
    return id+","+pwd+","+name+","+isAdmin;
  }
}
