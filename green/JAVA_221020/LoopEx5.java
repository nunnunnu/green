public class LoopEx5 {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            System.out.println("반복합니다"+i);
            if(i%3==0) continue; //필터링 역할
            System.out.println("continue 다음 출력");
        }
    }
}
