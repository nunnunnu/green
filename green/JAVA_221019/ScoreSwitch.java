import java.util.Scanner;

public class ScoreSwitch {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("점수를 입력하세요. > ");
        int score = s.nextInt();

        switch(score/10){
        case 10: case 9:
            System.out.println("A");
            break;
            case 8:
            System.out.println("B");
            break;
            case 7:
            System.out.println("C");
            break;
            case 6:
            System.out.println("D");
            break;
        default :
            System.out.println("F");
        }
        s.close();
        //100점이 넘는것도 입력이 가능함. 입력값을받을때는 if문을 써야함
    }
}
