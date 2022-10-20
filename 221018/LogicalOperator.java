public class LogicalOperator {
    public static void main(String[] args) {
        final int PRICE = 15000; //가격
        int balance =10000; //계좌잔액
        double discount =20; //할인율
        int coupon = 20; //쿠폰
        boolean result = balance >= PRICE *(1-discount) || coupon >=15;
        System.out.println("주문 가능?"+result);

        int age =10;

        System.out.println("청소년?"+(age>=14 && age <18));
        System.out.println("청소년아닌가?"+!(age>=14 && age <18));

        int i=10;
        i++; //1증가. i+1보다 빠름
        i--; //1감소
        //선사용 후처리
        System.out.println(i++); //이렇게 잘 안함 헷갈릴수도있음. 단독으로 쓰는 것을 추천
        System.out.println(i--);
        //선처리 후사용
        System.out.println(++i);
        System.out.println(--i);

        i+=3; //i=i+3과 같음
        System.out.println(i);
        
    }
    
}
