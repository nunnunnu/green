package JAVA_221025;

import java.util.Scanner;

public class ArrayLoopEx02 {
    public static void main(String[] args) {
        //제일 높은 시간대, 낮은 시간대, 평균
        int[] arr = {199,165,90,107,89,99,195,284,307,598,545,674,726,581,560,673,498,908,944,742,429,489,402,307};
        int max_idx=0,min_idx=0,sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[max_idx]) max_idx=i;
            if(arr[i]<arr[min_idx]) min_idx=i;

            sum+=arr[i];
        }
        System.out.println("최대 시간대 : "+max_idx+"시");
        System.out.println("최소 시간대 : "+min_idx+"시");
        System.out.println("평균 : "+sum/(double)arr.length+"명");

        double[] score = {80.75,59.7,60.5,78.8,96.8,100.0,45.21,63.66,45.2,56.48,98.6,94.89,78.9,49.87,88.97,78.9};
        int count=0;
        for(int i=0;i<score.length;i++){    
            if(score[i]>=60) count++;
        }
        System.out.println("합격률 : "+(count/(double)score.length)*100+"%");
        System.out.println("불합격률 : "+((score.length-count)/(double)score.length)*100+"%");

        int[] covid={32451,29581,25434,13296,35177,31352,28130};
        int total=0;
        double avg=0;
        for(int i=0;i<covid.length;i++){
            total +=covid[i];
        }
        avg = total/(double)covid.length;
        Scanner s = new Scanner(System.in);
        System.out.print("감염자 수를 입력하세요 : ");
        int input = s.nextInt();
        if(input>=avg) System.out.println("코로나 감염 주의 단계 : 위험");
        else System.out.println("코로나 감염 주의 단계 : 주의");
        s.close();
    }
}
