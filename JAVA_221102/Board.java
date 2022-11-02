import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Board {
  private Integer no; //글번호
  private String title;
  private String name;
  private String mainText;
  private String Sdate;
  SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
  List<BoardDetail> commentList = new ArrayList<BoardDetail>();
  private int view;
  
  public Board(){}
  // public Board(Integer no, String title, String name, String mainText, Date date, BoardDetail bd){
  //   setNo(no);
  //   setName(name);
  //   setTitle(title);
  //   setMainText(mainText);
  //   setDate(date);
  // }
  public Board(Integer no, String title, String name, String mainText, Date date){
    setNo(no);
    setName(name);
    setTitle(title);
    setMainText(mainText);
    setDate(date);
    makeDummydata();
  }

  void setNo(Integer no){
    this.no = no;
  }
  void setTitle(String title){
    this.title = title;
  }
  void setName(String name){
    this.name = name;
  }
  void setMainText(String mainText){
    this.mainText = mainText;
  }
  void setDate(Date nowdate){
    this.Sdate = format.format(nowdate);
  }
  Integer getNo(){
    return this.no;
  }
  String getName(){
    return this.name;
  }
  String getTitle(){
    return this.title;
  }
  String getMainText(){
    return this.mainText;
  }
  String getDate(){
    return this.Sdate;
  }

  public String toString(){
    return "글 번호 : "+no+" / 글 제목 : "+ title+" / 글쓴이 : "+ name + "/ 작성일 : "+ Sdate + " / 댓글 수 : "+commentList.size() + " / 조회수 : "+view;
  }
  void showDetailInfo(){
    view++;
    System.out.println("글 번호   : "+no);
    System.out.println("글 제목   : "+title);
    System.out.println("글쓴이    : "+name);
    System.out.println("조회수    : "+view);
    System.out.println("작성일    : "+Sdate);
    System.out.println("본문 내용 : "+mainText);
    for(BoardDetail b : commentList){
      b.showInfo();
    }
  }
  int num;
  void makeDummydata(){
    commentList.add(new BoardDetail("name"+num, "댓글내용입니다."+num));
    num++;
    commentList.add(new BoardDetail("name"+num, "댓글내용입니다."+num));
    num++;
    commentList.add(new BoardDetail("name"+num, "댓글내용입니다."+num));
    num++;
    commentList.add(new BoardDetail("name"+num, "댓글내용입니다."+num));
    num++;
    commentList.add(new BoardDetail("name"+num, "댓글내용입니다."+num));
    num++;

  }

}
