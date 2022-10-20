import java.util.ArrayList;
import java.util.List;

public class ArrayEx01 {
    public static void main(String[] args) {
        int arr[] = new int[3]; //생성(선언)
        // int i=0;
        // arr[i] = (i+1)*10;
        // System.out.println(arr[i]);
        // i++;
        // arr[i] = 20;
        // System.out.println(arr[i]);
        // i++;
        // arr[i] = 30;
        // System.out.println(arr[i]);
        for(int i=0;i<3;i++){
            arr[i] = (i+1)*10;
            System.out.println(arr[i]);
        }
        arr = new int[5]; //덮어쓰기 (정적 - static)

        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10);
        list.add(10); //컬렉션 프레임워크. 추가하는대로 배열의 길이가 늘어남.
    }
    
}
