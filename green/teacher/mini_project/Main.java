import java.lang.reflect.Member;
import java.util.List;
import java.util.Scanner;

import data.PostComment;
import service.BoardService;
import service.MemberService;

public class Main {
    private static Scanner scan = new Scanner(System.in);
    private static MemberService mService = MemberService.getInstance();
    private static BoardService bService = BoardService.getInstance();
    public static void main(String[] args) {
        while(true) {
            Boolean isLogin = mService.getLoginUser() != null;
            bService.showPostList();
            showMainMenu();
            Integer sel = scan.nextInt();
            scan.nextLine();
            if(sel == 0) {
                break;
            }
            else if(sel == 1) {
                bService.selectPost();
                while(true) {
                    showPostMenu();
                    sel = scan.nextInt();
                    scan.nextLine();
                    if(sel == 0) {
                        break;
                    }
                    else if(sel == 1) {
                        if(isLogin)
                            bService.addPostComment();
                            break;
                    }
                    else if(sel == 2) {
                        if(isLogin)
                            bService.updatePost();
                            System.out.println("엔터키를 눌러 진행하십시오.");
                            scan.nextLine();
                            break;
                    }
                    else if(sel == 3) {
                        if(isLogin)
                            bService.deletePost();
                            System.out.println("엔터키를 눌러 진행하십시오.");
                            scan.nextLine();
                            break;
                    }
                }
            }
            else if(sel == 2) {
                if(isLogin) {
                    bService.addPost();
                }
                else {
                    mService.memberJoin();
                }
            }
            else if(sel == 3){
                if(isLogin) {
                    mService.logout();
                }
                else {
                    mService.login();
                }
            }
            else if(sel == 4) {
                if(isLogin){
                    while(true) {
                        mService.showLoginUserInfo();
                        System.out.print("1. 비밀번호 변경 / 2. 닉네임 변경 / 0. 이전으로 : ");
                        sel = scan.nextInt();
                        if(sel == 0) {
                            break;
                        }
                        else if(sel == 1) {
                            mService.changeLoginUserPassword();
                        }
                        else if(sel == 2) {
                            mService.changeLoginUserNickname();
                        }
                    }
                }
            }
            else if(sel == 5) {
                if(isLogin) {
                    while(true) {
                        List<PostComment> list = bService.getUserComments(mService.getLoginUserId());
                        if(list.size() == 0) {
                            System.out.println("등록한 댓글이 없습니다.");
                        }
                        for(PostComment pc : list) {
                            System.out.println(pc.getPc_no()+" : "+pc);
                        }
                        System.out.print("1. 댓글 삭제 / 0. 이전으로");
                        sel = scan.nextInt();
                        scan.nextLine();
                        if(sel == 0) {
                            break;
                        }
                        else if(sel == 1) {
                            bService.removeComment();
                        }
                    }

                }
            }
        }
    }
    public static void showMainMenu() {
        if(mService.getLoginUser() == null) {
            System.out.print("1. 글 상세 조회 / 2. 회원가입 / 3. 로그인 / 0.종료 : ");
        }
        else {
            System.out.print("1. 글 상세 조회 / 2. 글쓰기 / 3. 로그아웃 / 4. 내 정보 관리 / 5. 댓글 관리 / 0.종료 : ");
        }
    }
    public static void showPostMenu() {
        MemberService mService = MemberService.getInstance();
        if(mService.getLoginUser() == null) {
            System.out.print("0. 이전으로 : ");
        }
        else {
            System.out.print("1. 댓글 쓰기 / 2. 글 수정 / 3. 글 삭제 / 0. 이전으로 : ");
        }
    }
    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
    }
}