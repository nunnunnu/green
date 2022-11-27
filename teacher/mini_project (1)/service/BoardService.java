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
    
    public void updatePost() {
        MemberService mService = MemberService.getInstance();
        if(mService.getLoginUser() == null) {
            System.out.println("로그인 후 사용할 수 있습니다.");
            return;
        }
        if(!currentPost.getPost_author().equals(mService.getLoginUser().getMi_id())) {
            System.out.println("작성자만 글을 수정할 수 있습니다.");
            return;
        }
        if(currentPost.getPost_status() != 1) {
            System.out.println("삭제되었거나 블라인드 처리된 글은 수정할 수 없습니다.");
            return;
        }
        System.out.print("제목 : ");
        String title = scan.nextLine();
        if(title.equals("")) title = currentPost.getPost_title();
        System.out.print("글 내용 : ");
        String content = scan.nextLine();
        if(content.equals("")) content = currentPost.getPost_content();

        currentPost.setPost_title(title);
        currentPost.setPost_content(content);
        currentPost.setPost_mod_dt(new Date());
        System.out.println("글을 수정했습니다.");

        try { savePostListToFile(); }
        catch(Exception e) { e.printStackTrace(); }
    }
    
    public void deletePost() {
        MemberService mService = MemberService.getInstance();
        if(mService.getLoginUser() == null) {
            System.out.println("로그인 후 사용할 수 있습니다.");
            return;
        }
        if(!currentPost.getPost_author().equals(mService.getLoginUser().getMi_id())) {
            System.out.println("작성자만 글을 삭제할 수 있습니다.");
            return;
        }        
        currentPost.setPost_status(2);
        System.out.println("글을 삭제하였습니다.");
        try { savePostListToFile(); }
        catch(Exception e) { e.printStackTrace(); }
    }
    
    public void selectPost() {
        System.out.print("글 번호 : ");
        Integer sel = scan.nextInt();
        scan.nextLine();
        currentPost = getPost(sel);
        if(currentPost == null) {
            System.out.println("존재하지 않는 글 번호 입니다.");
        }
        else if(currentPost.getPost_status() != 1){
            System.out.println("차단되었거나 삭제된 글 입니다.");
        }
        else {
            currentPost.showPostDetail();
            List<PostComment> comments = selectPostComments(currentPost.getPost_no());
            for(PostComment pc : comments) {
                System.out.println(pc);
            }
        }
    }
    public List<PostComment> selectPostComments(Integer postNo) {
        List<PostComment> postComments = new LinkedList<PostComment>();
        for(PostComment p : postCommentList) {
            if(p.getPc_post_no() == postNo) {
                postComments.add(p);
            }
        }
        return postComments;
    }

    private PostInfo getPost(Integer post_no) {
        for(PostInfo p : postList) {
            if(p.getPost_no() == post_no) {
                return p;
            }
        }
        return null;
    }

    private void savePostListToFile() throws Exception {
        List<BoardData> list = new ArrayList<BoardData>();
        for(PostInfo p : postList)
            list.add(p);
        FileManager.saveData(FileManager.POST_PATH, list);
    }

    public void addPostComment() {
        if(currentPost == null)
            return;
        MemberService mService = MemberService.getInstance();
        String id = mService.getLoginUserId();
        Integer post_no = currentPost.getPost_no();
        System.out.print("댓글 내용 : ");
        String content = scan.nextLine();

        postCommentList.add(new PostComment(nextCommentNo, post_no, content, id));
        System.out.println("댓글이 추가되었습니다.");
        
        try { saveCommentDataToFile(); }
        catch(Exception e) {}
        nextCommentNo++;
    }

    public void saveCommentDataToFile() throws Exception {
        List<BoardData> list = new ArrayList<BoardData>();
        for(PostComment pc : postCommentList)
            list.add(pc);
        FileManager.saveData(FileManager.COMMENT_PATH, list);
    }

    public List<PostComment> getUserComments(String id) {
        List<PostComment> list = new ArrayList<PostComment>();
        for(PostComment pc : postCommentList) {
            if(pc.getPc_author().equals(id)) {
                list.add(pc);
            }
        }
        return list;
    }
    public void removeComment() {
        System.out.print("삭제 할 댓글 번호 : ");
        Integer pc_no = scan.nextInt();
        scan.nextLine();
        MemberService mService = MemberService.getInstance();
        List<PostComment> list = getUserComments(mService.getLoginUserId());
        PostComment target = null;
        
        for(PostComment comment : list) {
            if(comment.getPc_no() == pc_no && comment.getPc_author().equals(mService.getLoginUserId())) {
                System.out.println(comment);
                target = comment;
            }
        }
        if(target == null) {
            System.out.println("잘못된 댓글 번호입니다.");
        }
        else {
            System.out.print("삭제하시겠습니까? (y/n) : ");
            String confirm = scan.nextLine();
            if(confirm.equals("y")) {
                postCommentList.remove(target);
                System.out.println("삭제했습니다.");
                try { saveCommentDataToFile(); }
                catch(Exception e) { e.printStackTrace(); }
            }
        }
    }
}
