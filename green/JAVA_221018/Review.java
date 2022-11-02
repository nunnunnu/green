class Review{
    public static void main(String[] args){
        System.out.println("한 줄 출력하기");
        //주석 ctrl + /
        // System.out.print("그냥 출력1");
        // System.out.print("그냥 출력2");

        //변수
        //타입이름 변수이름; - 생성
        //변수이름 = 값; - 초기화
        //타입이름 변수이름 = 값;
        //변수의 데이터타입 : 정수형, 실수형, 논리형, 문자형, 참조형
        //정수형 - byte, shortm int long (default type = int)
        //1Byte, 2Byte, 4Byte, 8Byte
        byte bt1 = 10; //byte타입의 변수 bt1을 선언(정의)하고, 변수를 10으로 초기화
        System.out.println(bt1);
        bt1=20;
        System.out.println(bt1);
        // byte bt1 = 100; //에러, 변수 명 중복
        
        //실수형(float, double)
        double d1=10.23;
        System.out.println(d1);

        //문자형(char)
        char ch ='A';
        System.out.println(ch);

        //논리형
        boolean b1 = true;
        System.out.println(b1);
        b1 = false;
        System.out.println(b1);

        //참조형(reference Type)
        String str = new String("Hello");
        System.out.println(str);
        String str2=null;
        System.out.println(str2); //null출력. 문자열null이 출력된게 아니고 빈공간이라는 뜻임

        int a,b,c;
        a=b=c=100; //한번에 같은값 변수 3개에 넣기. 잘안씀
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        
        
    }
}