import java.util.Arrays;

public class ArrayEx02 {
    public static void main(String[] args) {
        int arr[] = new int[3];
        int arr2[] = {5,10,15};
        arr2[0] =55;

        double arr3[] = new double[3];
        arr3[0]=70;
        boolean arr4[] = new boolean[3];
        arr4[0] = true;
        char arr5[] = {'H','e','l','l','o',' ','W','o','r','l','d','!','\0'}; // \0 = null문자. 문자열의 끝을 나타내는 문자.
        // arr5[0]='a';
        String arr6[] = new String[3];
        arr6[0] = "abcd1234";

        String str = "Hello World!";
        System.out.println(str.charAt(0));
        System.out.println(str.toCharArray()[0]); //charAt(0)과 같은 것임
        System.out.println(str.substring(0, 5)); //Hello 나옴
        System.out.println(str.substring(6, 12)); //World 나옴

        String strArr[] = new String[5];
        String strArr2[] = {"asd","fgh","jkl"};
        for(int i=0;i<strArr2.length;i++){
            System.out.println(strArr2[i]);
        }
        System.out.println(Arrays.toString(strArr2));
    }
}
