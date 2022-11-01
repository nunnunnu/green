public class StudentScore {
  private String name;
  private Integer score;
  private String grade="";

  public StudentScore(String name, Integer score){
    setName(name);
    setScore(score);
  }

  void setName(String name){
    if(name.length()==0){
      System.out.println("이름을 입력하지않으셨습니다.");
    }else{
      this.name = name;
    }
  }
  void setScore(Integer score){
    if(score < 0 || score >100){
      System.out.println("입력값이 잘못되었습니다");
    }else{
      this.score = score;
    }
  }

  String getGrade(Integer score){
    if(score>=90){
      grade = "A"+ (score>=95?"+":"O");
    }else if(score>=80){
      grade = "B"+ (score>=85?"+":"O");
    }else if(score>=70){
      grade = "C"+(score>=75?"+":"O");
    }else if(score>=60){
      grade = "D"+ (score>=65?"+":"O");
    }else{
      grade = "F";
    }
    return grade;
  }
  boolean checkName(String name){
    this.name.equals(name);
    return true;
  }

  Integer getScore(){
    return score;
  }

  public String toString(){
    return "이름 : "+name+" / 점수 : "+score + " / 등급 "+getGrade(score);
  }

}
