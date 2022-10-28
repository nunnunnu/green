import java.util.Scanner;

public class ConditionCheck11111 {
    public static void main(String[] args) {
        //비교연산자
        //대소비교(이상, 이하, 초과, 미만)
        //동일비교(같다, 다르다)
        // int x =10;
        // System.out.println(x>=10);//이상
        // System.out.println(x<=10);//이하
        // System.out.println(x>10);//초과
        // System.out.println(x>10);//미만
        // System.out.println(x==10); //동일
        // System.out.println(x!=10); //다른값?
        
        //동일비교
        // int sel = s.nextInt();
        // System.out.println("1번 선택 : "+(sel == 1));
        // System.out.println("2번 선택 : "+(sel == 2));
        // System.out.println("3번 선택 : "+(sel == 3));
        // System.out.println("4번 선택 : "+(sel == 4));
        // if(sel == 1) System.out.println("1번을 선택함");
        // if(sel == 2) System.out.println("2번을 선택함");
        // if(sel == 3) System.out.println("3번을 선택함");
        // if(sel == 4) System.out.println("4번을 선택함");
        
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        if(input.equals("hello")) System.out.println("Hello World!!");
        if(input.equals("bye")) System.out.println("Exit Program");

        
        s.close();

        // System.out.println("출생 연도를 입력하세요");
        // int birthYear=s.nextInt();
        // int age = 2022-birthYear;
        // String msg= age>=18 ? "성인입니다." :"미성년입니다.";
        // System.out.println(msg);
        // s.close();

        // int totalCount =123;
        // final int POST_PER_PAGE=10;
        // //totalcount를 POST_PER_PAGE로 나눈 나머지 값이 0을 초과한다면 additionalPage를 1. 아니면 0
        // int additionalPage = totalCount % POST_PER_PAGE > 0 ? 1 : 0;
        // int totalPage = totalCount / POST_PER_PAGE + additionalPage;
        // System.out.println("총 페이지 수 : "+totalPage); 



    }
}
