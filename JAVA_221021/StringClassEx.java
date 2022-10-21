import java.util.Arrays;

public class StringClassEx {
    public static void main(String[] args) {
        String str1= "Hello";
        System.out.println(str1);
        String str2 = new String("Hello");
        System.out.println(str2);

        str1 = str1 + 10 + 20 ;
        System.out.println(str1); //Hello1020 출력

        String str3 = "Java Programming";
        System.out.println(str3.length()); //공백까지 셀려서 16출력
        System.out.println(str3.substring(0, 4)); //0<=x<4 
        System.out.println(str3.substring(5, 16)); //5<=x<16
        String str4 = str3.substring(0, 4);
        System.out.println(str4); 
        String str5 = str3.substring(5, 16); 
        System.out.println(str5);
        System.out.println(str3.contains("Java")); //str3이 "java"를 포함하고 있는가? true출력됨
        System.out.println(str3.contains("python")); //str3이 "python"를 포함하고 있는가? false출력됨
        System.out.println(str3.indexOf("Java")); //Java가 몇번째 문자열부터 시작되는가? 없으면 -1 출력.  0출력됨
        System.out.println(str3.replaceAll("Java", "Python")); //Java를 Python으로 변경. Python Programming 출력됨
        System.out.println(str3);//값을 대체시킨것이 아니라서 str3의 값은 그대로임

        System.out.println(str3.equals("Java Programming"));//괄호안의 문자열과 완전히 일치하는가? true출력
        System.out.println(str3.equalsIgnoreCase("java programming")); //대소문자구분안하고 완전히일치하는가? true출력
        
        System.out.println(str3.toUpperCase()); //전부 대문자
        System.out.println(str3.toLowerCase()); //전부 소문자
        String splitStr = "1,2,3,4,5,6,7,8,9";
        System.out.println(splitStr.split(","));
        String arr[] = splitStr.split(","); //spliter - 구분이되는 문자기준. 여기서는 "," 임
        System.out.println(Arrays.toString(arr));

    }
}
