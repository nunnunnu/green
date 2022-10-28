public class LoopEx4 {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println("반복합니다.");
            // break;
            if(i==5) break;
        }
        int i=0;
        int sum=0;
        // while(sum<1000){
        // while(true){
        //     sum = sum+i;
        //     i++;
        //     if(sum>=1000) break;
        // }
        for(;;){
            sum = sum+i;
            i++;
            if(sum>=1000) break;
        }
        System.out.println("누적 횟수 : "+i+", 총 합 : "+sum);
    }
}
