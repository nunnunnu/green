public class jungsukEx4_2 {
    public static void main(String[] args) {

        //4-2
        int sum=0;
        for(int i=1;i<=20;i++){
            if(!(i%2==0 || i%3==0)) sum+=i;
        }
        System.out.println(sum);
        sum=0;
        for(int i=1;i<=20;i++){
            if(i%2==0 || i%3==0) continue;
            sum+=i;
        }
        System.out.println(sum);

        for(int i=1;i<=20;i++){

        }
        
        //4-3
        sum=0;
        int result=0;
        for(int i=1;i<=10;i++){
            sum+=i;
            result+=sum;
        }
        System.out.println(result);

        //4-4
        sum=0;
        int count = 0;
        for(int i=0;true;i++){
            if(i%2==0) i*=-1;
            sum+=i;
            if(sum>=100) break;
            count++;
            i=Math.abs(i);
        }
        int i=1;
        while(sum<100){
                if(i%2==0) i*=-1;
                sum+=i;
                i=Math.abs(i);
                count++;
                i++;

        }
        System.out.println(count);

        //4-5
        i=0;
        while(i<=10){
            int j=0;
            while(j<=i){
                System.out.print("*");
                j++;
            }
            i++;
            System.out.println();
        }

        //4-6
        for(i=1;i<=6;i++){
            for(int j=1;j<=6;j++){
                if(i+j==6) System.out.println(i+", "+j);
            }
        }

        //4-8
        for(i=0;i<=10;i++){
            for(int j=0;j<=10;j++){
                if(2*i + 4*j == 10) System.out.println("x = "+i+", y = "+j);
            }
        }

        //4-9
        String str ="12345";
        sum=0;
        for(i=0;i<str.length();i++){
            char c = str.charAt(i);
            sum +=(c-'0');
        }
        System.out.println(sum);

        //4-10
        int num = 12345;
        sum=0;
        while(num>0){
            sum += num%10;
            num=num/10;
        }
        System.out.println("sum : "+sum);
    }
}
