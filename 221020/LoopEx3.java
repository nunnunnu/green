public class LoopEx3 {
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            System.out.println("Hello");
        }
        int i=0;
        while(i<3){
            System.out.println("Hello");
            i++;
        }
        for(i=0;i<3;i++){
            System.out.println("Hello");
        }
        int value = 10;
        for(i=0;i<3;i++){
            // int value =10;
            System.out.println("Hello");
            value++;
            System.out.println(value);
        }
        System.out.println(value);

        int sum = 0;
        int j=0;
        while(sum<=100){
            System.out.println("sum : "+sum);
            // sum +=++j;
            j++;
            sum+=j;
            
        }
    }
}