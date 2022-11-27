import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CalendarEx02 {
  public static void main(String[] args) {
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = Calendar.getInstance();
    c2.set(Calendar.MONTH,10);
    c2.set(Calendar.DATE, 28);
    System.out.println(c2.getTimeInMillis() - c1.getTimeInMillis());
    long diff = c2.getTimeInMillis()-c1.getTimeInMillis(); 
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    int interval = (int)(diff/1000/60/60/24);
    List<String> dates = new ArrayList<String>();
    for(int i=0;i<interval;i++){
      dates.add(f.format(c1.getTime()));
      c1.add(Calendar.DATE, 1);
    } 
    Scanner s = new Scanner(System.in);
    System.out.print("예약할 날짜 (yyyy-MM-dd) : ");
    String strDt = s.nextLine();
    if(dates.contains(strDt)){
      System.out.println("선택한 날짜는 예약할 수 없습니다.");
    }else{
      System.out.println("선택한 날짜로 예약하였습니다.");
    }
    LocalDate ldt = LocalDate.now();
    System.out.println(ldt); //2022-11-09 출력
    LocalTime ltime = LocalTime.now();
    System.out.println(ltime); //17:45:19.156900100 출력
    s.close();
  } 
}
