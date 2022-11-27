public class CbrCbv {
  public static String change(String str) { //Call By Value
    str+="456"; 
    return str;
  }

  public static void a(int[] arr) {
    arr[0] = 100;
    
  }
  public static void main(String[] args) {
    String str="ABC123";
    str = change(str);
    System.out.println(str);

    int[] arr = {10,20};
    a(arr);
    System.out.println(arr[0]);
  }
}
