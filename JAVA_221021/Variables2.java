public class Variables2 {
    public static void main(String[] args) {
        //예약어(키워드) 사용 불가
        //public, static, void, String
        //int, short, byte, long, double, float, boolean, char
        //Integer, Short, Byte, Long, Double, Float, Boolean, Charater
        //if, for, while, new , delete, try, catch, class, private, protedcted
        //yield, return, goto.... 등 사용 불가
        //int static = 10; //오류
        
        //2개 이상 단어 사용불가(공백문자안됨)
        // int number of student = 10; //오류
        int number_of_studrent=10; //snake case
        int numberOfStudent = 10; //camel case 요즘은 이걸 더 많이 씀
        System.out.println(numberOfStudent);
        System.out.println(number_of_studrent);
        //숫자로 시작 불가
        // int 1number =10; //오류
        int number1 =10; //가능
        System.out.println(number1);
        //대소문자 구분
        // int apple, Apple, aPPle, appLe, appLE, APPLE; 
        //모두 다른 변수임. 그래도 이렇게 쓰지말기(유지보수 어렵게 할때 사용함[프리랜서작업시])
        // int Int = 10; //가능하나 쓰지말것
        // float Float = 10; //가능하나 쓰지말것

    }
}
