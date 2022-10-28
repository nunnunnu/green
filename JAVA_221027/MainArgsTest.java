package JAVA_221027;

public class MainArgsTest {
    public static void main(String[] args) {
        System.out.println(args.length);
        for(int i=0;i<args.length;i++){
            System.out.println(args[i]);
        }
        if(args[0].equals("-version")){
            System.out.println("Program Version : 0.1");
        }else{
            System.out.println("BAD Command"+args[0]);
        }
    }
}
