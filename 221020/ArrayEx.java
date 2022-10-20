public class ArrayEx {
    public static void main(String[] args) {
        int arr[] = new int[5];
        //배열 요소의 초기화
        System.out.println(arr);
        for(int i=0;i<arr.length;i++){
            arr[i]=(i+1)*10;

        //배열 요소의 조회
        System.out.println(arr[i]);//인덱스 기반 조회방법
        } 

        //arr배열의 첫번째부터 차례대로 접근해서 조회
        //조회된 값을 i에 복사
        for(int i:arr){
            System.out.println(i);
        } //무조건 처음부터 끝까지 순차조회
    }
}
