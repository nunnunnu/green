import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class BoardMain2 {
  public static List<BoardPost> postList = new ArrayList<BoardPost>();
  public static Scanner s = new Scanner(System.in);
  public static List<BoardComment> commentList = new ArrayList<BoardComment>();
  public static void main(String[] args) {
    // System.out.println(BoardPost.next_no); //next_no는 클래스변수라서 객체생성 전에도 사용 가능함. 모든 BoardPost타입의 객체가 공유중임
    // BoardPost post1 = new BoardPost(null, null, null);
    // System.out.println(post1.next_no); //2
    // System.out.println(BoardPost.next_no); //2
    // BoardPost post2 = new BoardPost(null, null, null);
    // System.out.println(BoardPost.next_no); //3
    // System.out.println(post2.next_no); //3
    // for(int i=0;i<100;i++){
    //   BoardPost post = new BoardPost(null, null, null);
    // }
    // System.out.println(BoardPost.next_no); //103
		
    initializeBoardPost(10);
    while(true){
      System.out.print("1.글 등록, 2.글 수정, 3.글 삭제, 4.글 목록 5.글 상세조회, 0.종료 : >> ");
      int sel = s.nextInt();
      s.nextLine();
      // if(sel==0){
      //   s.close();
      //   System.out.println("프로그램을 종료합니다");
      //   break;
      // }
      // else if(sel==1){
      //   addPost();
      // }
      // else if(sel==2){
      //   updatePost();
      // }
      // else if(sel==3){
      //   deletePost();
      // }
      // else if(sel==4){
      //   printPostList();
      // }
      // else if(sel==5){
      //   printPostDetail();
      // }
      // else{
      //   System.out.println("번호를 잘못입력하셨습니다. 다시 입력해주세요.");
      // }
      switch(sel){
        case 1:
          addPost();
          break;
        case 2:
          updatePost();
          break;
        case 3:
          deletePost();
          break;
        case 4:
          printPostList();
          break;
        case 5:
          printPostDetail();
          break;
        case 0:
          System.out.println("종료합니다");
          return;
        default : 
          System.out.println("번호를 잘못입력하셨습니다. 다시 입력해주세요.");
      }
    }
  }

  public static void addPost(){
    System.out.print("제목 : ");
    String title = s.nextLine();
    System.out.print("내용 : ");
    String content = s.nextLine();
    System.out.print("작성자 : ");
    String author = s.nextLine();
    System.out.print("비밀번호 : ");
    String pwd = s.nextLine();
    System.out.print("글을 등록하시겠습니까?(y/n): ");
    String confirm =s.nextLine();
    if(confirm.equalsIgnoreCase("y")){
      postList.add(new BoardPost(title, content, author, pwd));
      System.out.println("글이 등록되었습니다");
    }else{
      System.out.println("글 등록이 취소되었습니다.");
    }
  }
  public static void printPostList(){
    System.out.println("글번호\t글제목\t\t작성자\t등록일\t\t\t조회수");
    for(BoardPost p : postList){
      p.showPostInfo(false);
    }
  }
  public static void printPostDetail(){
    System.out.print("글번호 : ");
    int n = s.nextInt();
    s.nextLine();
    BoardPost p = searchPostDetailByNumber(n);
    if(p != null){
      p.post_count++;
      p.showPostInfo(true);
      showComment(p.post_no);
      System.out.println("1.댓글쓰기 0.목록으로");
      int sel = s.nextInt();
      s.nextLine();
      if(sel == 1){
        addComment(n);
        p.showPostInfo(true);
        showComment(p.post_no);
      }else{
        System.out.println("목록으로 돌아갑니다.");
      }
    }
  }
    
  public static void showComment(Integer post_no) {
    for(BoardComment c : commentList){
      if(c.post_no==post_no){
      c.printCommentInfo();
      }
    }
  }
  public static void addComment(Integer post_no){
    System.out.print("닉네임 : ");
    String author = s.nextLine();
    System.out.print("내용 : ");
    String comment = s.nextLine();
    System.out.print("비밀번호 : ");
    String pwd = s.nextLine();
    System.out.print("정말 등록하시겠습니까? (y/n) >> ");
    String confirm = s.nextLine();
    if(confirm.equalsIgnoreCase("y")){
      commentList.add(new BoardComment(post_no, comment, author, pwd));
    }else{
    System.out.println("댓글 등록이 취소되었습니다.");
    }
  }
  public static void initializeBoardPost(int count){
    for(int i=0;i<count;i++){
      postList.add(new BoardPost("dummytitle"+i, "dummycontent"+i, "autor"+i, "123"+i));
    }
  }
  public static void updatePost(){
    System.out.print("수정할 글 번호 : ");
    int n = s.nextInt();
    s.nextLine();
    BoardPost p =searchPostDetailByNumber(n);
    if(p!=null){
      p.showPostInfo(true);
      System.out.print("글 비밀번호 : >> ");
      String pwd = s.nextLine();
      if(p.post_pwd.equals(pwd)){
        System.out.print("제목 : ");
        String title = s.nextLine();
        if(title.equals("")){
          title = p.post_title;
        }
        System.out.print("내용 : ");
        String content = s.nextLine();
        if(content.equals("")){
          content = p.post_content;
        }
        System.out.print("수정하시겠습니까?(y/n) : >> ");
        String confirm = s.nextLine();
        if(confirm.equalsIgnoreCase("y")){
          p.post_title = title;
          p.post_content = content;
          p.post_mod_dt = new Date();
          System.out.println("수정되었습니다.");
        }
      }else{
        System.out.println("비밀번호가 일치하지않습니다.");
      }
    }
  }
    
  public static void deletePost(){
    System.out.print("삭제할 글 번호 : ");
    int n = s.nextInt();
    s.nextLine();
    BoardPost p =searchPostDetailByNumber(n);
    if(p!=null){
      p.showPostInfo(true);
      System.out.print("삭제하시겠습니까?(y/n) : >> ");
      String confirm = s.nextLine();
      if(confirm.equalsIgnoreCase("y")){
        System.out.print("글 비밀번호 : >> ");
        String pwd = s.nextLine();
        if(p.post_pwd.equals(pwd)){
          postList.remove(p); //일치하는 것 삭제
          System.out.println("삭제되었습니다.");
        }else{
          System.out.println("비밀번호가 일치하지않습니다.");
        }
      }
    }
  }
  public static BoardPost searchPostDetailByNumber(int post_no){
    for(BoardPost p : postList){
      if(p.post_no==post_no){
        System.out.println("글번호\t글제목\t\t작성자\t등록일\t\t\t조회수");
        // p.post_count++;
        // p.showPostInfo(true);
        return p;
      }
    }
    System.out.println(post_no+"번 글이 존재하지않습니다.");
    return null;
  }
}
