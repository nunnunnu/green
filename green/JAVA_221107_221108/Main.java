import java.util.Scanner;

import service.MemberService;
import service.StoreService;

public class Main {
  public static Scanner scan = new Scanner(System.in);
  public static final boolean ADMIN_MODE = false;
  public static void main(String[] args) throws Exception {
    MemberService.addMasterMember();
    while(true){
      System.out.println("1. 관리자, 2.일반사용자, 0.종료");
      Integer sel = scan.nextInt();
      if(sel==0){
        System.out.println("종료합니다.");
        break;
      }else if(sel==1){
        admin_mode();
      }else if(sel==2){
        normalMode();
      }else{
        System.out.println("번호 입력이 잘못되었습니다.");
      }
    }
  }
  public static void normalMode() throws Exception {
    while(true){
      String storeName="";
      if(StoreService.selectedStore!=null){
        storeName = StoreService.selectedStore.basicInfo.name;
      }else{
        storeName = "선택한 가게 없음";
      }
      String loginInfo="";
      if(MemberService.loginMember!=null){
        loginInfo = MemberService.loginMember.name+"("+MemberService.loginMember.id+") 님";
        System.out.println("99. 로그아웃");
      }else{
        loginInfo = "비회원";
        System.out.println("98. 회원가입, 97.로그인");
      }
      System.out.println("회원정보 : "+loginInfo);
      System.out.println("## 선택 중인 가게 : "+storeName);
      System.out.println("1. 가게 목록 보기");
      System.out.println("2. 가게 선택");
      System.out.println("3. 메뉴 목록 보기");
      System.out.println("4. 리뷰 보기");
      System.out.println("5. 리뷰 등록");
      System.out.println("0. 메인화면");
      System.out.print("선택 (1-5) : ");
      Integer sel = scan.nextInt();
      scan.nextLine();
      if(sel==0){
        System.out.println("메인화면으로 돌아갑니다.");
        break;
      }else if(sel==1){
        StoreService.showStoreList();
      }else if(sel==2){
        StoreService.selectStore();
      }else if(sel==3){
        StoreService.showStoreMenus();
      }else if(sel==4){
        StoreService.showStoreReview();
      }else if(sel==5){
        StoreService.addStoreRevie();
      }else if(sel==99 && MemberService.loginMember!=null){
        MemberService.logout();
      }else if(sel==98 && MemberService.loginMember==null){
        MemberService.memberJoin();
      }else if(sel==97 && MemberService.loginMember==null){
        MemberService.login();
      }else{
        System.out.println("번호를 잘못입력하셨습니다.");
      }
    }
  }
  public static void admin_mode()throws Exception {
    MemberService.login();
    if(MemberService.loginMember!=null){
      if(MemberService.loginMember.isAdmin ==false){ //로그인했는데 일반회원일때
        System.out.println("관리자 전용 입니다.");
        return;
      }
    }else{ //로그인 실패시
      return;
    }
    while(true){
      String storeName="";
      if(StoreService.selectedStore!=null){
        storeName = StoreService.selectedStore.basicInfo.name;
      }else{
        storeName = "선택한 가게 없음";
      }
        System.out.println("## 선택 중인 가게 : "+storeName);
        System.out.println("1. 가게 목록 보기");
        System.out.println("2. 가게추가");
        System.out.println("3. 가게 선택");
        System.out.println("4. 메뉴 추가");
        System.out.println("5. 메뉴 목록 보기");
        System.out.println("6. 리뷰 보기");
        System.out.println("0. 메인화면");
        System.out.print("선택 (1-6) : ");
        Integer sel = scan.nextInt();
        scan.nextLine();
        if(sel==0){
          System.out.println("메인화면으로 돌아갑니다.");
          break;
        }else if(sel==1){
          StoreService.showStoreList();
        }else if(sel==2){
          StoreService.addStore();
        }else if(sel==3){
          StoreService.selectStore();
        }else if(sel==4){
          StoreService.addStoreMenu();
        }else if(sel==5){
          StoreService.showStoreMenus();
        }else if(sel==6){
          StoreService.showStoreReview();
        }else{
          System.out.println("번호를 잘못입력하셨습니다.");
        }
    }
  }
}
