package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import data.BoardData;
import data.PostComment;
import data.PostInfo;
import utils.FileManager;

public class BoardService {
    private static Scanner scan = new Scanner(System.in); // 입력처리를 위한 스캐너 변수 생성
    private static BoardService instance = null; // 게시판 서비스 객체

    public List<PostInfo> postList; // 글 정보를 담고 있을 리스트
    public List<PostComment> postCommentList; // 댓글 정보를 담고 있을 리스트
    public PostInfo currentPost; // 상세보기 선택된 글 객체
    public Integer nextPostNo; // 다음에 추가될 글의 번호
    public Integer nextCommentNo; // 다음에 추가될 댓글의 번호

    private BoardService() { // 생성자
        postList = new LinkedList<PostInfo>(); // 글 목록 리스트 객체 생성
        postCommentList = new LinkedList<PostComment>(); // 댓글 목록 리스트 객체 생성
        try { // 아래 두 줄은 예외를 발생시키기 때문에 예외처리
            initializeBoardPosts(); // 글 목록을 파일로 부터 가져오는 기능
            initializeBoardComments(); // 댓글 목록을 파일로 부터 가져오는 기능
        }
        catch(Exception e) { e.printStackTrace(); }
    }
    // 이 클래스의 객체는 외부에서 생성 할 수 없고
    // 이 메서드를 통해서 객체를 가져올 수 있음
    public static BoardService getInstance() { 
        if(instance == null) instance = new BoardService(); // 아직 객체가 생성되기 전이라면 생성한다.
        return instance; // BoardService 객체를 내어보내준다.
    }

    private void initializeBoardPosts() throws Exception { // 게시글 초기화 메서드
        List<String> list = FileManager.loadData(FileManager.POST_PATH); // 파일로부터 데이터를 가져온다.
        for(String str : list) { // 가져온 문자열배열을 순차조회하여
            PostInfo p = new PostInfo(); // 글 정보 객체를 만들어서
            p.parseDataString(str); // 문자열로 이루어진 글 정보를 객체 형태에 맞게 변환해주는 기능(파싱) 실행
            postList.add(p); // 글 정보를 담고있는 리스트에 추가
        }
        if(postList.size() == 0) // 글 정보 리스트가 비어있다면
            nextPostNo = 1; // 다음 추가될 글의 번호를 1번으로 세팅
        else // 글 정보 리스트에 한 개 이상이라도 있다면
            // 다음 추가될 글의 번호를 리스트의 마지막에 있는 데이터의 글번호 +1로 설정한다.
            nextPostNo = postList.get(postList.size()-1).getPost_no() + 1;
    }

    private void initializeBoardComments() throws Exception { // 댓글 정보를 파일로부터 불러오는 메서드
        List<String> list = FileManager.loadData(FileManager.COMMENT_PATH); // 파일로부터 댓글정보 문자열을 불러옴
        for(String str : list) { // 문자열 배열을 순차조회
            PostComment pc = new PostComment(); // 댓글정보 객체를 하나 만들고
            pc.parseDataString(str); // 조회한 문자열을 댓글정보의 구조에 맞게 변환(데이터 파싱)
            postCommentList.add(pc); // 변환된 데이터를 댓글 리스트에 추가
        }
        if(postCommentList.size() == 0) // 댓글 정보가 하나도 없다면
            nextCommentNo = 1; // 다음에 추가될 댓글의 번호는 1번으로 설정
        else
            // 댓글 정보가 하나 이상 있다면
            // 리스트 마지막에 있는 댓글의 번호 + 1이 다음 추가될 댓글의 번호
            nextCommentNo = postCommentList.get(postCommentList.size()-1).getPc_no() + 1;
    }

    public void showPostList() { // 글 목록을 보여주는 기능
        System.out.printf("%-5s %-20s %-20s %-16s\n", "No", "Title", "RegDt", "Author");
        for(PostInfo p : postList) { // 글 정보 리스트를 순차조회
            if(p.getPost_status() != 1) continue; // 글 객체의 status값이 1이 아니라면 표시안함
            p.showPostSummary(); // 글 정보 출력
        }
        currentPost = null; // 현재 보고있던 글의 정보를 제거 (목록으로 되돌아왔기 때문)
    }

