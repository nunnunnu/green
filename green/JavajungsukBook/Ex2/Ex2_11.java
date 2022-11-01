public class Ex2_11 {
    public static void main(String[] args) {
        float f= 9.1234567f;
        int i =Float.floatToIntBits(f); //float타입의 값을 int타입의 값으로 해석해서 반환

        System.out.printf("%f%n",f);
        System.out.printf("%x%n",i);

    }
}
