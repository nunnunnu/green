import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputOutputEx {
  public static void main(String[] args) throws Exception {
    // InputStream input = new InputStream; //추상클래스라서 객체생성 불가
    // OutputStream output = new OutputStream(); //추상클래스라서 객체생성 불가
    //파일읽어오기
    BufferedReader reader = new BufferedReader( //속도향상을 위한 메모리 임시공간 제공
      new InputStreamReader(
        new FileInputStream(
          //상대경로방식의 표현방법(애매함)
          //리눅스시스템의 명령어 입력시 많이사용
          new File("aaa.txt") 
          // new File("../aaa.txt") //상위폴더를 가르킴
          // new File("../../aaa.txt") //상위폴더의 상위폴더
          //절대경로표시법
          // new File("/aaa.txt") //드라이브의 최상위(루트디렉토리)를 찾음.(현재예시에서는 D드라이브)
          // new File("D:/Students/jinhee/aaa.txt") //드라이브의 최상위(루트디렉토리)를 찾음.(현재예시에서는 D드라이브)
        )
      )
    );
    System.out.println(reader.read()); //76출력. 
    System.out.println((char)reader.read()); //L출력.
    System.out.println((char)reader.read()); //o출력.
    System.out.println((char)reader.read()); //r출력.
    System.out.println((char)reader.read()); //e출력.
    System.out.println((char)reader.read()); //m출력.
    System.out.println((char)reader.read()); //,출력.
    System.out.println((char)reader.read()); //i출력.
    System.out.println((char)reader.read()); //p출력.
    System.out.println(reader.readLine());//sum dolor sit amet consectetur adipisicing....(생략) 출력. 한줄읽어오기
    System.out.println(reader.readLine());
    System.out.println(reader.readLine());
    System.out.println(reader.readLine());
    
    reader.close(); //꼭 닫아야함

    BufferedWriter writer = new BufferedWriter(
      new OutputStreamWriter(
        new FileOutputStream(
          new File("bbb.txt"),true //실행할때마다 hello world추가됨
        )
      )
    );
    writer.write("hello world");
    writer.flush();
    writer.close();
  }
}
