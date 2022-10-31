package JAVA_221027;

public class MethodEx {
    public static void main(String[] args) {
        System.out.println(add(10,20)); //메소드 호출
        add(50,30); //계산한 값을 저장하거나 출력할 수 없음.
        print_add(50, 30); //80출력됨. 따로 변수에 저장은 불가능
        // int a = print_add(50, 30); //에러.
        System.out.println(rating(95)); //A+
        System.out.println(rating(91)); //AO
        System.out.println(rating(65)); //D+
        System.out.println(rating(83)); //BO
        System.out.println(rating(72)); //CO
        System.out.println(rating(1000)); //Error
        System.out.println(rating(-100)); //Error
        System.out.println(rating(100)); //A+
        ageRating(15); //청소년
        ageRating(25); //성인
        ageRating(5); //어린이
        ageRating(-100); //입력값이 잘못되었습니다.
        // System.out.println(ageRating(50)); //에러남. 

        System.out.println(getPI());
        System.out.println((int)(getPI()*100)/100.0);
        
        System.out.println(getArea(5));

        showMenu();
    }
    //메소드 정의
    //출력값이 정수(int). 2개의 int타입을 입력받음. 입출력이 모두 있는 메소드
    public static int add(int a, int b){ //main의 10,20값을 a,b에 복사해옴
        int result=a+b;
        return result; //return : 안쪽에 있는 변수의 값을 밖으로 날려라는 뜻
    }
    public static void print_add(int a,int b){
        System.out.println(a+b);
    }
    
    //입력있고 출력없음. 
    public static String rating(int score){
        // String grade = "";
        if(score>100){
            // grade="Error";
            return "Error";
        }
        else if(score>=90){
            // grade="A"+(score>=95?"+":"O");
            return "A"+(score>=95?"+":"O");
        }
        else if(score>=80){
            // grade="B"+(score>=85?"+":"O");
            return"B"+(score>=85?"+":"O");
        }
        else if(score>=70){
            // grade="C"+(score>=75?"+":"O");
            return"C"+(score>=75?"+":"O");
        }
        else if(score>=60){
            // grade="D"+(score>=65?"+":"O");
            return "D"+(score>=65?"+":"O");
        }
        else if(score>=0){
            // grade="F";
            return "F";
        }
        else{
            // grade="Error";
            return "Error";
        }
        // return grade;
    }
    public static void ageRating(int age){
        if(age<0){
            System.out.println("입력값이 잘못되었습니다");
        }
        else if(age >=18){
            System.out.println("성인입니다.");
        }
        else if(age>=14){
            System.out.println("청소년입니다.");
        }
        else {
            System.out.println("어린이입니다.");
        }
    }
    //출력있고 입력없음
    public static double getPI(){
        return 3.141595653589793238;
    }
    //메소드안에서 메소드 사용 가능
    public static double getArea(double r){
        return getPI()*r*r;
    }

    //입력, 출력 없는 형태
    public static void showMenu(){
        System.out.println("========================================");
        System.out.println("            1. 회원 가입");
        System.out.println("            2. 로그인");
        System.out.println("            3. 회원정보 수정");
        System.out.println("            4. 회원 탈퇴");
        System.out.println("            5. 회원 목록 보기");
        System.out.println("            0. 종료");
        System.out.print("선택 : > ");
    }
}