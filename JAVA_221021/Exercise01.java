import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        // int arr[] = {80,75,55};
        // int sum=0;
        // for(int i=0;i<arr.length;i++){
        //     sum += arr[i];
        // }
        // System.out.println("평균 : "+sum/(double)arr.length); //70나옴
        Scanner s = new Scanner(System.in);
        String sarr[] = {"국어","수학","영어","물리","화학","생물"};
        int arr[] = new int[sarr.length];
        int sum=0;        
        for(int i=0;i<arr.length;i++){
            System.out.print(sarr[i]+"의 점수를 입력하세요. > ");
            // arr[i]=s.nextInt();
            sum+=arr[i] = s.nextInt(); //한줄로 받는 법
        }
        System.out.println("입력받은 점수의 평균 : "+sum/(double)arr.length);
        
        s.close();
    }
}
