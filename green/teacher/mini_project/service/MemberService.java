package service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import data.BoardData;
import data.MemberInfo;
import utils.FileManager;

public class MemberService {
    private static Scanner scan = new Scanner(System.in);
    private static MemberService instance;
    private List<MemberInfo> memberList;
    private MemberInfo loginUser;

    private MemberService() {
        this.memberList = new LinkedList<MemberInfo>();
        try { initializeMemberList(); }
        catch(Exception e) { e.printStackTrace(); }
    }

    public static MemberService getInstance() {
        if(instance == null) instance = new MemberService();
        return instance;
    }

    private void initializeMemberList() throws Exception {
        List<String> list = FileManager.loadData(FileManager.MEMBER_PATH);
        for(String str : list) {
            MemberInfo m = new MemberInfo();
            m.parseDataString(str);
            memberList.add(m);
        }
    }

    public MemberInfo getLoginUser() {
        return loginUser;
    }

    public void login() {
        System.out.print("아이디 : ");
        String id = scan.nextLine();
        System.out.print("비밀번호 : ");
        String pwd = scan.nextLine();
        for(MemberInfo m : memberList) {
            if(m.getMi_id().equals(id) && m.getMi_pwd().equals(pwd)) {
                loginUser = m;
                System.out.println("로그인 되었습니다.");
                return;
            }
        }
        System.out.println("잘못된 로그인 정보입니다.");
    }

    public void logout() {
        loginUser = null;
        System.out.println("로그아웃 되었습니다.");
    }

    public void memberJoin() {
        String id = "";
        while(true) {
            System.out.print("아이디 : ");
            id = scan.nextLine();
            if(isDuplicatedId(id)){
                System.out.println("이미 가입된 아이디 입니다.");
            }
            else {
                break;
            }
        }
        System.out.print("비밀번호 : ");
        String pwd = scan.nextLine();
        System.out.print("이름(닉네임) : ");
        String name = scan.nextLine();
        String birth = "";
        while(true) {
            System.out.print("주민등록번호 (- 포함) : ");
            birth = scan.nextLine();
            if(birth.length() != 14) {
                System.out.println("주민등록번호를 올바르게 입력해주세요 (ex:221111-3******)");
            }
            else if(isAlreadyJoined(birth)) {
                System.out.println("이미 가입된 사용자입니다.");
            }
            else {
                break;
            }
        }
        memberList.add(new MemberInfo(id, pwd, name, birth, 1));
        System.out.println("가입 완료되었습니다. (엔터키를 눌러 진행하십시오.)");
        scan.nextLine();

        try { saveMemberDataToFile(); }
        catch(Exception e) { e.printStackTrace(); }
    }

    private Boolean isDuplicatedId(String id) {
        for(MemberInfo m : memberList)
            if(m.getMi_id().equals(id))
                return true;
        return false;
    }

    private Boolean isAlreadyJoined(String birth) {
        for(MemberInfo m : memberList)
            if(m.getMi_birth().equals(birth))
                return true;
        return false;
    }

    private void saveMemberDataToFile() throws Exception {
        List<BoardData> list = new ArrayList<BoardData>();
        for(MemberInfo m : memberList)
            list.add(m);
        FileManager.saveData(FileManager.MEMBER_PATH, list);
    }

    public String getLoginUserId() {
        if(loginUser == null) {
            return null;
        }
        return loginUser.getMi_id();
    }

    public void showLoginUserInfo() {
        if(loginUser != null) {
            System.out.println(loginUser);
        }
    } 
    public void changeLoginUserPassword() {
        if(loginUser != null) {
            System.out.print("기존 비밀번호 : ");
            String oldPwd = scan.nextLine();
            if(!oldPwd.equals(loginUser.getMi_pwd())) {
                System.out.println("비밀번호 오류입니다.");
            }
            else {
                System.out.print("새 비밀번호 : ");
                String newPwd = scan.nextLine();
                loginUser.setMi_pwd(newPwd);
                System.out.println("비밀번호가 변경되었습니다.");
                try { saveMemberDataToFile(); }
                catch(Exception e) {}
            }
            scan.nextLine();
        }
    }

    public void changeLoginUserNickname() {
        if(loginUser != null) {
            System.out.print("바꿀 이름 (기존 - "+loginUser.getMi_name()+") :");
            String name = scan.nextLine();
            if(name.length() < 2) {
                System.out.println("닉네임은 2자 이상으로 입력해주세요.");
            }
            else {
                loginUser.setMi_name(name);
                System.out.println("닉네임이 변경되었습니다.");
                try { saveMemberDataToFile(); }
                catch(Exception e) {}
            }
        }
        scan.nextLine();
    }
    public void dropMember() {
        if(loginUser != null) {
            System.out.print("회원탈퇴 처리하시겠습니까? (y/n) : ");
            String confirm = scan.nextLine();
            if(confirm.equals("y")) {
                loginUser.setMi_status(4);
            }
        }
    }
}
