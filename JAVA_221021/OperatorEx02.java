public class OperatorEx02 {
    public static void main(String[] args) {
        //조건선택연산(삼항연산자)
        // int age = 15;
        // String msg = age > 18?"성인":"미성년";
        // System.out.println(msg);
        // msg = age > 18?"성인":age>=14?"청소년":"어린이";
        // System.out.println(msg);
        // Scanner s = new Scanner(System.in);
        // System.out.print("숫자를 입력해주세요. : > ");
        // int value = s.nextInt();
        // System.out.println(value > Byte.MAX_VALUE?"Byte에 저장불가":"Byte에 저장가능");
        
        int postnumber = (int)(Math.random()*500)+55; 
        final int POST_PER_PAGE = 15;
        // int page = postnumber / POST_PER_PAGE + (postnumber%POST_PER_PAGE>0?1:0);
        int page =(int)(Math.ceil(postnumber /(double)POST_PER_PAGE));
        System.out.println("게시글 수: "+postnumber+", 총 페이지 수" +page);

        

    }
}
