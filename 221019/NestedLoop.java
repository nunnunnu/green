public class NestedLoop {
    public static void main(String[] args) {
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                System.out.println("i : "+i+" / j : "+j);
            }
            System.out.println();
        }
        for(int i=1;i<=7;i++){
            for(int j=1;j<=9;j++){
                System.out.println(i +" * "+j+" = "+i*j);
            }
            System.out.println();
        }

        // System.out.println("====구구단 while문 사용====");
        // int i=1, j=1;
        // while(i<=7){
        //     System.out.println(i +" * "+j+" = "+i*j);
        //     j++;
        //     if(j==9){
        //         i++;
        //         j=1;
        //         System.out.println();
        //     }
        // }
        for(int i=0;i<5;i++){
            for(int j=0;j<=i;j++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
