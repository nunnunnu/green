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
  Date nowDate = new Date();
  private String[] category={"정보","유머","이슈"," 팁","잡담"};
  private int index =0;
  
  public Board(){}
  // public Board(Integer no, String title, String name, String mainText, Date date, BoardDetail bd){
  //   setNo(no);
  //   setName(name);
  //   setTitle(title);
  //   setMainText(mainText);
  //   setDate(date);
  // }
  public Board(Integer no, int index, String title, String name, String mainText, Date date){
    setNo(no);
    setName(name);
    setTitle(title);
    setMainText(mainText);
    setDate(date);
    setIndex(index);
    makeDummydata();
  }

  //랜덤용
  public Board(Integer no, int index, String title, String name, String mainText, Date date, int view){
    setNo(no);
    setName(name);
    setTitle(title);
    setMainText(mainText);
    setDate(date);
    randomView(view);
    setIndex(index);
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
  void randomView(int view){
    this.view = (int)(Math.random()*view)+1;
  }
  void setView(int view){
    this.view = view;
  }
  void setIndex(int index){
    this.index = index;
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
  int getCategorysize(){
    return category.length;
  }
  int getView(){
    return view;
  }

  public String toString(){
    return "["+category[index]+"] "+title+"(댓글 : "+commentList.size()+")"+" / 글쓴이 : "+ name + " / 작성일 : "+ Sdate + " / 조회수 : "+view +" / 글번호 : "+no;
  }
  void showDetailInfo(){
    view++;
    System.out.println("-------------------------------------");
    System.out.println("["+category[index]+"] "+title + "(no."+no+")");
    System.out.println("글쓴이    : "+name);
    System.out.println("조회수    : "+view);
    System.out.println("작성일    : "+Sdate);
    System.out.println("-------------------------------------");
    System.out.println("본문 내용 : "+mainText);
    System.out.println("-------------------------------------");
    System.out.println("[댓글창] "+commentList.size());
    for(BoardDetail b : commentList){
      b.showInfo();
    }
  }
  int num;
  void makeDummydata(){
    int n = (int)(Math.random()*(view/5));
    for(int  i=0;i<n;i++){
      commentList.add(new BoardDetail("name"+num, "댓글내용입니다."+num, nowDate));
      num++;
    }
  }

}
