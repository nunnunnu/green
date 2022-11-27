public class Campuse {
  Integer no;
  String name;
  Integer grade;
  String major;

  public Campuse(){}
  public Campuse(Integer no, String name, Integer grade, String major){
    setNo(no);
    setName(name);
    setgrade(grade);
    setMajor(major);
  }
  void setNo(Integer no){
    this.no = no;
  }
  void setName(String name){
    this.name = name;
  }
  void setgrade(Integer grade){
    this.grade = grade;
  }
  void setMajor(String major){
    this.major = major;
  }

  public String toString(){
    return "학번 : "+no+" / 이름 : "+name+" / 학년 : "+grade+" / 전공 : "+major;
  }
}
