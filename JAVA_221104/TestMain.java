// import A.MyClass;

public class TestMain {
  public static void main(String[] args) {
    // MyClass a = new MyClass();
    A.MyClass a = new A.MyClass();
    B.MyClass b = new B.MyClass();

    a.printInfo();
    b.printInfo();

  }
  long add(int a, int b){
    return a+b;
  }
  int add(byte a, byte b){
    return a+b;
  }
  int add(long a, int b){
    return (int)(a+b);
  }
}
