package service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import data.BoardData;
import data.MemberInfo;
import utils.FileManager;

public class MemberService {
    private static Scanner scan = new Scanner(System.in); // 입력처리를 위한 스캐너
    private static MemberService instance; // 회원서비스 객체
    private List<MemberInfo> memberList; // 전체 회원 목록을 담기위한 리스트
    private MemberInfo loginUser; // 현재 로그인한 사용자의 정보

    private MemberService() {
        // 객체 생성 시 리스트도 함께 생성 후
        this.memberList = new LinkedList<MemberInfo>();
        // 파일로부터 사용자 정보를 가져와서 리스트에 추가
        try { initializeMemberList(); } 
        catch(Exception e) { e.printStackTrace(); } // 예외처리
    }
    // 회원관리 서비스 객체를 내어주는 메서드
    // 이 클래스의 객체는 외부에서 생성 할 수 없고
    // 이 메서드를 통해서 객체를 가져올 수 있음
    public static MemberService getInstance() {
        // 객체가 만들어지지 않은 상태라면 생성한다.
        if(instance == null) instance = new MemberService();
        return instance; // MemberService 객체를 내어준다.
    }
    // 파일로부터 사용자 정보를 가져오는 메서드
    private void initializeMemberList() throws Exception {
        // MEMBER_PATH 위치의 파일에 있는 내용을 문자열 목록 형태로 가져온다.
        List<String> list = FileManager.loadData(FileManager.MEMBER_PATH);
        for(String str : list) { // 조회한 문자열 목록을 순차조회
            MemberInfo m = new MemberInfo(); // 사용자 정보 객체 생성
            m.parseDataString(str); // 문자열을 사용자 정보에 맞는 형태로 변환
            memberList.add(m); // 전체 사용자 리스트에 추가
        }
    }
    // 로그인중인 사용자의 정보를 가져오는 기능
    // loginUser가 접근제한이 private이므로 필요한 기능
    public MemberInfo getLoginUser() {
        return loginUser; // loginUser 객체 내보내줌
    }
    // 로그인 기능
    public void login() {
        System.out.print("아이디 : ");
        String id = scan.nextLine(); // 아이디를 입력받는다.
        System.out.print("비밀번호 : ");
        String pwd = scan.nextLine(); // 비밀번호를 입력받는다.
        for(MemberInfo m : memberList) { // 전체 리스트 순차조회
            // 리스트 안의 사용자 정보 중 id와 pwd가 정확히 일치하는 데이터가 있다면
            if(m.getMi_id().equals(id) && m.getMi_pwd().equals(pwd)) {
                loginUser = m; // loginUser에 저장하고
                System.out.println("로그인 되었습니다."); // 메시지 출력
                return; // 종료
            }
        }
        // 리스트의 모든 목록을 조회해도 일치하는 정보가 없을 경우 실패 처리
        System.out.println("잘못된 로그인 정보입니다.");
    }
    // 로그아웃 기능
    public void logout() {
        loginUser = null; // 로그인 사용자의 변수를 null로 세팅
        System.out.println("로그아웃 되었습니다."); // 메시지 출력
    }
    // 회원가입 기능
    public void memberJoin() {
        String id = ""; // 아이디 입력을 위한 변수
        while(true) { // 아이디 입력 무한반복 시작
            System.out.print("아이디 : ");
            id = scan.nextLine(); // 아이디를 입력받는다.
            if(isDuplicatedId(id)){ // 중복아이디 여부 체크
                // 중복일경우 while을 빠져나가지 못하므로, 다시 입력받게 됨
                System.out.println("이미 가입된 아이디 입니다.");
            }
            else {
                // 중복이 아닌 경우 아이디 입력 무한반복을 빠져나감
                break;
            }
        }
        System.out.print("비밀번호 : ");
        String pwd = scan.nextLine(); // 비밀번호 입력
        System.out.print("이름(닉네임) : ");
        String name = scan.nextLine(); // 이름 입력
        String birth = ""; // 주민등록번호 입력을 위한 변수
        while(true) { // 주민등록번호 입력 무한반복 시작
            System.out.print("주민등록번호 (- 포함) : ");
            birth = scan.nextLine(); // 주민등록번호를 입력받는다.
            if(birth.length() != 14) { // -를 포함한 주민등록번호 정보가 14자가 아니라면
                // 오류메시지를 출력, while문을 빠져나가지 못하므로 재차 입력 요청이 될 것이다.
                System.out.println("주민등록번호를 올바르게 입력해주세요 (ex:221111-3******)");
            }
            else if(isAlreadyJoined(birth)) { // 입력한 주민등록번호가 이미 가입상태라면
                // 오류메시지를 출력, while문을 빠져나가지 못하므로 재차 입력 요청이 될 것이다.
                System.out.println("이미 가입된 사용자입니다.");
            }
            else {
                // 14자 이고, 가입한 이력이 없는 주민등록번호라면
                // 주민등록번호 입력 무한반복을 빠져나간다.
                break;
            }
        }
        // 입력한 정보를 전체 회원 리스트에 추가한다.
        memberList.add(new MemberInfo(id, pwd, name, birth, 1));
        // 메시지를 출력하고
        System.out.println("가입 완료되었습니다. (엔터키를 눌러 진행하십시오.)");
        scan.nextLine(); // 사용자가 엔터키를 입력할 때 까지 작동을 일시중지하는 역할

        try { saveMemberDataToFile(); } // 정보를 파일로 저장
        catch(Exception e) { e.printStackTrace(); } // 예외처리
    }
    // 아이디 중복 검사
    private Boolean isDuplicatedId(String id) {
        for(MemberInfo m : memberList) // 회원리스트 순차조회
            if(m.getMi_id().equals(id)) // 회원리스트 안의 회원객체의 아이디가 파라미터 id와 같다면
                return true; // true(참) 리턴 - 중복발생
        // 전체 조회가 끝나고 여기에 도달하면
        // 중복정보가 없다는 의미이기때문에 false(거짓) 리턴 - 중복데이터 없음
        return false;
    }
    // 주민등록번호 중복 검사
    private Boolean isAlreadyJoined(String birth) {
        for(MemberInfo m : memberList) // 회원리스트 순차조회
            if(m.getMi_birth().equals(birth)) // 회원리스트 안의 회원객체의 주민등록번호가 파라미터 birth와 같다면
                return true; // true(참) 리턴 - 중복발생
        // 전체 조회가 끝나고 여기에 도달하면
        // 중복정보가 없다는 의미이기때문에 false(거짓) 리턴 - 중복데이터 없음
        return false;
    }
    // 회원 정보를 파일로 저장하는 기능
    private void saveMemberDataToFile() throws Exception {
        // List<BoardData> 리스트를 생성
        // 이 코드는 인터페이스의 다형성을 이용하여
        // 서로 다른 타입의 객체를 하나의 메서드로 일괄처리 하기위한 작업
        List<BoardData> list = new ArrayList<BoardData>();
        for(MemberInfo m : memberList) // 전체 회원 리스트를 순차조회
            list.add(m);// List<BoardData> 타입의 리스트에 추가
        // MEMBER_PATH위치의 파일에 리스트를 기록함.
        FileManager.saveData(FileManager.MEMBER_PATH, list);
    }
    // 현재 로그인 한 사용자의 ID를 가져오는 기능
    public String getLoginUserId() {
        if(loginUser == null) { // 로그인 한 사용자가 없다면
            return null; // null 출력
        }
        return loginUser.getMi_id(); // loginUser의 id출력
    }
    // 현재 로그인한 사용자의 정보 출력 기능
    public void showLoginUserInfo() {
        if(loginUser != null) { // 로그인한 사용자가 있다면,
            System.out.println(loginUser); // 정보 출력
        }
    }
    // 비밀번호 변경 기능
    public void changeLoginUserPassword() {
        if(loginUser != null) { // 로그인한 사용자가 있다면 실행
            System.out.print("기존 비밀번호 : ");
            String oldPwd = scan.nextLine(); // 기존 비밀번호를 입력받는다.
            if(!oldPwd.equals(loginUser.getMi_pwd())) { // 입력한 비밀번호와 기존비밀번호가 일치하지 않으면
                System.out.println("비밀번호 오류입니다."); // 오류처리
            }
            else { // 비밀번호가 일치한다면
                System.out.print("새 비밀번호 : ");
                String newPwd = scan.nextLine(); // 새 비밀번호를 입력받고
                loginUser.setMi_pwd(newPwd); // 로그인 사용자 객체에 저장
                System.out.println("비밀번호가 변경되었습니다."); // 메시지 출력
                try { saveMemberDataToFile(); } // 파일에 변경사항 기록
                catch(Exception e) {}
            }
            scan.nextLine(); // 사용자가 엔터를 입력하기 전 까지 프로그램 일시중지를 위한 nextLine
        }
    }
    // 사용자 이름(nickname) 변경 기능
    public void changeLoginUserNickname() {
        if(loginUser != null) { // 로그인 사용자가 있을 때 실행
            System.out.print("바꿀 이름 (기존 - "+loginUser.getMi_name()+") :");
            String name = scan.nextLine(); // 닉네임 입력받기
            if(name.length() < 2) { // 2자 이상이 아닐경우
                System.out.println("닉네임은 2자 이상으로 입력해주세요."); // 오류메시지
            }
            else { // 2자 이상일 경우
                loginUser.setMi_name(name); // loginUser 객체에 name 변경
                System.out.println("닉네임이 변경되었습니다.");
                try { saveMemberDataToFile(); } // 변경 정보 파일에 저장
                catch(Exception e) {}
            }
        }
        scan.nextLine(); // 사용자가 엔터를 입력하기 전 까지 프로그램 일시중지를 위한 nextLine
    }
    // 사용자 삭제 기능 (탈퇴)
    public void dropMember() {
        if(loginUser != null) { // 로그인 중 일 때 실행함
            System.out.print("회원탈퇴 처리하시겠습니까? (y/n) : ");
            String confirm = scan.nextLine(); // 입력받음
            if(confirm.equals("y")) { // y 입력 시
                loginUser.setMi_status(4); // 사용자의 상태를 4(탈퇴)로 설정
            }
        }
        try { saveMemberDataToFile(); } // 변경 정보 파일에 저장
        catch(Exception e) {}
    }
}
