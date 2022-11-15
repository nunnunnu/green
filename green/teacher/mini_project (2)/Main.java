import java.util.List;
import java.util.Scanner;

import data.PostComment;
import service.BoardService;
import service.MemberService;

public class Main {
    private static Scanner scan = new Scanner(System.in); // 입력처리를 위한 스캐너 생성
    private static MemberService mService = MemberService.getInstance(); // 회원 관련 기능 객체 로드
    private static BoardService bService = BoardService.getInstance(); // 게시판 관련 기능 객체 로드
    public static void main(String[] args) {
        while(true) { // 무한반복 시작
            Boolean isLogin = mService.getLoginUser() != null; // 로그인된 사용자가 null이 아닌가?(로그인 상태인가?)
            bService.showPostList(); // 글 목록 보여주기
            showMainMenu(); // 메뉴 보여주기
            Integer sel = scan.nextInt(); // 번호 입력 받기
            scan.nextLine(); // 입력 스트림 비우기
            if(sel == 0) { // 0번 선택시
                break; // 무한반복 빠져나옴
            }
            else if(sel == 1) { // 1번 선택시
                bService.selectPost(); // 게시글 1개를 선택하는 기능 실행
                while(true) { // 무한반복 시작
                    showPostMenu(); // 글에 대한 메뉴 표시
                    sel = scan.nextInt(); // 선택 입력 받기
                    scan.nextLine(); // 입력 스트림 비우기
                    if(sel == 0) { // 입력이 0번이라면
                        break; // 글 메뉴 무한반복을 빠져나감
                    }
                    else if(sel == 1) { // 선택이 1번이라면
                        if(isLogin) // 현재 로그인 중이라면
                            bService.addPostComment(); // 댓글 추가 기능을 실행하고
                            break; // 댓글 추가 기능 실행이 완료되었으면 글 메뉴 무한반복 빠져나가기
                    }
                    else if(sel == 2) { // 선택이 2번이라면
                        if(isLogin) // 현재 로그인 중이라면
                            bService.updatePost(); // 글 수정 기능을 실행
                            System.out.println("엔터키를 눌러 진행하십시오.");
                            scan.nextLine(); // 그냥 넘어가면 훅 넘어가므로 엔터 눌러서 다음으로 넘어가게 함
                            break; // 글 메뉴 무한반복 종료
                    }
                    else if(sel == 3) { // 선택이 3번이라면
                        if(isLogin) // 로그인 상태라면
                            bService.deletePost(); // 글 삭제 기능을 실행
                            System.out.println("엔터키를 눌러 진행하십시오.");
                            scan.nextLine(); // 그냥 넘어가면 훅 넘어가므로 엔터 눌러서 다음으로 넘어가게 함
                            break; // 글 메뉴 무한반복 종료
                    }
                }
            }
            else if(sel == 2) { // 메인메뉴 선택이 2번이라면
                if(isLogin) { // 로그인 중이라면
                    bService.addPost(); // 글 쓰기 기능 실행
                }
                else { // 로그인이 아니라면
                    mService.memberJoin(); // 회원가입 기능 실행
                }
            }
            else if(sel == 3){ // 메인메뉴 선택이 3번이라면
                if(isLogin) { // 로그인 중이라면
                    mService.logout(); // 로그아웃 기능 실행
                }
                else { // 로그인 중이 아니라면
                    mService.login(); // 로그인 기능 실행
                }
            }
            else if(sel == 4) { // 메인메뉴 선택이 4번이라면
                if(isLogin){ // 로그인 중이라면
                    while(true) { // 무한반복 시작
                        mService.showLoginUserInfo(); // 로그인 사용자 정보 출력
                        System.out.print("1. 비밀번호 변경 / 2. 닉네임 변경 / 0. 이전으로 : "); // 메뉴 선택 문자열 표시
                        sel = scan.nextInt(); // 입력 받기
                        scan.nextLine(); // 입력 스트림 비우기
                        if(sel == 0) { // 0번 선택이라면,
                            break; // 사용자 정보 메뉴 무한반복 빠져나감
                        }
                        else if(sel == 1) { // 1번 선택이라면
                            mService.changeLoginUserPassword(); // 비밀번호 변경 기능 실행
                        }
                        else if(sel == 2) { // 2번 선택이라면
                            mService.changeLoginUserNickname(); // 닉네임(이름) 변경 기능 실행
                        }
                    }
                }
            }
            else if(sel == 5) { // 메인메뉴 선택이 5번이라면
                if(isLogin) { // 로그인 중이라면
                    while(true) { // 무한반복 시작
                        // 로그인 한 사용자의 댓글 목록 가져오기
                        List<PostComment> list = bService.getUserComments(mService.getLoginUserId());
                        if(list.size() == 0) { // 댓글목록이 0개라면
                            System.out.println("등록한 댓글이 없습니다."); // 없다고 표시
                        }
                        for(PostComment pc : list) { // 가져온 사용자 댓글목록을 순차조회
                            System.out.println(pc.getPc_no()+" : "+pc); // 댓글 번호와 댓글 상세정보 출력
                        }
                        System.out.print("1. 댓글 삭제 / 0. 이전으로"); // 내 댓글 기능의 메뉴 문자열 출력
                        sel = scan.nextInt(); // 선택 입력받음
                        scan.nextLine(); // 입력 스트림 비우기
                        if(sel == 0) { // 0이 입력되었다면
                            break; // 내 댓글 기능의 무한반복 빠져나감
                        }
                        else if(sel == 1) { // 1번이 입력되었다면
                            bService.removeComment(); // 댓글 삭제 기능 실행
                        }
                    }

                }
            }
        }
    }
    public static void showMainMenu() { // 메인 메뉴를 보여주는 기능
        if(mService.getLoginUser() == null) { // 로그인 중이 아니라면 표시할 메뉴
            System.out.print("1. 글 상세 조회 / 2. 회원가입 / 3. 로그인 / 0.종료 : ");
        }
        else { // 로그인 중이라면 표시할 메뉴
            System.out.print("1. 글 상세 조회 / 2. 글쓰기 / 3. 로그아웃 / 4. 내 정보 관리 / 5. 댓글 관리 / 0.종료 : ");
        }
    }
    public static void showPostMenu() { // 글 상세보기에서 표시할 메뉴
        // 회원 정보 관리 서비스 객체 가져오기
        MemberService mService = MemberService.getInstance();
        // 로그인 중이 아니라면 표시할 메뉴
        if(mService.getLoginUser() == null) {
            System.out.print("0. 이전으로 : ");
        }
        else { // 로그인 중이라면 표시할 메뉴
            System.out.print("1. 댓글 쓰기 / 2. 글 수정 / 3. 글 삭제 / 0. 이전으로 : ");
        }
    }
    public static void clearConsole() { // 화면 지우기 (사용되지 않음)
        System.out.print("\033[H\033[2J");
    }
}