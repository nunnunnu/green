package JAVA_221028;

import java.util.Date;
import java.util.Scanner;

public class MemberInfo {

  String id;
  String pwd;
  String name;
  Date birth;
  int gen;
  String address;
  String phone;
  String email;
  String profileImg;
  String nickname;
  String statusMsg;
  
  boolean login(String loginId, String loginPwd) {
    return id.equals(loginId) && pwd.equals(loginPwd);
  }

  void changePassword(/*String oldPass, String newPass*/) {
    Scanner s = new Scanner(System.in);
    System.out.print("기존 비밀번호 : ");
    String oldPass = s.nextLine();
    if (!pwd.equals(oldPass)) {
      System.out.println("비밀번호가 틀렸습니다.");
      return;
    }
    System.out.print("새 비밀번호 : ");
    String newPass = s.nextLine();
    pwd = newPass;
    System.out.println("비밀번호가 변경되었습니다.");
  }

  void changeDetailInfo(String attr) {
    Scanner s = new Scanner(System.in);
    if (attr.equals("address")) {
      System.out.print("변경할 주소 : ");
      address = s.nextLine();
      System.out.println("주소가 변경되었습니다.");
    }
    if (attr.equals("phone")) {
      System.out.print("변경할 전화번호(-제외) : ");
      phone = s.nextLine();
      System.out.println("번호가 변경되었습니다.");
    }
    if (attr.equals("email")) {
      System.out.print("변경할 이메일 : ");
      email = s.nextLine();
      System.out.println("이메일이 변경되었습니다.");
    }
    if (attr.equals("profileImg")) {
      System.out.print("프로필 이미지 파일 : ");
      profileImg = s.nextLine();
      System.out.println("프로필 이미지가 변경되었습니다.");
    }
    if (attr.equals("nickname")) {
      System.out.print("변경할 닉네임 : ");
      nickname = s.nextLine();
      System.out.println("닉네임이 변경되었습니다.");
    }
    if (attr.equals("statusMsg")) {
      System.out.print("변경할 상태메세지 : ");
      statusMsg = s.nextLine();
      System.out.println("상태메세지가 변경되었습니다.");
    }
  }

  void showInfo() {
    System.out.println("아이디 : "+id);
    System.out.println("이름 : "+name);
    System.out.println("생일 : "+birth);
    System.out.println("성별 : "+gen);
    System.out.println("주소 : "+address);
    System.out.println("전화번호 : "+phone);
    System.out.println("이메일 : "+email);
    System.out.println("프로필사진 : "+profileImg);
    System.out.println("닉네임 : "+nickname);
    System.out.println("상태메시지 : "+statusMsg);
  }
}
