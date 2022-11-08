import java.util.Arrays;

public class Ex9_10 {
    public static void main(String[] args) {
        String str = "가나다";
        System.out.println(format(str,7,0));
        System.out.println(format(str,7,1));
        System.out.println(format(str,7,2));
        
    }
    public static String format(String str, int length, int alignment){
        if(length<str.length()){
            return str.substring(0, length);
        }else{
            char[] c = new char[length];
            Arrays.fill(c, ' ');
            String result="";
            if(alignment==0){
            
            }else if(alignment==1){

            }else if(alignment==2){
            
            }else{
                System.out.println("번호를 잘못입력하셨습니다");
            }
            return result;
        }
    }
}
