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
    private static Scanner scan = new Scanner(System.in);
    private static BoardService instance = null;

    public List<PostInfo> postList;
    public List<PostComment> postCommentList;
    public PostInfo currentPost;
    public Integer nextPostNo;
    public Integer nextCommentNo;

    private BoardService() {
        postList = new LinkedList<PostInfo>();
        postCommentList = new LinkedList<PostComment>();
        try {
            initializeBoardPosts();
            initializeBoardComments();
        }
        catch(Exception e) { e.printStackTrace(); }
    }

    public static BoardService getInstance() {
        if(instance == null) instance = new BoardService();
        return instance;
    }

    private void initializeBoardPosts() throws Exception {
        List<String> list = FileManager.loadData(FileManager.POST_PATH);
        for(String str : list) {
            PostInfo p = new PostInfo();
            p.parseDataString(str);
            postList.add(p);
        }
        if(postList.size() == 0)
            nextPostNo = 1;
        else
            nextPostNo = postList.get(postList.size()-1).getPost_no() + 1;
    }

    private void initializeBoardComments() throws Exception {
        List<String> list = FileManager.loadData(FileManager.COMMENT_PATH);
        for(String str : list) {
            PostComment pc = new PostComment();
            pc.parseDataString(str);
            postCommentList.add(pc);
        }

        if(postCommentList.size() == 0)
            nextCommentNo = 1;
        else
            nextCommentNo = postCommentList.get(postCommentList.size()-1).getPc_no() + 1;
    }

    public void showPostList() {
        System.out.printf("%-5s %-20s %-20s %-16s\n", "No", "Title", "RegDt", "Author");
        for(PostInfo p : postList) {
            if(p.getPost_status() != 1) continue;
            p.showPostSummary();
        }
        currentPost = null;
    }

    public void addPost() {
        System.out.print("제목 : ");
        String title = scan.nextLine();
        System.out.println("내용 입력 ==========");
        String content = scan.nextLine();
        System.out.print("등록하시겠습니까? (y/n) : ");
        String confirm = scan.nextLine();
        if(confirm.equalsIgnoreCase("y")) {
            MemberService mService = MemberService.getInstance();
            postList.add(new PostInfo(nextPostNo, title, content, mService.getLoginUserId(), 1));
            nextPostNo++;
            try { savePostListToFile(); }
            catch(Exception e) { e.printStackTrace(); }
        }
        else {
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