    public void addPost() { // 글 정보 추가
        System.out.print("제목 : ");
        String title = scan.nextLine(); // 제목 입력
        System.out.println("내용 입력 ==========");
        String content = scan.nextLine(); // 내용 입력
        System.out.print("등록하시겠습니까? (y/n) : ");
        String confirm = scan.nextLine(); // 등록 확인
        if(confirm.equalsIgnoreCase("y")) { // y를 입력했다면
            MemberService mService = MemberService.getInstance(); // 회원관리 서비스 객체 가져옴
            // 글 정보를 추가하고
            postList.add(new PostInfo(nextPostNo, title, content, mService.getLoginUserId(), 1));
            // 다음 추가할 글의 번호를 1 늘림
            nextPostNo++;
            try { savePostListToFile(); } // 변경사항을 파일로 저장
            catch(Exception e) { e.printStackTrace(); }
        }
        else { // y입력이 아니라면 메시지만 표시하고 아무것도 안함
            System.out.println("글 등록이 취소되었습니다. (계속하려면 엔터를 누르세요)");
            scan.nextLine();
        }
    }
    
    public void updatePost() { // 글 정보 수정
        MemberService mService = MemberService.getInstance(); // MemberService 객체 가져오기
        if(mService.getLoginUser() == null) { // 로그인 사용자가 없다면
            System.out.println("로그인 후 사용할 수 있습니다."); // 로그인 후 사용할 수 있다.
            return; // 종료
        }
        // 수정하려는 글의 작성자와 현재 로그인한 사용자가 다르다면
        if(!currentPost.getPost_author().equals(mService.getLoginUser().getMi_id())) {
            System.out.println("작성자만 글을 수정할 수 있습니다."); // 메시지 출력 후
            return; // 종료
        }
        if(currentPost.getPost_status() != 1) { // 글의 상태가 1(정상상태)이 아니라면
            System.out.println("삭제되었거나 블라인드 처리된 글은 수정할 수 없습니다."); // 메시지 출력
            return; // 종료
        }
        System.out.print("제목 : ");
        String title = scan.nextLine(); // 글 제목을 입력받는다.
        // 입력한 글 제목이 빈 문자열이라면, 기존의 글 제목으로 title변수를 설정
        // (글 제목을 입력하지 않은 경우는, 수정하지 않는 것으로 간주)
        if(title.equals("")) title = currentPost.getPost_title();
        System.out.print("글 내용 : ");
        String content = scan.nextLine(); // 글 내용을 입력받는다.
        // 입력한 글 내용이 빈 문자열이라면, 기존의 글 내용으로 content변수를 설정
        // (글 내용을 입력하지 않은 경우난, 수정하지 않는 것으로 간주)
        if(content.equals("")) content = currentPost.getPost_content();

        currentPost.setPost_title(title); // 현재 선택 중인 글의 제목을 입력한 제목으로 바꾼다.
        currentPost.setPost_content(content); // 현재 선택중인 글의 내용을 입력한 내용으로 바꾼다.
        currentPost.setPost_mod_dt(new Date()); // 현재 시간으로 수정 시간을 바꾼다.
        System.out.println("글을 수정했습니다."); // 메시지 출력

        try { savePostListToFile(); } // 파일로 저장
        catch(Exception e) { e.printStackTrace(); } // 예외 처리
    }
    
