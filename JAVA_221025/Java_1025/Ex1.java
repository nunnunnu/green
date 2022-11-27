package JAVA_221025.Java_1025;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int next_index=0;
        System.out.print("학생 수를 입력하세요 : > ");
        int t = s.nextInt();
        int[] score = new int[t];
        String[] name = new String[t];
        while(true){
            System.out.println("1.점수추가, 2.점수조회, 3.점수수정, 0:종료");
            int sel = s.nextInt();
            s.nextLine();
            switch(sel){
                case 1:
                    if(next_index>=t){
                        System.out.println("더 이상 입력할 수 없습니다.");
                        System.out.println();
                    }else {
                        System.out.print("이름 : > ");
                        String stu_name = s.nextLine();
                        System.out.print("점수 : > ");
                        int stu_score = s.nextInt();
                        s.nextLine();
                        name[next_index] = stu_name;
                        score[next_index] = stu_score;
                        System.out.println("점수가 저장되었습니다.");
                        next_index++;
                    }
                    break;
                    case 2:
                    System.out.println("조회 할 학생의 번호 (0-"+(t-1)+" to quit : > ");
                    int n=s.nextInt();
                    if(n>=0 && n<score.length){
                        System.out.println("이름 : "+name[n]);
                        System.out.println("점수 : "+score[n]);
                    }else{
                        System.out.println("잘못된 번호힙니다, [번호범위 : 0-4]");
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 3 : 
                    System.out.print("수정할 번호 : > ");
                    int num1 =s.nextInt();
                    System.out.println("====수정 전 데이터====");
                    System.out.println("이름 : "+name[num1]);
                    System.out.println("점수 : "+score[num1]);
                    System.out.println("====수정 후 데이터====");
                    s.nextLine();
                    System.out.print("이름 : > ");
                    String stu_name = s.nextLine();
                    System.out.print("점수 : > ");
                    int stu_score = s.nextInt();
                    s.nextLine();
                    System.out.println("이름 : "+name[num1]+" -> "+stu_name);
                    System.out.println("점수 : "+score[num1]+" -> "+stu_score);
                    System.out.println("수정하시겠습니까? 1-수정, 0-적용안함");
                    int num2=s.nextInt();
                    if(num2==1){
                        name[num1] = stu_name;
                        score[num1]=stu_score;
                        System.out.println();
                        System.out.println("점수가 저장되었습니다.");
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("종료합니다.");
                    s.close();
                    return;
                default : 
                    System.out.println("잘못된 메뉴 번호입니다.");
                    
            }
        }
    }
    
}
