public class StudentScore { //클래스 선언(정의, define)

  //멤버변수(=인스턴스변수)
  private String name;
  private double score;

  //생성자 : 객체를 생성함과 동시에 실행되는 메소드
  //생성자 오버로딩
  public StudentScore(){ //기본생성자. 만들지 않으면 빈 상태로 자바에서 생성함
    System.out.println("StudentScore생성자 실행");
    this.name = "aaa";
    // this.score = 95;
    setScore(95);
  }
  public StudentScore(String name, double score){ //입력 값이 있는 생성자
    System.out.println("StudentScore(name, score)");
    this.name = name;
    // this.score = score;
    setScore(score);
  } //입력값이있는 생성자(Constructor)가 있으면 기본생성자는 자바가 자동으로 안만들어줌


  //메소드(기능)
  void showInfo(){
    System.out.println("이름 : "+name);
    System.out.println("점수 : "+score);
    System.out.println("등급 : "+getGrade());
  }

  void setScore(double s){ //int s : 파라미터, 외부 입력값
    System.out.println("double");
    if(s < 0 || s>100){
      System.out.println("입력값이 잘못되었습니다.");
      return;
    }
    this.score = s;
  }
  
  void setScore(int s){ //int s : 파라미터, 외부 입력값
    System.out.println("int");
    if(s < 0 || s>100){
      System.out.println("입력값이 잘못되었습니다.");
      return;
    }
      this.score = s;
  }

  String getGrade(){
    String grade="";

    if(score>100 || score<0){
      System.out.println("입력값이 잘못되었습니다.");
    }else if(score>=90){
      grade = "A"+(score>=95?"+":"0");
    }else if(score>=80){
      grade = "B"+(score>=85?"+":"0");
    }else if(score>=70){
      grade = "C"+(score>=75?"+":"0");
    }else if(score>=60){
      grade = "D"+(score>=65?"+":"0");
    }else{
      grade = "F";
    }
    return grade;

  }

}
