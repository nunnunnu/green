import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Boardmain {
  static List<Board> boardList = new ArrayList<Board>();
  static Integer no = 0;
  static Date date = new Date();
  static Scanner s = new Scanner(System.in);
  static List<BoardDetail> commentList = new ArrayList<BoardDetail>();

  public static void main(String[] args) {
    //글쓰기, 글수정, 글 삭제, 글목록(글내용 제외), 글내용 상세보기
    dummydata(10);

    while(true){
      System.out.print("1.글쓰기, 2.글수정, 3.글 삭제, 4.글목록조회, 5.글내용 상세보기 0.종료 : >> ");
      int sel = s.nextInt();
      s.nextLine();
      if(sel == 0){
        System.out.println("프로그램을 종료합니다.");
        s.close();
        break;
      }
      else if(sel==1){
        addpost();
      }
      else if(sel==2){
        updatePost();
      }
      else if(sel==3){
        deletePost();
      }
      else if(sel==4){
        showInfo();

      }
      else if(sel==5){
        detailShowInfo();
      }
      else{
        System.out.println("잘못된 번호를 입력하셨습니다. 번호를 다시 입력해주세요.");
      }
    }
  }
  public static void dummydata(int n){
    Board b = new Board();
    for(int i=0;i<n;i++){
      int r = (int)(Math.random()*b.getCategorysize());
      boardList.add(new Board(no, r,"글"+no, "닉네임"+no, "글본문입니다."+no, date, 100));
      no++;

    }
  }
  public static void showInfo(){
    System.out.println("===========글 목록=============");
    for(Board b : boardList){
      System.out.println(b);
    }
  }
  public static void addpost(){
    System.out.println("글을 작성합니다.");
    System.out.print("카테고리 : 0.정보, 1.유머, 2.이슈, 3.팁, 4.잡담 >> ");
    int a = s.nextInt();
    System.out.print("제목 : ");
    s.nextLine();
    String title = s.nextLine();
    System.out.print("글쓴이 : ");
    String name = s.nextLine();
    System.out.print("본문 내용 : ");
    String mainText = s.nextLine();
    boardList.add(new Board(no, a, title, name, mainText, date));
    System.out.println("글 작성이 완료되었습니다.");
    no++;
  }
  public static void updatePost(){
    System.out.print("수정할 글 번호를 입력하세요 : >> ");
    int n = s.nextInt();
    int index=0;
    boolean check = false;
    for(int i=0;i<boardList.size();i++){
      if(boardList.get(i).getNo()==n){
        index = i;
        check = true;
        break;
      }
    }
    if(!check){
      System.out.println("해당 글 번호가 존재하지 않습니다. 글 번호를 다시 확인해주세요.");
      return;
    }
    System.out.println("======수정할 내용 입력======");
    System.out.println("카테고리 : 0.정보, 1.유머, 2.이슈, 3.팁, 4.잡담");
    int a = s.nextInt();
    System.out.print("제목 : ");
    s.nextLine();
    String title = s.nextLine();
    System.out.print("글쓴이 : ");
    String name = s.nextLine();
    System.out.print("본문 내용 : ");
    String mainText = s.nextLine();
    
    System.out.print("정말로 수정하시겠습니까? 예-Y, 아니오 - 아무키나 입력하세요 : >> ");
    String comfirm = s.nextLine();
    if(comfirm.equalsIgnoreCase("y")){
      boardList.get(index).setTitle(title);
      boardList.get(index).setName(name);
      boardList.get(index).setMainText(mainText);
      boardList.get(index).setIndex(a);

      System.out.println("수정이 완료되었습니다.");
    }
    else{
      System.out.println("수정이 취소되었습니다.");
    }
  }
  public static void deletePost(){
    System.out.print("삭제할 글 번호를 입력하세요 : >> ");
    int n = s.nextInt();
    int index=0;
    boolean check = false;
    for(int i=0;i<boardList.size();i++){
      if(boardList.get(i).getNo()==n){
        index = i;
        check = true;
        break;
      }
    }
    if(!check){
      System.out.println("해당 글 번호가 존재하지 않습니다. 글 번호를 다시 확인해주세요.");
      return;
    }
    System.out.println(boardList.get(index));
    System.out.print("정말로 삭제하시겠습니까? 예-Y, 아니오 - 아무키나 입력하세요 : >> ");
    s.nextLine();
    String comfirm = s.nextLine();
    if(comfirm.equalsIgnoreCase("y")){
      boardList.remove(index);
      System.out.println("삭제 완료되었습니다.");
    }
    else{
      System.out.println("삭제가 취소되었습니다.");
    }
  }
  public static void detailShowInfo(){
    System.out.print("조회할 글 번호를 입력하세요 : >> ");
    int n = s.nextInt();
    int index=0;
    boolean check = false;
    for(int i=0;i<boardList.size();i++){
      if(boardList.get(i).getNo()==n){
        index = i;
        check = true;
        break;
      }
    }
    if(!check){
      System.out.println("해당 글 번호가 존재하지 않습니다. 글 번호를 다시 확인해주세요.");
      return;
    }
    boardList.get(index).showDetailInfo();
    System.out.print("댓글을 다시려면 Y를 눌러주세요. 처음으로 돌아가려면 아무키나 누르세요 : >>");
    s.nextLine();
    String comfirm = s.nextLine();
    if(comfirm.equalsIgnoreCase("Y")){
      System.out.print("닉네임 : >> ");
      String name = s.nextLine();
      System.out.print("댓글 : >> ");
      String comment = s.nextLine();
      boardList.get(index).commentList.add(new BoardDetail(name, comment, date));
      System.out.println("댓글 등록이 완료되었습니다.");
      boardList.get(index).showDetailInfo();
    }
  }
}
