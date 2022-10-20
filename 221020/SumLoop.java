public class SumLoop {
    public static void main(String[] args) {
        int sum = 0;
        int i=1;
        while(sum < 100) {
            if      (i%2==1)      sum+=i;
            else if (i%2==0)      sum-=i;           
            i++;
        }
        System.out.println(i);

        sum=0;
        int count = 0;
        for(i=1;true;i++){
            if(i%2==0) i*=-1;
            sum+=i;
            count++;
            if(sum>=100) break;
            i=Math.abs(i);
        }
        i=1;
        while(sum<100){
            if(i%2==0) i*=-1;
            sum+=i;
            i=Math.abs(i);
            count++;
            i++;

        }
        System.out.println(count);

    }
}
