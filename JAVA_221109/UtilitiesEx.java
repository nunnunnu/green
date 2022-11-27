public class UtilitiesEx {
  public static void main(String[] args) {
    String str = "Hello world";
    System.out.println(str.substring(0,5));
    System.out.println(str.substring(5));
    String filename = "data_12346513.dat";
    System.out.println(filename.substring(5));
    String imgFile="image.jpg";
    String[] split = imgFile.split("\\.");
    String ext = split[split.length-1];
    if(ext.equals("jpg") || ext.equals("png") || ext.equals("gif"));{
      System.out.println("이미지파일입니다.");
    }
  }
}
