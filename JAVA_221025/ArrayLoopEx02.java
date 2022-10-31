package JAVA_221025;

import java.util.Scanner;

public class ArrayLoopEx02 {
    public static void main(String[] args) {
        //제일 높은 시간대, 낮은 시간대, 평균
        int[] arr = {199,165,90,107,89,99,195,284,307,598,545,674,726,581,560,673,498,908,944,742,429,489,402,307}; //시간대별무단횡단
        int max_idx=0,min_idx=0,sum=0; //최대치 인덱스, 최소치인덱스, 총합계
        for(int i=0;i<arr.length;i++){
            if(arr[i]>arr[max_idx]) max_idx=i; //지금 비교하는 arr의 i번째값이 최대치자리수의 값보다 크다면 max_idx변경
            if(arr[i]<arr[min_idx]) min_idx=i;//지금 비교하는 arr의 i번째값이 최소치자리수의 값보다 작다면 min_idx변경

            sum+=arr[i]; //총 합계
        }
        System.out.println("최대 시간대 : "+max_idx+"시"); //최대인원의 시간대
        System.out.println("최소 시간대 : "+min_idx+"시"); //최소인원의 시간대
        System.out.println("평균 : "+sum/(double)arr.length+"명"); //총합계/(double형변환)하루시간 -> 평균 출력

        double[] score = {80.75,59.7,60.5,78.8,96.8,100.0,45.21,63.66,45.2,56.48,98.6,94.89,78.9,49.87,88.97,78.9}; //점수배열
        int pass_cnt=0; //합격자수
        for(int i=0;i<score.length;i++){ //16회 반복(i=0~15)    
            if(score[i]>=60) pass_cnt++; //i번째 위치하는 데이터가 60이상이면 합격 pass_cnt 1 증가
        }
        //합불/합격률 계산
        System.out.println("합격률 : "+(pass_cnt/(double)score.length)*100+"%"); 
        //합격한사람/(double형으로변환)전체응시인원수*100 -> double형 평균 산출
        System.out.println("불합격률 : "+((score.length-pass_cnt)/(double)score.length)*100+"%");
        //(전체응시인원수-합격한사람)/(double형으로변환)전체응시인원수*100 -> double형 평균 산출
        //만약 조건에 변경이있을확률이있으면 (ex.0점 미응시자) 불합격인원수도 변수로 지정해서 for문에서 같이적어줘야 덜번거로움

        int[] covid={32451,29581,25434,13296,35177,31352,28130}; //코로나 확진자수
        int total=0; //전체 합
        double avg=0; //평균
        for(int i=0;i<covid.length;i++){ //전체 합계 구하는 for문
            total +=covid[i];
        }
        avg = total/(double)covid.length; //전체합계/(double형 변환)총 일자 - double형 굳이 안해줘도됨
        Scanner s = new Scanner(System.in);
        System.out.print("감염자 수를 입력하세요 : ");
        int input = s.nextInt(); //오늘 감염자수 입력
        if(input>=avg) System.out.println("코로나 감염 주의 단계 : 위험"); //오늘의 단계.평균이상이면 위험
        else System.out.println("코로나 감염 주의 단계 : 주의"); //오늘의 단계. 평균미만이면 주의
        s.close();
    }
}