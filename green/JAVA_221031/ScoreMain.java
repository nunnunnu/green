public class ScoreMain{
  public static void main(String[] args) {
    StudentScore std1 = new StudentScore(); //new - 인스턴스화, 객체생성
    std1.showInfo();
    // std1.name = "가나다";
    // std1.score = 85.7;
    System.out.println();

    // System.out.println(std1.name); 뒤늦게 private를 붙여서 에러뜸
    // System.out.println(std1.score);
    
    StudentScore std2 = new StudentScore();
    std2.showInfo();
    System.out.println();

    // std2.name="라마바";
    // std2.score=95.2; //직접접근방식. 유효성검사를 못해서 거의 안씀
    // System.out.println(std2.name);
    // System.out.println(std2.score);
    
    System.out.println(std1);
    System.out.println(std2);
    
    StudentScore[] std = {std1,std2};
    System.out.println(std[0]);
    System.out.println(std[1]);
    System.out.println();
    // System.out.println(std[0].name);
    // System.out.println(std[1].name);
    
    std1.showInfo();
    std2.showInfo();
    System.out.println();
    std[0].showInfo();
    std[1].showInfo();
    System.out.println();
    std[0].setScore(807.0);
    std[0].showInfo();
    System.out.println();
    std[0].setScore(80.7); //간접접근방식
    std[0].showInfo();
    
    System.out.println(std[0].getGrade());
    System.out.println(std[1].getGrade());
    
    String g = std2.getGrade();
    System.out.println(g);
    
    StudentScore std3 = new StudentScore();
    System.out.println(std3.getGrade()); //double초기값이 0이라서 f나옴

    StudentScore std4 = new StudentScore("aaaa",75);
    std4.showInfo();
    std4.setScore(85);
    std4.setScore(85.7);

  }
}