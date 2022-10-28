import java.util.Scanner;

public class Member_method {
    static final int MAX_MOMBER = 100;
    static String user_id = "";
    static String user_pw = "";
    static String user_name = "";
    static String user_birth = "";        
    static String user[][] = new String[MAX_MOMBER][4];
    static int index = 0;
    static Scanner s = new Scanner(System.in);
    static int input=0;
    static boolean id_check = true;
    static boolean login_check=false;
    public static void main(String[] args) {
        while(true){
            System.out.print("1.회원가입, 2.로그인, 3.회원정보 수정, 4.회원탈퇴, 5.회원정보조회, 0.종료 : > ");
            int sel = s.nextInt();
            s.nextLine();
            switch(sel){
                case 1: //회원가입
                    String result = input_member();
                    // 아이디, 비번 6자리 이상. 미만이면 실패
                    for(index=0;index<user.length;index++){
                        if(user[index][0] == null){
                            break;
                        }
                    }
                    if(index==user.length){
                        System.out.println("회원가입에 실패했습니다. 관리자에게 문의하십시오.");
                        break;
                    }
                    if(result.split(",").length==4){
                        user[index][0] = result.split(",")[0]; 
                        user[index][1] = result.split(",")[1]; 
                        user[index][2] = result.split(",")[2]; 
                        user[index][3] = result.split(",")[3]; 
                    }
                    break;
                case 2:  // 로그인(조회)
                    login();
                    if(!login_check){
                        System.out.println("로그인 실패. 아이디와 비밀번호를 확인해주세요");
                    }
                    break;
                case 3:// 회원정보 수정
                    login();
                    if(login_check){
                        result = input_member();
                        if(result.split(",").length==4){
                            user[index][0] = result.split(",")[0]; 
                            user[index][1] = result.split(",")[1]; 
                            user[index][2] = result.split(",")[2]; 
                            user[index][3] = result.split(",")[3]; 
                        }

                    }
                    else {
                        System.out.println("로그인 실패. 아이디와 비밀번호를 확인해주세요");
                    }
                    break;
                case 4: 
                    login();
                    if(login_check){
                        System.out.print("정말 회원탈퇴하시겠습니까?(1-예. 0-아니오) > ");
                        input =s.nextInt();
                        if(input==1){
                            user[index][0] = null;
                            user[index][1] = null;
                            user[index][2] = null;
                            user[index][3] = null;
                            break;
                        }
                        else {
                            System.out.println("회원탈퇴가 취소되었습니다. 처음으로 돌아갑니다.");
                        }
                    }else {
                            System.out.println("아이디와 비밀번호를 확인해주세요");
                            break;
                    }
                    break;
                case 5:
                    int manager_code = 1234;
                    System.out.print("관리자 코드를 입력하세요 : >");
                    input = s.nextInt();
                    if(input == manager_code){
                        for(int i=0;i<user.length;i++){
                            if(user[i][0]!=null){
                                System.out.println("===회원정보====");
                                System.out.println("아이디 : "+user[i][0]);
                                System.out.print("비밀번호 : ");
                                for(int j=0;j<user[i][1].length();j++){
                                    System.out.print("*");
                                }
                                System.out.println();
                                System.out.println("이름 : "+user[i][2]);
                                System.out.println("생년월일 : "+user[i][3]);
                            }
                        }
                    }
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    s.close();
                    return;
                default : 
                    System.out.println("입력번호가 잘못되었습니다.");
            }//switch
        }//while
    }//main   
    public static String input_member(){
        System.out.print("아이디를 입력하세요(6자리 이상) : > ");
        user_id=s.nextLine();
        if(user_id.length()<6){
            System.out.println("아이디가 6자리 미만입니다. 처음부터 다시 시도해주세요");
            return "";
        }
        id_check = true;
        for(int i=0;i<user.length;i++){
            if(user_id.equals(user[i][0])){
                System.out.println("이미 등록된 아이디입니다. 처음부터 다시 시도해주세요");
                id_check = false;
            }
        }
        if(id_check){
            System.out.print("비밀번호를 입력하세요(6자리 이상) : > ");
            user_pw=s.nextLine();
            if(user_pw.length()<6){
                System.out.println("비밀번호가 6자리 미만입니다. 처음부터 다시 시도해주세요");
                return "";
            }
            System.out.print("이름을 입력하세요 : > ");
            user_name=s.nextLine();
            System.out.print("생년월일을 입력하세요(8자리) : > ");
            user_birth=s.nextLine();
            if(user_birth.length()!=8){
                System.out.println("생년월일을 8자리로 입력해주세요. 처음부터 다시 시도해주세요");
                return "";
            }
        }
        return user_id+","+user_pw+","+user_name+","+user_birth;
    }//input_member
    public static boolean login(){
        System.out.print("가입한 아이디를 입력하세요 : > ");
        user_id = s.nextLine();
        System.out.print("가입한 비밀번호를 입력하세요 : > ");
        user_pw = s.nextLine();
        login_check=false;
        for(int i=0;i<user.length;i++){
            if(user_id.equals(user[i][0]) &&  user_pw.equals(user[i][1])){
                login_check =true;
                index = i;
                System.out.println("=====회원정보=====");
                System.out.println("아이디 : "+user[i][0]);
                System.out.println("이름 : "+user[i][2]);
                System.out.println("생년월일 : "+user[i][3]);
            }
        }
        return login_check;
    }

}//class