public class OperatorEx222 {
    public static void main(String[] args) {
        System.out.println(10+20);
        System.out.println(10-20);
        System.out.println(10*20);
        System.out.println(10/20); //int/int = int
        System.out.println(10/20.0); //int/double -> double/double = double
        System.out.println(10%3); //나머지연산자 - 10을 3으로 나누었을때 나머지 값
        System.out.println(10%2); //0 
        System.out.println(10%4); //2
        //(게시판 글의수가 123, 페이지당 10씩일때 총 페이지수는?)
        //123%10>0 ? +1 : 0 (소수점 올림 쓰면 안써도되긴하지만 정확도가 떨어짐)

        int value = 100;
        System.out.println(value);
        System.out.println(value+50);
        //여기에서 value값은? 100
        System.out.println(value);
        System.out.println(value = value+50); //value의 값이 변경됨
        System.out.println();
        System.out.println(value+50);
        System.out.println(value-50);
        System.out.println(value*50);
        System.out.println(value/50);
        System.out.println();
        int value2 = 20;
        System.out.println(value2+value);
        System.out.println(value2-value);
        System.out.println(value2*value);
        System.out.println(value2/value);
        
        System.out.println("Hello"+"World!!");
        String ext = ".png";
        System.out.println("img"+ext);
        System.out.println("profile"+1+ext);
        //"profile1" + ".png" -> "profile1.png"
        System.out.println("profile"+(1+3)+ext); //profile14.png 출력
        
    }
}
