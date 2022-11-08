package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import data.Member;
import utill.AESAlgorithm;

public class MemberService {
  public static Scanner scan = new Scanner(System.in);
  public static List<Member> memberList = new ArrayList<Member>();
  public static Member loginMember=null; //Session을 가상으로 만들어줌
  public static void logout(){ //Session 무효화.
    loginMember = null;
    System.out.println("로그아웃 되었습니다.");
  }

  public static void showMemberList(){
    if(memberList.size() == 0){
      System.out.println("등록된 회원이 없습니다.");
    }else{
      for(Member m : memberList){
        System.out.println(m);
      }
    }
  }
  public static boolean isDuplicateId(String id){
    for(Member m : memberList){
      if(id.equals(m.id)){
        return true;
      }
    }
    return false;
  }
  public static void memberJoin() throws Exception{
    //내가한거
    // System.out.println("1.관리자 회원가입, 2.일반 회원가입");
    // int sel = scan.nextInt();
    // scan.nextLine();
    // if(sel==1){
    //   System.out.print("아이디 : ");
    //   String id = scan.nextLine();
    //   if(!isDuplicateId(id)){
    //     System.out.print("비밀번호 : ");
    //     String pwd = scan.nextLine();
    //     System.out.print("이름 : ");
    //     String name = scan.nextLine();
    //     memberList.add(new Member(id, pwd, name, true));
    //   }else{
    //     System.out.println("중복된 아이디입니다. 다시 시도해주세요.");
    //   }
    // }else if(sel==2){
    //   System.out.print("아이디 : ");
    //   String id = scan.nextLine();
    //   if(!isDuplicateId(id)){
    //     System.out.print("비밀번호 : ");
    //     String pwd = scan.nextLine();
    //     System.out.print("이름 : ");
    //     String name = scan.nextLine();
    //     memberList.add(new Member(id, pwd, name, false));
    //   }else{
    //     System.out.println("중복된 아이디입니다. 다시 시도해주세요.");
    //   }
    // }else{
    //   System.out.println("잘못된 번호를 입력하셨습니다. 다시 시도해주세요.");
    // }

    //쌤코드
    System.out.print("아이디 : ");
    String id = scan.nextLine();
    if(isDuplicateId(id)){
      System.out.println("중복된 아이디입니다. 다시 시도해주세요.");
      return;
    }else{
      System.out.print("비밀번호 : ");
      String pwd = AESAlgorithm.Encrypt(scan.nextLine());
      System.out.print("이름 : ");
      String name = scan.nextLine();
      System.out.print("계정유형(1.관리자, 0.일반) : ");
      Integer type = scan.nextInt();
      scan.nextLine();

      memberList.add(new Member(id, pwd, name, type==1)); //type이 1이 아니면 false
      System.out.println("회원등록이 완료되었습니다.");
    }
  }
  //내가 만든거
  // public static Member login() throws Exception{
  //   System.out.println("======로그인======");
  //   System.out.print("아이디 : ");
  //   String id = scan.nextLine();
  //   System.out.print("비밀번호 : ");
  //   String pwd = scan.nextLine();
  //   for(Member m : MemberService.memberList){
  //     if(id.equals(m.id) && AESAlgorithm.Encrypt(pwd).equals(m.pwd)){
  //       System.out.println("로그인이 완료되었습니다.");
  //       return m;
  //     }
  //   }
  //   System.out.println("존재하지 않는 회원입니다. 아이디와 비밀번호를 확인해주세요");
  //   return null;
  // }
  
  //쌤코드
  public static void login() throws Exception {
    System.out.println("======로그인======");
    System.out.print("아이디 : ");
    String id = scan.nextLine();
    System.out.print("비밀번호 : ");
    String pwd = AESAlgorithm.Encrypt(scan.nextLine());
      for(Member m : MemberService.memberList){
        if(id.equals(m.id) && pwd.equals(m.pwd)){
          System.out.println("로그인이 완료되었습니다.");
          loginMember = m;
        }
      }
    if(loginMember == null){
      System.out.println("아이디, 비밀번호가 잘못되었거나 없는 회원입니다.");
    }
  }
}
