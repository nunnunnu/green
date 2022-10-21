import java.util.Arrays;

public class LoopEx01 {
    public static void main(String[] args) {

        //배열
        int arr[] =new int[5];
        System.out.println(arr[4]);
        arr[0]=10;
        arr[1]=20;
        arr[2]=30;
        arr[3]=40;
        arr[4]=50;
        System.out.println(arr[0]+30);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
        System.out.println(arr[4]);
        System.out.println();
        for(int i=0;i<arr.length;i++){
            arr[i]=(i+1)*10;
            System.out.println(arr[i]);
        }
        System.out.println();
        int arr2[] = new int[8];
        for(int i=0;i<arr2.length;i++){
            arr2[i]=(i+1)*5;
            System.out.println(arr2[i]);
        }
        System.out.println();
        int arr3[] = {10,20,30};
        int arr4[] = arr3; //arr3의 메모리주소를 arr4에 대입함. arr3가 수정되면 arr4도 동기화됨
        System.out.println(arr3[0]);
        System.out.println(arr4[0]);
        
        arr3[0]=100;
        System.out.println(arr3[0]);
        System.out.println(arr4[0]);
        System.out.println();

        int arr5[] = new int[arr4.length];
        System.arraycopy(arr4, 0, arr5, 0, arr5.length);
        arr4[0]=50;
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(arr5));

        // for(int i=0;i<5;i++) {
        //     if(i%2==1)
        //     System.out.println(i);
        // }
        // int i=0;
        // while(i<5){
        //     if(i%2==1)
        //     System.out.println(i);
        //     i++;
        // }
    }
}
