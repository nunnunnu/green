public class AccEx {
    public static void main(String[] args) {
        int sum=0;
        int total=0;
        for(int i=1;i<=10;i++){
            sum+=i;
            System.out.println("sum : "+sum+", i : "+i);
            total+=sum;
        }
        System.out.println(total);

        
    }
}
