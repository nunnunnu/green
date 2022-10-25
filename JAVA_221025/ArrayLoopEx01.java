package JAVA_221025;

public class ArrayLoopEx01 {
    public static void main(String[] args) {
        // int[] arr = new int[10];
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = (i+1)*10;
        //     System.out.println(arr[i]);
        // }
        int[] corona = {
            12888,10066,2032,2310,2641,1893,1831,1647,1046,1028,1369,1344,843,1443,771,141,439
        };
        String[] region = {
            "경기", "서울", "경남", "부산", "인천",
            "경북", "대구", "충남", "전북", "전남", 
            "충북", "강원", "광주", "대전", "울산", 
            "제주", "세종"
        };
        int sum=0;
        int max=-1;
        int min=Integer.MAX_VALUE;
        int max_idx =0;
        int min_idx =0;
        for(int i=0;i<corona.length;i++){
            //for문 활용 corona배열의 모든 값 출력
            System.out.println(corona[i]);
            //총 확진자 수 구하기
            sum +=corona[i];
            //최댓값 구하기
            if(max<corona[i]){
                max = corona[i];
                max_idx=i;
            }
            //최소값
            if(min>corona[i]){ 
                min = corona[i];
                min_idx=i;
            }
        }
        System.out.println("일일 확진자 수 : "+sum);
        System.out.println("지역별 최대 확진자 수 : "+max);
        System.out.println("지역별 최소 확진자 수 : "+min);
        System.out.println("최대 확진 지역 : "+region[max_idx]);
        System.out.println("최소 확진 지역 : "+region[min_idx]);

        
    }
}
