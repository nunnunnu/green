package JAVA_221025;

import java.io.File;
import java.io.FileReader;

public class FileReaderEx {
    public static void main(String[] args) throws Exception{
        File file = new File("JAVA_221025/test.txt"); //작업영역에 폴더를 여러개 열어서 폴더 명을 적어줘야함.
        FileReader reader = new FileReader(file);
        while(true){
            int rd = reader.read();
            if(rd == -1){
                break;
            }
            System.out.print((char)rd);
        }
        reader.close();
    }
}
