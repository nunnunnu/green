public class ConditionCheck2 {
    public static void main(String[] args) {
        // boolean money = true;
        int money = 4000;
        if(money>3500){
            System.out.println("택시타기");
        } else if(money>=1250) System.out.println("택시/지하철타기");
        else System.out.println("걸어가기");

        int score = 92;
        if(score>=90 && score<100) System.out.print("A"+detailScore(score));
        else if(score>=80) System.out.println("B"+detailScore(score));
        else if(score>=70) System.out.println("C"+detailScore(score));
        else if(score>=60) System.out.println("D"+detailScore(score));
        else if(score>=50) System.out.println("F"+detailScore(score));
    }
    public static String detailScore(int score){
        return score%10>=5?"+":"O";
    }
}
