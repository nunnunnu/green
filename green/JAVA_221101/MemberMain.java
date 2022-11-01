import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MemberMain {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    // List<MemberInfo> memberList = new ArrayList<MemberInfo>();
    List<MemberInfo> memberList = new LinkedList<MemberInfo>();
    // MemberInfo m1 = new MemberInfo("user01","123456","사용자");
    // memberList.add(m1);
    // System.out.println(memberList);
    // memberList.add(new MemberInfo("user02", "123456", "사용자2"));
    // System.out.println(memberList);

    while(true){
      System.out.println("1.회원가입, 2.회원삭제, 3.회원수정, 4.회원목록 0.종료");
      int sel = s.nextInt();
      s.nextLine();
      if(sel==0){
        System.out.println("종료합니다");
        s.close();
        break;
      }
      else if(sel==1){
        System.out.print("아이디 : >> ");
        String id = s.nextLine();
        System.out.print("비밀번호 : >> ");
        String pwd = s.nextLine();
        System.out.print("이름 : >> ");
        String name = s.nextLine();
        
        MemberInfo m = new MemberInfo(id, pwd, name);
        memberList.add(m);
        System.out.println("회원가입이 완료되었습니다.");
        
      }
      else if(sel==2){
        for(int i=0;i<memberList.size();i++){
          System.out.println((i)+"번째 회원 - "+memberList.get(i));
        }
        System.out.println("삭제할 회원의 번호를 입력하세요.");
        int idx = s.nextInt();
        memberList.remove(idx);
        System.out.println("삭제했습니다.");
      }
      else if(sel==3){
        for(int i=0;i<memberList.size();i++){
          System.out.println((i)+"번째 회원 - "+memberList.get(i));
        }
        System.out.println("수정할 회원의 번호를 입력하세요.");
        int idx = s.nextInt();
        MemberInfo m = memberList.get(idx);
        s.nextLine();
        System.out.print("비밀번호 : >> ");
        String pwd = s.nextLine();
        if(m.pwdCheck(pwd)){
          System.out.println(m);
          System.out.print("변경할 아이디 : >> ");
          String id = s.nextLine();
          // m.setId(id);
          System.out.print("변경할 비밀번호 : >> ");
          pwd = s.nextLine();
          // m.setPwd(pwd);
          System.out.print("변경할 이름 : >> ");
          String name = s.nextLine();
          // m.setName(name);
          memberList.set(idx, new MemberInfo(id,pwd,name)); //해당인덱스의 값을 바꿔줌. 이전 데이터를 날려서 주소값도 날리고 새로 입력함.
          System.out.println("변경했습니다.");
        }else{
          System.out.println("비밀번호가 일치하지 않습니다.");
        }
      }
      else if(sel == 4){
        for(int i=0;i<memberList.size();i++){
          System.out.println((i)+"번째 회원 - "+memberList.get(i));
        }
      }else{
        System.out.println("번호를 잘못입력하셨습니다.");
      }
    }


  }
}
