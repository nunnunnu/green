package JAVA_221025;

import java.util.Scanner;

public class ArrayEx3 {
    public static void main(String[] args) {
        // int[] score = {95,85,80,70,92};
        // String[] name = {"송종하", "정시안", "손경은", "송효빈", "안해일"};
        Scanner s = new Scanner(System.in);
        System.out.print("학생 수를 입력하세요 : > ");
        int t=s.nextInt(); //다음에 받은게 int sel이라서 nextInt안해줘도됨
        int[] score = new int[t];
        String[] name = new String[t];
        int next_index=0; //점수 추가시 점수를 저장할 위치
        while(true){
            System.out.println("1.점수추가, 2.점수조회, 3.점수수정, 0:종료"); 
            int sel = s.nextInt();
            s.nextLine();
            switch(sel){ 
                case 1: //점수추가기능 시작
                    if(next_index>=t){ //현재 입력할 위치가 최대 인덱스를 넘어설경우 오류처리
                        System.out.println("더 이상 입력할 수 없습니다.");
                        System.out.println();
                    }else{
                        System.out.print("이름 : > ");
                        String stu_name = s.nextLine();
                        System.out.print("점수 : > ");
                        int stu_score = s.nextInt();
                        s.nextLine(); //엔터키 입력 비우기
                        name[next_index] = stu_name;//next_index위치에 저장
                        score[next_index] = stu_score;
                        System.out.println("점수가 저장되었습니다");
                        next_index++; //다음번호로 이동
                    }
                    break;//switch문 종료
                case 2://점수 조회기능
                    System.out.print("조회 할 학생의 번호 (0-"+(t-1)+") : > ");
                    int n = s.nextInt();
                    if(n>=0 && n<score.length) { //조회할 인덱스가 범위내인지 검사
                        System.out.println("이름 : "+name[n]);
                        System.out.println("점수 : "+score[n]);
                    }else {
                        System.out.println("잘못된 번호입니다 [번호범위 : 0-"+(t-1)+"]");
                        System.out.println();
                    }
                    System.out.println();
                    break;//switch문 종료
                    case 3://점수수정기능
                    System.out.print("수정할 번호 : > ");
                    int num1 =s.nextInt();
                    
                    //범위확인 코드 빠짐
                    //(구현필요)
                    if(num1>=0 && num1<score.length) { //조회할 인덱스가 범위내인지 검사
                        System.out.println("====수정 전 데이터====");
                        System.out.println("이름 : "+name[num1]);
                        System.out.println("점수 : "+score[num1]);
                    }else {
                        System.out.println("잘못된 번호입니다 [번호범위 : 0-"+(t-1)+"]");
                        System.out.println();
                        break;
                    }
                    
                    System.out.println("====수정 후 데이터====");
                    s.nextLine();
                    System.out.print("이름 : > ");
                    String stu_name = s.nextLine();
                    System.out.print("점수 : > ");
                    int stu_score = s.nextInt();
                    s.nextLine(); //엔터키 입력 비우기
                    System.out.println("이름 : "+name[num1]+" -> "+stu_name);
                    System.out.println("점수 : "+score[num1]+" -> "+stu_score);
                    System.out.print("수정하시겠습니까? 1-수정, 0-적용안함");
                    int num2 = s.nextInt();
                    if(num2 == 1){
                        name[num1] = stu_name;
                        score[num1] = stu_score;
                        System.out.println();
                        System.out.println("점수가 저장되었습니다");
                    }else System.out.println("취소했습니다.");
                    System.out.println();
                    break;//switch문 종료
                case 0: //프로그램종료
                    System.out.println("종료합니다.");
                    s.close();
                    return; //main메소드 종료 = 프로그램종료
                default : //숫자 잘못입력한경우
                    System.out.println("잘못된 메뉴 번호입니다.");
            }
        }
    }
}
