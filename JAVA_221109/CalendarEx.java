import java.util.Calendar;

public class CalendarEx {
  public static void main(String[] args) {
    Calendar c = Calendar.getInstance(); //이미 만들어진 인스턴스를 가져옴
    System.out.println(c);
    System.out.println(c.getTime()); //Wed Nov 09 17:05:19 KST 2022
    c.add(Calendar.DATE,30); //1달 후
    System.out.println(c.getTime()); //Fri Dec 09 17:05:19 KST 2022
    c.add(Calendar.DATE,-60); //2달전
    System.out.println(c.getTime()); //Mon Oct 10 17:06:21 KST 2022
    c.set(Calendar.YEAR, 2021);
    c.set(Calendar.MONTH, 10); //월은 1
    c.set(Calendar.DATE, 9);
    System.out.println(c.getTime()); //Tue Nov 09 17:07:24 KST 2021

  }
}
