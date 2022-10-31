package JAVA_221026;

import java.util.Scanner;

public class EX01ver3 {
    public static void main(String[] args) {
        final int MAX_MOMBER = 100;
        String user_id = "";
        String user_pw = "";
        String user_name = "";
        String user_birth = "";        
        String user[][] = new String[MAX_MOMBER][4];
        int index = 0;
        Scanner s = new Scanner(System.in);
        int input=0;
        while(true){
            System.out.print("1.회원가입, 2.로그인, 3.회원정보 수정, 4.회원탈퇴, 5.회원정보조회, 0.종료 : > ");
            int sel = s.nextInt();
            s.nextLine();
            switch(sel){
                case 1: //회원가입
                    // 아이디, 비번 6자리 이상. 미만이면 실패
                    for(index=0;index<user.length;index++){
                        if(user[index][0] == null){
                            break;
                        }
                    }
                    if(index==user.length){
                        System.out.println("허용 가입인원수를 초과하였습니다. 더 이상 등록할 수 없습니다. 관리자에게 문의하십시오.");
                        break;
                    }
                    System.out.print("아이디를 입력하세요(6자리 이상) : > ");
                    user_id=s.nextLine();
                    if(user_id.length()<6){
                        System.out.println("아이디가 6자리 미만입니다. 처음부터 다시 시도해주세요");
                        break;
                    }
                    boolean id_check = true;
                    for(int i=0;i<user.length;i++){
                        if(user[i][0]==null){
                            continue;
                        }else if(user[i][0].equals(user_id)){
                            System.out.println("이미 등록된 아이디입니다. 처음부터 다시 시도해주세요");
                            id_check = false;
                            break;
                        }
                    }
                    if(id_check){
                        System.out.print("비밀번호를 입력하세요(6자리 이상) : > ");
                        user_pw=s.nextLine();
                        if(user_pw.length()<6){
                            System.out.println("비밀번호가 6자리 미만입니다. 처음부터 다시 시도해주세요");
                            break;
                        }
                        System.out.print("이름을 입력하세요 : > ");
                        user_name=s.nextLine();
                        System.out.print("생년월일을 입력하세요(8자리) : > ");
                        user_birth=s.nextLine();
                        if(user_birth.length()!=8){
                            System.out.println("생년월일을 8자리로 입력해주세요. 처음부터 다시 시도해주세요");
                            break;
                        }
                            user[index][0] = user_id; 
                            user[index][1] = user_pw; 
                            user[index][2] = user_name; 
                            user[index][3] = user_birth; 
                        }
                    break;
                case 2:  // 로그인(조회)
                    System.out.print("가입한 아이디를 입력하세요 : > ");
                    user_id = s.nextLine();
                    System.out.print("가입한 비밀번호를 입력하세요 : > ");
                    user_pw = s.nextLine();
                    boolean login_check=false;
                    for(int i=0;i<user.length;i++){
                        if(user_id.equals(user[i][0]) &&  user_pw.equals(user[i][1])){
                            login_check =true;
                            System.out.println("=====회원정보=====");
                            System.out.println("아이디 : "+user[i][0]);
                            System.out.println("이름 : "+user[i][2]);
                            System.out.println("생년월일 : "+user[i][3]);
                        }
                    }
                    if(!login_check){
                        System.out.println("로그인 실패. 아이디와 비밀번호를 확인해주세요");
                    }
                    break;
                case 3:// 회원정보 수정
                    System.out.print("가입한 아이디를 입력하세요 : > ");
                    user_id = s.nextLine();
                    System.out.print("가입한 비밀번호를 입력하세요 : > ");
                    user_pw = s.nextLine();
                    login_check=false;
                    for(int i=0;i<user.length;i++){
                        if(user_id.equals(user[i][0]) &&  user_pw.equals(user[i][1])){
                            login_check =true;
                            System.out.print("변경할 아이디를 입력하세요(6자리 이상) : > ");
                            user_id=s.nextLine();
                            if(user_id.length()<6){
                                System.out.println("아이디가 6자리 미만입니다. 처음부터 다시 시도해주세요");
                                break;
                            }
                            id_check = true;
                            for(int j=0;j<user.length;j++){
                                if(user[i][0]==null && user[i][1]==null) continue;
                                else if(user[j][0].equals(user_id)){
                                    System.out.println("이미 등록된 아이디입니다. 처음부터 다시 시도해주세요");
                                    id_check = false;
                                    break;
                                }
                            }
                            if(id_check){
                                System.out.print("변경할 비밀번호를 입력하세요(6자리 이상) : > ");
                                user_pw=s.nextLine();
                                if(user_pw.length()<6){
                                    System.out.println("비밀번호가 6자리 미만입니다. 처음부터 다시 시도해주세요");
                                    break;
                                }
                                System.out.print("변경할 이름을 입력하세요 : > ");
                                user_name=s.nextLine();
                                System.out.print("생년월일을 입력하세요(8자리) : > ");
                                user_birth=s.nextLine();
                                if(user_birth.length()!=8){
                                    System.out.println("변경할 생년월일을 8자리로 입력해주세요. 처음부터 다시 시도해주세요");
                                    break;
                                }
                                System.out.print("수정하시겠습니까?(1-예. 0-아니오) > ");
                                input = s.nextInt();
                                if(input==1){
                                    user[i][0] = user_id; 
                                    user[i][1] = user_pw; 
                                    user[i][2] = user_name; 
                                    user[i][3] = user_birth; 
                                }
                            }
                        }
                    }
                    if(!login_check){
                        System.out.println("로그인 실패. 아이디와 비밀번호를 확인해주세요");
                    }
                    break;
                case 4: 
                System.out.print("가입한 아이디를 입력하세요 : > ");
                user_id = s.nextLine();
                System.out.print("가입한 비밀번호를 입력하세요 : > ");
                user_pw = s.nextLine();
                login_check=false;
                for(int i=0;i<user.length;i++){
                    if(user[i][0]==null && user[i][1]==null) continue;
                    else if(user[i][0].equals(user_id) && user[i][1].equals(user_pw)){
                        login_check=true;
                        System.out.print("정말 회원탈퇴하시겠습니까?(1-예. 0-아니오) > ");
                        input =s.nextInt();
                        if(input==1){
                                user[i][0] = null;
                                user[i][1] = null;
                                user[i][2] = null;
                                user[i][3] = null;
                            }
                        }
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
}//class
