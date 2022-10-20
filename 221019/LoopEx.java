import java.util.Scanner;

public class LoopEx {
    public static void main(String[] args) {
        // for(int i=0;i<3;i++){
        //     System.out.println("반복합니다."+i);
            
        // }
        // int j=0;
        // while(j<10){
        //     int value = 10;
        //     System.out.println("while반복"+j+"번째");
        //     j++;
        // }
        // int value=10;
        // System.out.println();
        System.out.println("====구구단 출력====");

        for(int i=1;i<10;i++){
            System.out.println("7 * "+i+" = "+i*7);
        }
        System.out.println();

        for(int i=1;i<=7;i++){
            for(int k=1;k<=9;k++){
                System.out.println(i +" * "+k+" = "+i*k);
            }
            System.out.println();
        }

        System.out.println("====구구단 while문 사용====");
        int i=1, k=1;
        while(i<=7){
            System.out.println(i +" * "+k+" = "+i*k);
            k++;
            if(k==9){
                i++;
                k=1;
                System.out.println();
            }
        } 
        System.out.println();
        int arr[] = {10,20,30,40,50};
        for(int index = 0;index<arr.length;index++){
            System.out.println(arr[index]);
        }
    }
    
}
