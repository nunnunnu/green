import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardComment {
  Integer post_no;
  String comment;
  Date reg_dt;
  String author;
  String pwd;
  SimpleDateFormat f = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

  public BoardComment(Integer post_no, String comment, String author, String pwd){
    this.post_no = post_no;
    this.comment = comment;
    this.author = author;
    this.pwd = pwd;
    reg_dt = new Date();
  }
  public void printCommentInfo(){
    System.out.println(author+" : "+comment+"("+f.format(reg_dt)+")");
  }
}
