import java.util.Scanner;

public class NestedLoop2 {
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            for(int j=0;j<2;j++){
                System.out.println("i : "+ i+" / j : "+j);
            }
        }
        Scanner s = new Scanner(System.in);
        System.out.print("시작단을 입력하세요 : > ");
        int begin = s.nextInt();
        System.out.print("끝단을 입력하세요 : > ");
        s.close();
        int end = s.nextInt();
        if(begin<=end){
            for(int i=begin;i<=end;i++){
                System.out.println(i+"단==========");
                for(int j=1;j<=9;j++){
                    System.out.println(i+" X "+ j+" = "+i*j);
                }
            }
        }else {
            System.out.println("시작 단은 끝 단 보다 클 수 없습니다.");
            return;
        }
    }
}
