package JAVA_221027;

import java.util.Scanner;
public class Ex01_Method2 {
    final static int MAX_VALUE = 10;
    static String[] member_id = new String[MAX_VALUE];
    static String[] member_pwd = new String[MAX_VALUE];
    static String[] member_name = new String[MAX_VALUE];
    static String[] member_birth = new String[MAX_VALUE];
    static int next_index = 0;
    public static boolean checkMember(){
        Scanner s = new Scanner(System.in);
        System.out.print("아이디 : ");
        String login_id = s.nextLine();
        System.out.print("비밀번호 : ");
        String login_pwd = s.nextLine();
        boolean loginStatus = false;
        for(int i=0;i<MAX_VALUE;i++){
            if(loginStatus=login_id.equals(member_id[i]) && login_pwd.equals(member_pwd[i])){ 
                System.out.println("==인증 성공==");
                System.out.println("아이디 : "+member_id[i]);
                System.out.println("이름: "+member_name[i]);
                System.out.println("생년월일 : "+member_birth[i]);
                break;
            }
        }
        return loginStatus;
    }
    public static void makeDummyDate(int num){
        if(num<0){
            
            return; //음수가 입력되면 실행안함
        }
        else if(num>MAX_VALUE){
            num=MAX_VALUE;
        }
        for(int i=0;i<num;i++){
            member_id[i] = "member"+i;
            member_pwd[i] = "123456";
            member_name [i] = "사용자";
            member_birth[i] = "20221027";
        } //더미값넣기
        next_index=num;
    }
    public static String inputMemberInfo(){
        Scanner s = new Scanner(System.in);
        System.out.print("아이디(6자이상) : ");
        String id;
        while(true){
            id = s.nextLine();
            if(id.length()<6) {
                System.out.print("아이디는 6자리 이상이어야합니다. 다시 입력해주세요 ");
                continue;
            }
            boolean isDuplicate = false;
            for(int i=0;i<MAX_VALUE;i++){
                if(id.equals(member_id[i])){
                    System.out.print("이미 가입된 아이디 입니다. 다시입력해주세요");
                    isDuplicate=true;
                }
            }
            if(!isDuplicate) break;
        }
        System.out.print("비밀번호(6자이상) : ");
        String pwd;
        while(true){
            pwd = s.nextLine();
            if(pwd.length()<6) {
                System.out.print("비밀번호는 6자리 이상이어야합니다. 다시 입력해주세요 ");
                continue;
            }else {
                break;
            }
        }
        System.out.print("이름 : ");
        String name = s.nextLine();
        System.out.print("생년월일(8자리) : ");
        String birth;
        while(true){
            birth = s.nextLine();
            if(birth.length()!=8) {
                System.out.print("생년월일은 8자리로 입력하세요. 다시 입력해주세요 ");
                continue;
            }else {
                break;
            }
        }
        return id+","+pwd+","+name+","+birth;
    }
    public static void main(String[] args) {
        //1차원배열로 진행, 재차입력요구까지 구현
        Scanner  s = new Scanner(System.in);

        makeDummyDate(5);

        while(true){
            System.out.print("1.회원가입, 2.로그인, 3.회원정보 수정, 4.회원탈퇴, 5.회원정보조회, 0.종료 : > ");
            int sel = s.nextInt();
            if(sel == 0) {
                System.out.println("종료합니다.");
                s.close();
                return;
            }
            s.nextLine();

            switch(sel){
                case 1 :
                    if(next_index==MAX_VALUE){
                        System.out.println("더 이상 가입불가능합니다.");
                        break;
                    }
                    System.out.println("=====회원정보 등록=====");
                    String input_value = inputMemberInfo();
                    member_id[next_index] = input_value.split(",")[0];
                    member_pwd[next_index] = input_value.split(",")[1];
                    member_name[next_index] = input_value.split(",")[2];
                    member_birth[next_index] = input_value.split(",")[3];
                    next_index++;
                    System.out.println("==회원등록 완료==");
                    break;
                case 2 :
                    System.out.println("==로그인==");
                    boolean loginStatus = checkMember();
                    if(!loginStatus){
                        System.out.println("로그인 정보가 잘못되었습니다");
                    }
                    break;
                case 3 :
                    System.out.println("==정보수정==");
                    System.out.print("아이디 : ");
                    // login_id = s.nextLine();
                    // System.out.print("비밀번호 : ");
                    // login_pwd = s.nextLine();
                    // loginStatus = false;
                    // int moidfy_index=0;
                    // for(int i=0;i<MAX_VALUE;i++){
                    //     if(loginStatus=login_id.equals(member_id[i]) && login_pwd.equals(member_pwd[i])){ 
                    //         System.out.println("==기존정보==");
                    //         System.out.println("아이디 : "+member_id[i]);
                    //         System.out.println("이름: "+member_name[i]);
                    //         System.out.println("생년월일 : "+member_birth[i]);
                    //         moidfy_index=i;
                    //         break;
                    //     }
                    // }

                    loginStatus = checkMember();
                    if(!loginStatus){
                        System.out.println("로그인 정보가 잘못되었습니다");
                        break;
                    }
                    System.out.println("====등록된 정보 수정====");
                    input_value = inputMemberInfo();
                    // System.out.print("수정하시겠습니까? 1:예. 0:아니오.> ");
                    // int confirm =s.nextInt();
                    // if(confirm==1){
                    //     member_id[moidfy_index] = input_value.split(",")[0];
                    //     member_pwd[moidfy_index] = input_value.split(",")[1];
                    //     member_name[moidfy_index] = input_value.split(",")[2];
                    //     member_birth[moidfy_index] = input_value.split(",")[3];
                    //     System.out.println("==회원 정보 수정 완료==");
                    // }
                    // else {
                    //     System.out.println("정보수정이 취소되었습니다");
                    // }
                    break;
                case 4 :
                    System.out.println("==로그인==");
                    // System.out.print("아이디 : ");
                    // login_id = s.nextLine();
                    // System.out.print("비밀번호 : ");
                    // login_pwd = s.nextLine();
                    // loginStatus = false;
                    // int del_index =0;
                    // for(int i=0;i<MAX_VALUE;i++){
                    //     if(loginStatus=login_id.equals(member_id[i]) && login_pwd.equals(member_pwd[i])){ 
                    //         System.out.println("==로그인 성공==");
                    //         System.out.println("아이디 : "+member_id[i]);
                    //         System.out.println("이름: "+member_name[i]);
                    //         System.out.println("생년월일 : "+member_birth[i]);
                    //         del_index=i;
                    //         break;
                    //     }
                    // }
                    loginStatus = checkMember();
                    if(!loginStatus){
                        System.out.println("로그인 정보가 잘못되었습니다");
                        break;
                    }
                    System.out.print("탈퇴하시겠습니까? 1:예. 0:아니오.> ");
                    // confirm =s.nextInt();
                    // if(confirm==1){
                    //     member_id[del_index] = null;
                    //     member_pwd[del_index] = null;
                    //     member_name[del_index] = null;
                    //     member_birth[del_index] = null;
                    //     System.out.println("==회원 탈퇴 완료==");

                        String[] temp1 = new String[MAX_VALUE];
                        String[] temp2 = new String[MAX_VALUE];
                        String[] temp3 = new String[MAX_VALUE];
                        String[] temp4 = new String[MAX_VALUE];
                        for(int i=0;i<MAX_VALUE;i++){
                            temp1[i] = member_id[i]; //배열복사
                            temp2[i] = member_pwd[i]; //배열복사
                            temp3[i] = member_name[i]; //배열복사
                            temp4[i] = member_birth[i]; //배열복사
                        }
                        for(int i=0;i<MAX_VALUE;i++){
                            member_id[i]=null;
                            member_pwd[i]=null;
                            member_name[i]=null;
                            member_birth[i]=null;
                        }
                        int n =0;
                        int n2=0;
                        while(n<MAX_VALUE){
                            if(temp1[n]!=null){
                                member_id[n2]=temp1[n];
                                member_pwd[n2]=temp2[n];
                                member_name[n2]=temp3[n];
                                member_birth[n2]=temp4[n];
                                n2++;
                            }
                            n++; //만약 temp[i]가 null이라면, n2는 증가하지 않아서 한자리씩 땡겨짐.
                        }
                        next_index--;
                    // }
                    // else {
                    //     System.out.println("회원탈퇴가 취소되었습니다");
                    // }
                    break;
                case 5 :
                for(int i=0;i<MAX_VALUE;i++){
                    if(member_id[i]!=null){
                            System.out.println("===회원정보===");
                            System.out.println("아이디 : "+member_id[i]);
                            System.out.println("생년월일 : "+member_pwd[i]);
                            System.out.println("비밀번호 : "+member_birth[i]);
                        }
                    }
                    break;
                default : 
                    System.out.println("잘못된 메뉴번호입니다.");
            }
        }
    }
}
