import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

public class InputEx {
    public static void main(String[] args) throws IOException {
        //표준입력을 대상으로 하는 스캐너 생성
        // Scanner s = new Scanner(System.in);
        // int input = s.nextInt(); //int형태의 값 하나 입력받기
        // s.close(); //Scanner 사용 종료
        Calendar c = Calendar.getInstance();
        final int CURRENT_YEAR=c.get(Calendar.YEAR);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            System.out.println("==============");
            System.out.println("출생년도를 입력하세요. 종료하려면 0을 입력하세요");
            int birthyear = Integer.parseInt(br.readLine());
            if(birthyear==0) break;
            else if(birthyear>2022 || birthyear<0){
                System.out.println("입력값이 잘못되었습니다.");
                return;
            }
            System.out.println("입력한 값 : "+birthyear);
            // System.out.println((CURRENT_YEAR-birthyear+1)+"세 입니다");
            int age=CURRENT_YEAR-birthyear;
            System.out.println(age+"세 입니다");
            if(age>=18) System.out.println("성인입니다.");
            System.out.println("=================");
        }
      
        br.close();
    }
}
