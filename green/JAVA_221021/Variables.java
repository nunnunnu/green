public class Variables {
    public static void main(String[] args) {
    //     //정수
    //     // byte val1 = 10000;
    //     // short val2 = 100000;
    //     // int val3 = 10000000000; 
    //     long val4 = 10000000000L;
    //     long val5 = 10000000000l; //대소문자 둘다 가능
    //     // System.out.println(val1);
    //     // System.out.println(val2);
    //     // System.out.println(val3);
    //     System.out.println(val4);

    //     //실수
    //     float f1 = 10.23f;
    //     double d1 = 10.23;
    //     System.out.println(f1);
    //     System.out.println(d1);

    //     //논리
    //     boolean b1 = false;
    //     System.out.println(b1);

    //     //문자
    //     char ch = ' ';
    //     System.out.println(ch);

    //     //참조
    //     String str = new String("Hello World");
    //     System.out.println(str);
        System.out.println("double size : "+Double.BYTES);
        System.out.println("byte min : "+Byte.MIN_VALUE+", byte max : "+Byte.MAX_VALUE);
        System.out.println("Short min : "+Short.MIN_VALUE+", Short max : "+Short.MAX_VALUE);
        System.out.println("int min : "+Integer.MIN_VALUE+", int max : "+Integer.MAX_VALUE);
        System.out.println("long min : "+Long.MIN_VALUE+", long max : "+Long.MAX_VALUE);
        System.out.println("float min : "+Float.MIN_VALUE+", float max : "+Float.MAX_VALUE);
        System.out.println("double min : "+Double.MIN_VALUE+", double max : "+Double.MAX_VALUE);

        /*  double size : 8
            byte min : -128, byte max : 127
            Short min : -32768, Short max : 32767      
            int min : -2147483648, int max : 2147483647
            long min : -9223372036854775808, long max : 9223372036854775807
            float min : 1.4E-45, float max : 3.4028235E38
            double min : 4.9E-324, double max : 1.7976931348623157E308 
            출력됨
            */

            Integer i = 1000;
            int aa = 100; 
            System.out.println(i);
            System.out.println(aa); //두개 차이없음
            System.out.println(args[0]);

            
    }
}
