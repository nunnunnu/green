import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class FileEx01 {
  public static void main(String[] args) throws Exception {
    //출력(파일에 쓰기)
    // BufferedWriter w = new BufferedWriter(
    //   new OutputStreamWriter(
    //     new FileOutputStream(
    //       // new File("a.txt")//재실행시 덮어쓰기함.
    //       new File("a.txt"),true //true - 뒤에 문자열 추가
    //     ), "UTF-8" //출력형식 지정
    //   )
    // );

    // w.write("안녕하세요");
    // w.close();
    // File f = new File("b.txt");
    // File f = new File("a.txt");
    File f = new File("prod.csv"); //엑셀 파일형식
    FileOutputStream os = new FileOutputStream(f);
    // OutputStreamWriter osw = new OutputStreamWriter(os, "MS949"); //텍스트 엑셀호환타입
    OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8"); //터미널출력을위해 UTF-8로 바꿈
    BufferedWriter writer = new BufferedWriter(osw);
    // writer.write("안녕");
    // writer.close();
    // writer.write("name,price,stock\r\n");
    for(int i =0;i<50;i++){
      Product p = new Product();
      p.name = "제품"+i;
      p.price = 20000;
      p.stock = 100;
      writer.write(p.toString()+"\r\n"); //"\r\n" - 파일에서 다음 줄로 이동. \r이 커서를 맨 앞으로 옮김

    }
    writer.close();

  
  }
}
