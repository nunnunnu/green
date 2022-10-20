public class RandomEx2 {
    public static void main(String[] args) {
        System.out.println((int)(Math.random()*10)); //0~9
        System.out.println((int)(Math.random()*100)); //0~99
        System.out.println((int)(Math.random()*100)+1); //1~100
        double d1 = 1.23;
        double d2 = 1.88;
        double d3 = 1.67;
        System.out.println(Math.round(d3));
        System.out.println(Math.ceil(d1)); //올림
        System.out.println(Math.floor(d2)); //내림
        int arr [] = {1,2,3,4,5};
        System.out.println(arr[(int)(Math.random()*arr.length)]);
    }
}
