public class VariablesEx {
    public static void main(String[] args) {
        //주석기호(메모공간)
        //타입 변수명(식별자) = 값;
        //정수, 실수, 논리, 레퍼런스 타입(참조형, String)
        //정수 byte, short, int, long
        byte value1 = 10; //-127~128까지 표현 가능
        short value2=100; //-32236~32235
        int value3=10000; //-21억~+21억
        long value4 = 1000000000000000000L; 

        System.out.println(value1);
        System.out.println(value2);
        System.out.println(value3);
        System.out.println(value4);
        System.out.println();
        //실수 float, double
        float f =100000.11f; //정밀도가 떨어짐
        double d = 1000000.2222; 
        System.out.println(f);
        System.out.println(d);
        System.out.println();




    }
}
