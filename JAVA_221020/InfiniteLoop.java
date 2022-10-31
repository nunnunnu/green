import java.util.Scanner;

public class InfiniteLoop {
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        while(true){
            int sel = 0;
            System.out.println("===============");
            System.out.println("1. 회원추가");
            System.out.println("2. 회원조회");
            System.out.println("3. 회원수정");
            System.out.println("4. 회원삭제");
            System.out.println("0. 종료");
            System.out.print("선택 : > ");
            sel = s.nextInt();
            if(sel ==0) break;
            else if(sel ==1) System.out.println("회원추가 기능 실행");
            else if(sel ==2) System.out.println("회원조회 기능 실행");
            else if(sel ==3) System.out.println("회원수정 기능 실행");
            else if(sel ==4) System.out.println("회원삭제 기능 실행");
            else System.out.println("잘못된 기능번호 입니다. 다시 선택해주세요"); 
        }
        s.close();
    }
}
