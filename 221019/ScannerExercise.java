import java.util.Scanner;

public class ScannerExercise {
    public static void main(String[] args) {
        System.out.println("=====회원등록=====");
        Scanner s = new Scanner(System.in);
        System.out.print("아이디 : >");
        String user_id = s.nextLine();
        System.out.print("비밀번호 : >");
        String user_pwd = s.nextLine();
        System.out.print("이름 : >");
        String user_name = s.nextLine();
        System.out.print("이메일 : >");
        String user_email = s.nextLine();
        System.out.print("생년월일(8자리로 입력하세요.) : >");
        String user_birth = s.nextLine();
        if(user_birth.length()!=8){
            System.out.println("입력값이 잘못되었습니다.");
            return;
        }
        
        String user_gen = "";
        System.out.print("성별을 입력하세요. 0-선택안함. 1-남자, 2-여자 : >");
        int n = s.nextInt();
        
        if(n==0) user_gen="선택안함";
        else if(n==1) user_gen="남";
        else if(n==2) user_gen="여";
        else{ 
            System.out.println("입력값이 잘못되었습니다.");
            return;
        }

        System.out.println("=====회원등록정보=====");
        System.out.println("아이디 : "+user_id);
        System.out.println("비밀번호 : "+user_pwd);
        System.out.println("이름 : "+user_name);
        System.out.println("이메일 : "+user_email);
        System.out.println("생년월일 (8자리) : "+user_birth);
        System.out.println("성별 : "+user_gen);
        System.out.println("====가입정보====");
        System.out.print("아이디 : "+user_id +" / 비밀번호 : ");
        for(int i=0;i<user_pwd.length();i++){
            System.out.print("*");
        }
        System.out.println();
        System.out.println("이름 : "+user_name +" / 생년월일 : "+user_birth+" / 성별 : "+user_gen);
        System.out.println("이메일 : "+user_email);
        s.close();
    }    
}
