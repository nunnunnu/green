public class WrapperEx {
  public static void main(String[] args) {
    //wrapper Class
    Integer value =10;
    int value2= 20;
    value = null; //Integer가 클래스타입이라서 null가능. 
    // value2 = null; //null불가능. 
    value=10;
    System.out.println(value+value2);
    String s = "123456";
    System.out.println(s+100);
    System.out.println(Integer.parseInt(s)+100); //Warpper class의 핵심기능. 문자있으면 Exception뜸

    Byte v1 =100;
    Short v2 = 200;
    Integer v3 = 300;
    Long v4 = 400L;
    Float v5 = 1.23f;
    Double v6 = 1.23;
    Character v7 = 'a';
    Boolean v8 = false; //null도 가능하니까 사용자가 값을 입력하지않았을때 null로 두기위해 주로 사용함
    //전부 4byte
    // BigDecimal aa;
    // BigInteger bb;

    System.out.println(v1);
    System.out.println(v2);
    System.out.println(v3);
    System.out.println(v4);
    System.out.println(v5);
    System.out.println(v6);
    System.out.println(v7);
    System.out.println(v8);
    
  }
}
