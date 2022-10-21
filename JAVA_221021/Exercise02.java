public class Exercise02 {
    public static void main(String[] args) {
        String regNo="881120-1068234";
        System.out.println(regNo.substring(0,6));
        System.out.println(regNo.substring(7)); //7~regNo.length()까지

        System.out.println(regNo.split("-")[0]); //"-"기준으로 잘라서 배열의 첫번째자리
        System.out.println(regNo.split("-")[1]);
        System.out.println(regNo.split("-")); //[Ljava.lang.String;@2f92e0f4 출력
        System.out.println(regNo.charAt(7)=='1'||regNo.charAt(7)=='3'?"남":"여");
        int a = regNo.charAt(7);
        System.out.println(a); //49출력 -> 홀수면 남자, 짝수면 여자
        System.out.println(regNo.charAt(7)%2==0?"여자":"남자");

    }
}
