package JAVA_221025;

public class ArrayLoopEx01 {
    public static void main(String[] args) {
        // int[] arr = new int[10];
        // for(int i=0;i<arr.length;i++){
        //     arr[i] = (i+1)*10;
        //     System.out.println(arr[i]);
        // }
        //시도별코로나감염자수
        int[] corona = {
            12888,10066,2032,2310,2641,1893,1831,1647,1046,1028,1369,1344,843,1443,771,141,439
        };
        //지역정보
        String[] region = {
            "경기", "서울", "경남", "부산", "인천",
            "경북", "대구", "충남", "전북", "전남", 
            "충북", "강원", "광주", "대전", "울산", 
            "제주", "세종"
        };
        int sum=0; 
        int max=-1; //최소값으로 초기화 -> 최대 확진자 수를 저장
        int min=Integer.MAX_VALUE; //최대값으로 초가화 -> 최소확진자수 저장
        int max_idx =0; //최대값의 배열인덱스
        int min_idx =0; //최소값의 배열인덱스
        for(int i=0;i<corona.length;i++){ //i값이 17미만일동일 반복
            //for문 활용 corona배열의 모든 값 출력
            //총 확진자 수 구하기
            sum +=corona[i]; //누적
            //최댓값 구하기
            if(max<corona[i]){ //변수 max가 corona배열의 i위치보다 작으면 max 수정
                max = corona[i];
                max_idx=i;
            }
            //최소값
            if(min>corona[i]){  //변수 min가 corona배열의 i위치보다 크면 min 수정
                min = corona[i];
                min_idx=i;
            }
        }
        System.out.println("일일 확진자 수 : "+sum); //합계
        System.out.println("지역별 최대 확진자 수 : "+max); //최대값출력
        System.out.println("지역별 최소 확진자 수 : "+min); //최소값출력
        System.out.println("최대 확진 지역 : "+region[max_idx]); //최대확진지역 이름
        System.out.println("최소 확진 지역 : "+region[min_idx]); //최소확진지역 이름

        
    }
}
