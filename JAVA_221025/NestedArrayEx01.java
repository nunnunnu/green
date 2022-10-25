package JAVA_221025;

public class NestedArrayEx01 {
    public static void main(String[] args) {
        int[][] arr= {
            {10,20,30},
            {40,50,60},
            {70,80,90}
        };
        System.out.println(arr[0]); //주소값 출력
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        int[][] score = {
            {75,81,79},
            {95,94,90},
            {65,64,61},
            {85,90,80},
            {75,66,73},
        };
        String[] name = {"송영윤","허종희","정승남","고형기","정현정"};
        String[] subject ={"국어","영어","수학"};
        System.out.print("        ");
        for(int i=0;i<subject.length;i++){
            System.out.print(subject[i]+" ");
        }
        System.out.println();
        for(int i=0;i<score.length;i++){
            System.out.print(name[i]);
            for(int j=0;j<score[i].length;j++){
                System.out.printf("%5d",score[i][j]);
            }

            System.out.println();
        }
    }
}
