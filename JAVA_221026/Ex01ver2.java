package JAVA_221026;

import java.util.Scanner;

public class Ex01ver2 {
    public static void main(String[] args) {
        String user_id = "";
        String user_pw = "";
        String user_name = "";
        String user_birth = "";        
        String arr_id[] = new String[10];
        String arr_pw[] = new String[10];
        String arr_name[] = new String[10];
        String arr_birth[] = new String[10];
        int index = 0;
        for(int i=0;i<arr_id.length;i++){
            arr_id[i] = "";
            arr_pw[i] = "";
        }
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.print("1.회원가입, 2.로그인, 3.회원정보 수정, 0.종료 : > ");
            int sel = s.nextInt();
            s.nextLine();
            switch(sel){
                case 1: //회원가입
                    if(index>=arr_id.length){
                        System.out.println("허용 가입인원수를 초과하였습니다. 더이상 등록할 수 없습니다.");
                    }
                    System.out.print("아이디를 입력하세요(6자리 이상) : > ");
                    user_id=s.nextLine();
                    if(user_id.length()<6){
                        System.out.println("아이디가 6자리 미만입니다. 처음부터 다시 시도해주세요");
                        break;
                    }
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
                    boolean id_check = true;
                    for(int i=0;i<arr_id.length;i++){
                        if(arr_id[i].equals(user_id)){
                            System.out.println("이미 등록된 아이디입니다. 처음부터 다시 시도해주세요");
                            id_check = false;
                            break;
                        }
                    }
                    if(id_check){
                        arr_id[index] = user_id; 
                        arr_pw[index] = user_pw; 
                        arr_name[index] = user_name; 
                        arr_birth[index] = user_birth; 
                        index++;
                    }
                    break;
                case 2:  // 로그인(조회)
                    System.out.print("가입한 아이디를 입력하세요 : > ");
                    user_id = s.nextLine();
                    System.out.print("가입한 비밀번호를 입력하세요 : > ");
                    user_pw = s.nextLine();
                    boolean login_check=false;
                    for(int i=0;i<arr_id.length;i++){
                        if(user_id.equals(arr_id[i]) &&  user_pw.equals(arr_pw[i])){
                            login_check =true;
                            System.out.println("=====회원정보=====");
                            System.out.println("아이디 : "+arr_id[i]);
                            System.out.println("이름 : "+arr_name[i]);
                            System.out.println("생년월일 : "+arr_birth[i]);
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
                    for(int i=0;i<arr_id.length;i++){
                        if(user_id.equals(arr_id[i]) &&  user_pw.equals(arr_pw[i])){
                            login_check =true;
                            System.out.print("변경할 아이디를 입력하세요(6자리 이상) : > ");
                            user_id=s.nextLine();
                            if(user_id.length()<6){
                                System.out.println("아이디가 6자리 미만입니다. 처음부터 다시 시도해주세요");
                                break;
                            }
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
                            id_check = true;
                            for(int j=0;j<arr_id.length;j++){
                                if(arr_id[j].equals(user_id)){
                                    System.out.println("이미 등록된 아이디입니다. 처음부터 다시 시도해주세요");
                                    id_check = false;
                                    break;
                                }
                            }
                            if(id_check){
                                System.out.println("수정하시겠습니까?(1-예. 0-아니오) > ");
                                int input = s.nextInt();
                                if(input==1){
                                    arr_id[i] = user_id; 
                                    arr_pw[i] = user_pw; 
                                    arr_name[i] = user_name; 
                                    arr_birth[i] = user_birth; 
                                }
                            }
                        }
                    }
                    if(!login_check){
                        System.out.println("로그인 실패. 아이디와 비밀번호를 확인해주세요");
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