    public void deletePost() { // 글 삭제 기능
        MemberService mService = MemberService.getInstance(); // MemberService 객체 가져오기
        if(mService.getLoginUser() == null) { // 로그인 중이 아니라면
            System.out.println("로그인 후 사용할 수 있습니다."); // 메시지 출력
            return; // 종료
        }
        // 로그인 한 사용자와 글의 작성자가 다르다면
        if(!currentPost.getPost_author().equals(mService.getLoginUser().getMi_id())) {
            System.out.println("작성자만 글을 삭제할 수 있습니다."); // 메시지 출력
            return; // 종료
        }        
        currentPost.setPost_status(2); // 선택 중인 글의 상태를 2(삭제)로 설정
        System.out.println("글을 삭제하였습니다."); // 메시지 출력
        try { savePostListToFile(); } // 파일에 쓰기
        catch(Exception e) { e.printStackTrace(); } // 예외처리
    }
    // 글 선택(상세보기) 기능
    // ** 현재 이 프로그램은 글에 대한 수정 및 삭제, 댓글 추가를 위해
    // ** 반드시 글의 상세정보를 보는 이 기능을 실행 후 수정, 삭제, 댓글 추가 기능을 실행해야함.
    public void selectPost() { 
        System.out.print("글 번호 : ");
        // 글의 번호를 입력받는다 (인덱스가 아니라 PostInfo의 post_no 값)
        Integer sel = scan.nextInt(); 
        scan.nextLine(); // 입력 스트림 비우기
        currentPost = getPost(sel); // 글 번호를 통해 글 검색
        if(currentPost == null) { // 검색 결과가 없다면
            System.out.println("존재하지 않는 글 번호 입니다."); // 없음 메시지 출력
        }
        else if(currentPost.getPost_status() != 1){ // 상태가 1(정상)이 아니라면
            System.out.println("차단되었거나 삭제된 글 입니다."); // 오류 메시지 출력
        }
        else { // 정상 상태라면
            currentPost.showPostDetail(); // 글의 상세 정보를 보여줌
            // 글의 댓글 리스트를 가져옴
            List<PostComment> comments = selectPostComments(currentPost.getPost_no());
            for(PostComment pc : comments) { // 순차조회 반복 시작
                System.out.println(pc); // 댓글 정보 출력 ( PostComment.toString() )
            }
        }
    }
    // 글의 댓글 리스트를 가져오는 기능
    public List<PostComment> selectPostComments(Integer postNo) {
        // 전체 댓글로부터 글의 번호와 일치하는 댓글만 가져오기 위한 새로운 리스트 생성
        List<PostComment> postComments = new LinkedList<PostComment>();
        for(PostComment p : postCommentList) { // 전체 댓글 리스트를 순차조회
            if(p.getPc_post_no() == postNo) { // 댓글 객체의 글 번호와 파라미터의 번호가 일치한다면
                postComments.add(p); // postComments 리스트에 추가한다.
            }
        }
        return postComments; // 걸러진 댓글 리스트를 리턴한다.
    }
    // 글 번호를 통해 전체 글 리스트에서 하나의 글 정보 가져오기 기능
    private PostInfo getPost(Integer post_no) {
        for(PostInfo p : postList) { // 전체 글 리스트를 순차조회
            if(p.getPost_no() == post_no) { // 파라미터 post_no와 같은 객체가 있다면
                return p; // 그 객체를 내어보내준다.
            }
        }
        return null; // 모두 조회하고나서도 글 번호가 같은 객체를 찾지 못하면 null이 리턴
    }
    // 글 목록을 파일로 쓰는 기능
    private void savePostListToFile() throws Exception {
        // List<BoardData> 리스트를 생성
        // 이 코드는 인터페이스의 다형성을 이용하여
        // 서로 다른 타입의 객체를 하나의 메서드로 일괄처리 하기위한 작업
        List<BoardData> list = new ArrayList<BoardData>();
        for(PostInfo p : postList) // 전체 글 리스트를 순차조회
            list.add(p); // List<BoardData> 타입의 리스트에 추가
        // POST_PATH위치의 파일에 리스트를 기록함.
        FileManager.saveData(FileManager.POST_PATH, list); 
    }
    // 댓글 추가 기능
    public void addPostComment() {
        if(currentPost == null) // 현재 선택된 글이 없다면
            return; // 종료
        MemberService mService = MemberService.getInstance(); // MemberService 객체 가져오기
        String id = mService.getLoginUserId(); // 현재 로그인 중인 사용자의 아이디 가져오기
        Integer post_no = currentPost.getPost_no(); // 현재 선택중인 글의 번호 가져오기
        System.out.print("댓글 내용 : ");
        String content = scan.nextLine(); // 댓글 입력 받기
        // 로그인중인 사용자 아이디, 선택중인 글 번호, 입력 내용, 다음댓글 번호 변수들을
        // 댓글 객체로 생성하여 전체 댓글 리스트에 추가
        postCommentList.add(new PostComment(nextCommentNo, post_no, content, id));
        System.out.println("댓글이 추가되었습니다.");
        try { saveCommentDataToFile(); } // 파일에 저장
        catch(Exception e) {} // 예외처리
        nextCommentNo++; // 다음 댓글 번호 1 증가
    }
    // 댓글 목록을 파일로 쓰는 기능
    public void saveCommentDataToFile() throws Exception {
        // List<BoardData> 리스트를 생성
        // 이 코드는 인터페이스의 다형성을 이용하여
        // 서로 다른 타입의 객체를 하나의 메서드로 일괄처리 하기위한 작업
        List<BoardData> list = new ArrayList<BoardData>();
        for(PostComment pc : postCommentList) // 전체 댓글 리스트를 순차조회
            list.add(pc); // List<BoardData> 타입의 리스트에 추가
        // POST_PATH위치의 파일에 리스트를 기록함.
        FileManager.saveData(FileManager.COMMENT_PATH, list);
    }
    // 사용자가 쓴 댓글 목록을 가져오는 기능
    public List<PostComment> getUserComments(String id) {
        // 사용자가 쓴 댓글을 전체 댓글 목록에서부터 가져와서 저장해둘 리스트 생성
        List<PostComment> list = new ArrayList<PostComment>();
        for(PostComment pc : postCommentList) { // 전체 댓글 리스트 순차조회
            if(pc.getPc_author().equals(id)) { // 파라미터의 아이디와 댓글 객체의 작성자가 같다면
                list.add(pc); // 목록에 추가
            }
        }
        return list; // 사용자 댓글 리스트를 내보낸다.
    }
    // 댓글 삭제 기능
    public void removeComment() {
        System.out.print("삭제 할 댓글 번호 : ");
        Integer pc_no = scan.nextInt(); // 삭제 할 댓글 번호 입력
        scan.nextLine(); // 입력 스트림 비우기
        MemberService mService = MemberService.getInstance(); // MemberService 객체 가져오기
        // 사용자가 쓴 댓글 목록 가져오기
        List<PostComment> list = getUserComments(mService.getLoginUserId());
        PostComment target = null; // 삭제 할 댓글을 임시보관할 객체
        for(PostComment comment : list) { // 댓글 리스트를 순차조회 한다.
            // 댓글 객체의 번호가 입력한 번호와 동일하고,
            // 댓글 객체의 작성자가 로그인 한 사용자와 같다면
            if(comment.getPc_no() == pc_no && comment.getPc_author().equals(mService.getLoginUserId())) {
                System.out.println(comment); // 선택된 댓글의 정보를 출력하고
                target = comment; // 삭제 할 댓글을 임시보관할 객체에 정보 복사한다.
            }
        }
        if(target == null) { // 전체 리스트를 조회 후 조건에 맞는 댓글이 없으면
            System.out.println("잘못된 댓글 번호입니다."); // 오류 메시지 출력
        }
        else { // 조건에 맞는 댓글이 있으면
            System.out.print("삭제하시겠습니까? (y/n) : ");
            String confirm = scan.nextLine(); // 사용자에게 확인 요청
            if(confirm.equals("y")) { // y가 입력되었다면
                postCommentList.remove(target); // 전체 리스트에서 찾은 댓글을 제거
                System.out.println("삭제했습니다.");
                try { saveCommentDataToFile(); } // 변경내용 파일에 쓰기
                catch(Exception e) { e.printStackTrace(); } // 예외처리
            }
        }
    }
}
