import java.util.Arrays;

public class ArrayEx03 {
    public static void main(String[] args) {
        int arr[] = {10,20,30};
        // int arr2[] = arr;
        int arr2[] = new int[arr.length];
        // System.out.println("before");
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr2));
        // arr[0]=100;
        // System.out.println("after");
        // System.out.println(Arrays.toString(arr));
        // System.out.println(Arrays.toString(arr2));
        //둘다 0번째 자리 값이 바뀜. arr2가 arr의 주소값을 받아왔기때문임. 레퍼런스 타입의 특징임!!!
        //배열 복사
        System.out.println();
        System.arraycopy(arr, 0, arr2, 0, 3);
        System.out.println("before");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
        arr[0]=100;
        System.out.println("after");
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr2));
    }
}
