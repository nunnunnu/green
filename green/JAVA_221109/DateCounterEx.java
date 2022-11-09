import java.util.Date;
import java.util.Scanner;

public class DateCounterEx {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Date now = new Date(); //현재날짜
    System.out.println("기준 날짜를 입력하세요");
    System.out.print("연도 : ");
    Integer year = s.nextInt()-1900;
    System.out.print("월 : ");
    Integer month = s.nextInt()-1;
    System.out.print("일 : ");
    Integer date = s.nextInt();
    
    Date targe = new Date(year, month, date);
    long diff = targe.getTime()-now.getTime();
    long remain = diff/1000/60/60/24;
    String suffix = remain>0?"일 남음":"일 지남";
    System.out.println(Math.abs(remain)+suffix);



  }
}
