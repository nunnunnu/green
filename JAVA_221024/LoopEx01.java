package JAVA_221024;

// import java.io.BufferedReader;
// import java.io.IOException;
// import java.io.InputStreamReader;

public class LoopEx01 {
    public static void main(String[] args) //throws IOException
    {
        for(int i=0;i<3;i++){
            System.out.println("for반복:"+i);
        }
        
        int i=0;
        while(i<3){
            System.out.println("while반복:"+i);
            i++;
        }


        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int dan = Integer.parseInt(br.readLine());
        // for(int i=1;i<=9;i++){
        //     System.out.println(dan+" X "+i+" = "+dan*i);
        // }

        String str = "Hello World!!";
        for(i=0;i<str.length();i++){
            if(str.charAt(i)=='l') continue;
            System.out.println(i+" : "+str.charAt(i));
            // if(str.charAt(i)=='o') break;
        }
        i=0;
        while(i<str.length()){
            if(str.charAt(i)=='l') {
                i++;
                continue;
            }
            System.out.println(i+" : "+str.charAt(i));
            i++;    
        }
    }
}
