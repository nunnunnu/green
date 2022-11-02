import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentScoreMain {
  public static void main(String[] args) {
    List<StudentScore> studentlist = new ArrayList<StudentScore>();
    Scanner s= new Scanner(System.in);
    
    while(true){
      System.out.print("1.추가, 2.수정, 3.삭제, 4.조회, 0.종료 >> ");
      int sel = s.nextInt(); 
      s.nextLine();

      if(sel ==0){
        System.out.println("프로그램을 종료합니다.");
        s.close();
        break;
      }
      else if(sel ==1){
        System.out.print("이름 : ");
        String name = s.nextLine();
        System.out.print("점수 : ");
        Integer score = s.nextInt();
        StudentScore std = new StudentScore(name, score);
        if(std.getCheck()){
          studentlist.add(new StudentScore(name, score));
        }
      }
      else if(sel ==2 ){
        if(studentlist.size()!=0){
          System.out.println("===============목록================");
          for(int i=0;i<studentlist.size();i++){
            System.out.println(i+"번째 학생 -"+studentlist.get(i));
          }
          System.out.print("수정할 학생의 번호를 입력하세요 : >>");  
            int index = s.nextInt();
            StudentScore st = studentlist.get(index);
            String name = s.nextLine();
            if(st.checkName(name)){
              System.out.print("이름 : ");
              name = s.nextLine();
              System.out.print("점수 : ");
              Integer score = s.nextInt();
              studentlist.set(index, new StudentScore(name, score));
            }
          }
          else{
            System.out.println("등록된 학생이 없습니다.");
          }
        }
        else if(sel ==3 ){
          if(studentlist.size()!=0){
          System.out.println("================목록==================");
          for(int i=0;i<studentlist.size();i++){
            System.out.println(i+"번째 학생 -"+studentlist.get(i));
          }
          System.out.print("삭제할 학생의 번호를 입력하세요 : >>");  
          int index = s.nextInt();
          studentlist.remove(index);
          System.out.println("삭제되었습니다.");  
        }
        else{
          System.out.println("등록된 학생이 없습니다.");
        }
      }
        else if(sel ==4 ){
        int sum=0;
        for(int i=0;i<studentlist.size();i++){
          // StudentScore st = studentlist.get(i);
          // sum += st.getScore(); //나 왜이렇게했지
          sum += studentlist.get(i).getScore();
          System.out.println("===목록===");
          System.out.println(i+"번째 학생 -"+studentlist.get(i));
        }
        if(studentlist.size()!=0){
          System.out.println("전체 학생의 평균 : "+sum/studentlist.size());
        }else{
          System.out.println("등록된 학생이 없습니다.");
        }
      }else{
        System.out.println("번호를 잘못입력하셨습니다. 0~4사이의 번호를 입력해주세요");
      }
    }
  }
}
