import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardDetail {
  private String commentName;
  private String comment;
  private String Sdate;
  SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

  public BoardDetail(){}
  public BoardDetail(String name, String comment, Date date){
    setComment(comment);
    setCommentName(name);
    setDate(date);
  }

  void setCommentName(String commentName){
    this.commentName = commentName;
  }
  void setComment(String comment){
    this.comment = comment;
  }
  void setDate(Date nowdate){
    this.Sdate = format.format(nowdate);
  }
  String getComment(){
    return comment;
  }
  String getCommentName(){
    return commentName;
  }
  void showInfo(){
    System.out.println(commentName+"("+Sdate+")" + " : "+comment );
  }
  

}
