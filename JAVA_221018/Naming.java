public class Naming {
    public static void main(String[] args) {
        // int int =10; //오류남
        int Int=10; //되는데 권장 안함
        int numberofstudents =29; //되는데 권장 안함. 그냥 가독성 문제임
        int numberOfStudents=29;//camel case 이걸 더 많이 씀 둘중 하나로 통일 추천
        int number_of_Students=29;//snake case
        
        // int @#$#^^=10; //오류남
        int $$$=1;
        int $_$$$$ =1; //되는데 욕먹음
        
        int 숫자 =1; //가능한데 추천 안함. 한영키누르면 속도 느려짐
        // int a b c =1; //오류 띄어쓰기 안됨
        
        // int number_of_Students=29;//같은이름 두번 써서 오류

        //상수
        final int MAX_COUNT=255;
        // MAX_COUNT=200; //오류남 MAX_count는 final이 붙어서 수정 불가능함
        final double PI = 3.141592653589793; //대표적인 final예시

        //지수표현
        System.out.println(10e+10); //10의 10제곱 1.0E11출력
        System.out.println(10e-10); //10의 -10제곱  1.0E-9출력.

        byte b= (byte)250;
        System.out.println(b); //-6출력됨. 오버플로우

        System.out.println(MAX_COUNT);
        System.out.println(Int);
        System.out.println(numberOfStudents);
        System.out.println(number_of_Students);
        System.out.println(numberofstudents);
        System.out.println($$$);
        System.out.println($_$$$$);
        System.out.println(숫자);
        System.out.println(PI);

    }
}
