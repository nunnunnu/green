import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
  public static void main(String[] args) {
    Date dt = new Date();
    System.out.println(dt);
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss"); //a - 오전, 오후
    System.out.println(f.format(dt));
    Date dt2 = new Date(122,10,9); //년, 월, 일, 시, 분, 초 입력가능(단 년은 연도-1900 해야함, 월은 0이 1월임)
    System.out.println(f.format(dt2));
    // System.out.println(dt2<dt); //안됨. 에러
    //자바에서 권장안하나 변수로 사용은 많이함

    //1970-01-01부터 지정날짜까지 흐른 시간을 ms단위로 표시
    System.out.println(dt.getTime()); //long형. Unix TimeStamp.
    System.out.println(dt2.getTime()); //long형 Unix TimeStamp.
    Long diff = (dt.getTime()-dt2.getTime())/1000; //ms단위라서 /1000해줌
    System.out.println(diff);
    System.out.println(diff/60); //분
    System.out.println(diff/60/60+"시"); //시간
    System.out.println(diff/60%60+"분"); //시간계산하고 남은 분 표시

    Date now = new Date();
    long time = now.getTime() + 30*24*60*60*1000L; 
    Date dt3 = new Date(time);
    System.out.println(f.format(dt3));
  }
}
