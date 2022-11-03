import java.text.SimpleDateFormat;
import java.util.Date;

//게시 글 정보
public class BoardPost{
  //next_no는 클래스변수라서 객체생성 전에도 사용 가능함. 모든 BoardPost타입의 객체가 공유중임. 단 1개만 존재
  static int next_no = 1;
  Integer post_no; //글번호
  String post_title;
  String post_content; //글내용
  Date post_reg_dt; //글 등록일
  Date post_mod_dt; //글 수정일
  String post_author;//작성자
  Integer post_count; //조회수
  String post_pwd; //게시글 비밀번호


  public BoardPost(String title, String content, String author, String pwd){
    post_no = next_no;
    this.post_pwd=pwd;
    this.post_title = title;
    this.post_content = content;
    this.post_author = author;
    this.post_reg_dt = new Date(); //글 등록일 = 객체를 만든 시간
    this.post_mod_dt = new Date(); //글 수정일 = 객체를 만든 시간
    this.post_count = 0;
    next_no++;
  }
  SimpleDateFormat f= new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  void showPostSummary(boolean detail){
    System.out.print(post_no+"\t");
    System.out.print(post_title+"\t");
    System.out.print(post_reg_dt+"\t");
    System.out.print(post_author+"\t");
    System.out.print(post_count+"\t");
    if(detail){
      System.out.println(f.format(post_mod_dt)+"\t");
    }
    System.out.println(post_content);
    if(detail){
      System.out.println("------------------------------------------------------");
      System.out.println(post_content);
      System.out.println("------------------------------------------------------");
    }
    
  }
  public void showPostInfo(boolean b) {
    System.out.println("---------------------------------------------------------------------------------");
    System.out.println(post_no+"\t"+post_title+"\t"+post_author+"\t"+f.format(post_mod_dt)+"\t"+post_count);
    if(b){
      System.out.println("---------------------------------------------------------------------------------");
      System.out.println(post_content);
      System.out.println("---------------------------------------------------------------------------------");
    }
  }
}