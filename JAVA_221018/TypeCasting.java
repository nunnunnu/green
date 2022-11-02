public class TypeCasting {
    public static void main(String[] args) {
        //묵시적 형변환
        byte a = 10; //10은 int형인데 자동으로 byte형 변환해줌
        System.out.println(a);
        int b=a;
        System.out.println(b); //10 출력됨. byte를 int로 자동 형변환한것
        // short c=b; //에러남. short가 int보다 작기때문에 데이터유실이 일어날 수도 있음. 
        //형변환을 사용하려면 명시적 형변환을 사용해야함
        //명시적 형변환
        short c = (short)b;//데이터 유실 위험있음
        System.out.println(c); //10출력

        double d1 = 10.99;
        System.out.println(d1);
        int i1 = (int)d1; 
        System.out.println(i1); //10출력. 소수점 버림
        i1=(int)(d1*10);
        d1=i1/10.0;
        System.out.println(d1); //강제로 잘랐기때문에 값이 비정확할수도있음
        //long -> int 형변환에서 가낭 오버플로우가 많이일어남
        int i2 = (int)1000000000000000L;
        System.out.println(i2); //-1530494976출력됨

        char ch ='A';
        int i3 = ch;
        System.out.println(i3);
    }
}
