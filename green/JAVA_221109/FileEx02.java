import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileEx02 {
  public static void main(String[] args) throws Exception {
    //파일 읽어오기
    BufferedReader reader = new BufferedReader(
      new InputStreamReader(
        new FileInputStream(
          new File("prod.csv")
        ),"UTF-8"
      )
    );
    // String line="";
    // while(line!=null){
    //   line = reader.readLine();
    //   System.out.println(line);
    // }
    List<Product> plist = new ArrayList<Product>();
    while(true){
      String line = reader.readLine();
      if(line == null) break;
      String[] split = line.split(",");
      Product p = new Product();
      p.name = split[0];
      p.price = Integer.parseInt(split[1]);
      p.stock = Integer.parseInt(split[2]);
      plist.add(p);
      System.out.println(p);
      // for(String s : line.split(",")){ //길이가 3인 배열 나옴
        //   System.out.println(s); //모든 요소가 잘려서 출력
        // }
      }
      for(Product p : plist){
        System.out.println("제품명 : "+p.name+" / 가격 : "+p.price+" / 재고 : "+p.stock);
      }
      reader.close();
      
      Scanner s = new Scanner(new File("prod.csv")); //파일안쪽의 내용을 읽는 용도로 Scanner를 사용
      while(true){
        String line = "";
        try{
          line = s.nextLine();
        }catch(Exception e){
          break;
        }
        if(line == null) break;
        System.out.println(line);
      }
      s.close();
  }
}
