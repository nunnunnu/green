package JAVA_221028;

import java.util.Date;
import java.util.Scanner;

public class Object_memberTestEx {
  public static void main(String[] args) {
    MemberInfo member1 = new MemberInfo();
    member1.id = "user1";
    member1.pwd = "123456";
    member1.name = "사용자";
    member1.birth = new Date(); // 실행 시 날짜
    member1.gen = 0;
    member1.address = "대구 중구 중앙대로 394";
    member1.phone = "01012345678";
    member1.email = "user@service.com";
    member1.profileImg = "pfimg.jpg";
    member1.nickname = "사용자";
    member1.statusMsg = "ㅁㅁㅁㅁ";

    member1.showInfo();
    if (member1.login("user1", "123456")) {
      System.out.println("로그인 성공");
    } else {
      System.out.println("로그인 실패");
    } // 성공

    if (member1.login("user2", "123456")) {
      System.out.println("로그인 성공");
    } else {
      System.out.println("로그인 실패");
    } // 실패

    member1.changePassword();

    System.out.println("변경할 상세정보[phone, email, profileImg, nickname, statusMsg");
    Scanner s = new Scanner(System.in);
    String field = s.nextLine();
    member1.changeDetailInfo(field);
    member1.showInfo();
    field = s.nextLine();
    member1.changeDetailInfo(field);
    member1.showInfo();
    field = s.nextLine();
    member1.changeDetailInfo(field);
    member1.showInfo();
    field = s.nextLine();
    member1.changeDetailInfo(field);
    member1.showInfo();
    field = s.nextLine();
    member1.changeDetailInfo(field);
    member1.showInfo();
    field = s.nextLine();
    member1.changeDetailInfo(field);
    member1.showInfo();

    s.close();
  }
}
