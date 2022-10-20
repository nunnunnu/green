import java.util.Scanner;

public class UpAndDown {
    public static void main(String[] args) {
        int answer = (int)(Math.random()*100)+1 ;
        int input = 0; // 사용자입력을 저장할 공간
        int count = 0; // 시도횟수를 세기위한 변수
        // Scanner 화면으로 부터 사용자입력을 받기 위해서 클래스 사용
        Scanner s = new Scanner(System.in);
        while (true) {
            count++;
            System.out.print("1과 100사이의 값을 입력하세요 :");
            input = s.nextInt(); // input . 입력받은 값을 변수 에 저장한다

            if(input < answer) System.out.println("입력한 값이 정답보다 작습니다.");
            else if(input > answer) System.out.println("입력한 값이 정답보다 큽니다.");
            else { 
                System.out.println("정답입니다.");
                System.out.println("시도횟수는 "+count+"번 입니다.");
                break;
            }

        }
    }
}