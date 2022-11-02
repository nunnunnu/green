public class BoardDetail {
  private String commentName;
  private String comment;

  public BoardDetail(){}
  public BoardDetail(String name, String comment){
    setComment(comment);
    setCommentName(name);
  }

  void setCommentName(String commentName){
    this.commentName = commentName;
  }
  void setComment(String comment){
    this.comment = comment;
  }
  String getComment(){
    return comment;
  }
  String getCommentName(){
    return commentName;
  }
  void showInfo(){
    System.out.println("댓쓴이 : "+commentName + " / 댓글 내용 : "+comment);
  }
  

}
