import java.util.Scanner;

public class OperatorEx {
    public static void main(String[] args) {
        //연산자
        //1.부호, 2.산술, 3.비교, 4.논리, 5.비트, 6.증가감소, 7.대입
        //8.조건선택
        //1.단항 (부호, 증가감소, typecasting)
        //2.이항 (산술, 비교, 논리, 비트, 대입)
        //3.삼항 (조건선택)

        //1.부호연산자
        int value1 = -10+20; //10
        System.out.println(value1);
        int value2 = (int)10.23 * 10; 
        System.out.println(value2); //100나옴
        int value3 = (int)(10.23 * 10); 
        System.out.println(value3); //102나옴
        int r = (int)Math.random()*10; 
        System.out.println(r); 
        //무조건 0나옴. Math.random이 0.xxxxx...이 나오는데 (int)처리되서 0됨. 0*10인꼴
        //(int)(Math.random*10) 으로 해야 원하는 값이 나옴

        //2.산술연산자
        int result1 = 10 + 20;
        int result2 = result1 + 20;
        int result3 = result1 + result2;
        int result4 = 10+20*5/3-10; // * / + - 순서로 계산됨
        System.out.println(result4);

        //3.비교연산(대소비교, 동일비교)
        boolean b1 = result3 == result2;
        boolean b2 = result2 != 20;
        System.out.println(b1);
        System.out.println(b2);

        boolean b3 = result3>=200; //이상
        boolean b4 = result3<=200; //이하
        boolean b5 = result3>200; //초과
        boolean b6 = result3<200; //미만
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);

        //논리연산 (&&, ||, !)
        // final int PRICE = 8000; //가격
        // Scanner s = new Scanner(System.in);
        // final int STANDARD_PRICE = s.nextInt(); //점심값사용가능금액
        // s.close();
        // int money = 10000; //현금
        // int balance = 5000; //계좌
        // System.out.println(money>=PRICE || balance >= PRICE? "구매가능":"구매불가능");
        // System.out.println(money>=PRICE && PRICE<=STANDARD_PRICE?"구매가능":"구매불가능");

        double bmi=25.5;
        System.out.println("저체중 인가? "+(bmi>=0 && bmi<18.5));
        System.out.println("정상체중 인가? "+(bmi>=18.5 && bmi<23));
        System.out.println("과체중 인가? "+(bmi>=23 && bmi <25));
        System.out.println("비만 인가? "+(bmi>=25 && bmi <30));
        System.out.println("고도비만 인가? "+(bmi>=30));
        
        boolean power = false;
        System.out.println("전원이 켜져있나?"+power);
        power = !power; //toggle
        System.out.println("전원이 켜져있나?"+power);
        power = !power;
        System.out.println("전원이 켜져있나?"+power);
        power = !power;
        System.out.println("전원이 켜져있나?"+power);
        power = !power;
        System.out.println("전원이 켜져있나?"+power);
        power = !power;
        System.out.println("전원이 켜져있나?"+power);
        power = !power;
        System.out.println("전원이 켜져있나?"+power);
        power = !power;
        System.out.println("전원이 켜져있나?"+power);
        power = !power;
        System.out.println("전원이 켜져있나?"+power);
        power = !power;

        String phone_manufacturer[] = {"삼성전자","Apple","샤오미","Oppo","화웨이","LG"};
        for(int i=0;i<phone_manufacturer.length;i++){
            if(phone_manufacturer[i].equals("LG")) System.out.println(phone_manufacturer[i]);
        }

        // 5.증감감소연산자(증감문)
        int number = 0;
        number++;
        System.out.println(number); //1
        number--;
        System.out.println(number); //0
        System.out.println(number++);//0
        System.out.println(++number);//2
        System.out.println(number--);//2
        System.out.println(--number);//0

        int i=0;
        while(i<phone_manufacturer.length)
            System.out.println(phone_manufacturer[i++]);

        //6. 대입연산
        int num = 10+20; 
        num += 10; 
        num -= 10; 
        num /= 10; 
        num *= 10; 
        num %= 10; 
        System.out.println(num);
        System.out.println(args[0]);

    }
}
