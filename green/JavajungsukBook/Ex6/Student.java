public class Student {
  String name;
  int ban;
  int no;
  int kor;
  int eng;
  int math;
  
  public Student(){}
  public Student(String name, int ban, int no, int kor, int eng, int math){
    this.name = name;
    this.ban = ban;
    this.no = no;
    this.kor = kor;
    this.eng = eng;
    this.math = math;
  }

  int getTotal(){
    return kor + eng + math;
  }
  // double getAverage(){
  //   return Math.round((getTotal()/3.0)*10)/10.0;
  // }
  float getAverage(){
    return Math.round((getTotal()/3.0f)*100)/100.0f;
  }
  
  String info(){
    return name+", "+ban+", "+no+", "+kor+", "+eng+", "+math+", "+getTotal()+", "+getAverage();
  }
}
