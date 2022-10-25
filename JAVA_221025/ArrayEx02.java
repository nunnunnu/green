package JAVA_221025;

public class ArrayEx02 {
    public static void main(String[] args) {
        int[] arr1= {10,20,30};
        int[] arr2 = arr1;

        System.out.println("=====before");
        System.out.println("arr1[0] : "+arr1[0]+" / arr2[0] : "+arr2[0]);
        System.out.println("arr1[1] : "+arr1[1]+" / arr2[1] : "+arr2[1]);
        System.out.println("arr1[2] : "+arr1[2]+" / arr2[2] : "+arr2[2]);
        arr1[0] =100;
        System.out.println("=====after");
        System.out.println("arr1[0] : "+arr1[0]+" / arr2[0] : "+arr2[0]);
        System.out.println("arr1[1] : "+arr1[1]+" / arr2[1] : "+arr2[1]);
        System.out.println("arr1[2] : "+arr1[2]+" / arr2[2] : "+arr2[2]);
        System.out.println();
        int[] arr3= {10,20,30};
        int[] arr4 = new int[arr3.length];
        System.arraycopy(arr3, 0, arr4, 0, 3);

        System.out.println("=====before");
        System.out.println("arr3[0] : "+arr3[0]+" / arr4[0] : "+arr4[0]);
        System.out.println("arr3[1] : "+arr3[1]+" / arr4[1] : "+arr4[1]);
        System.out.println("arr3[2] : "+arr3[2]+" / arr4[2] : "+arr4[2]);
        arr3[0] =100;
        System.out.println("=====after");
        System.out.println("arr3[0] : "+arr3[0]+" / arr4[0] : "+arr4[0]);
        System.out.println("arr3[1] : "+arr3[1]+" / arr4[1] : "+arr4[1]);
        System.out.println("arr3[2] : "+arr3[2]+" / arr4[2] : "+arr4[2]);
    }
}
