package group1;

public class SubAccessTest extends AccessTest {
  public SubAccessTest(){
    this.a=100; //default
    // this.b=200; //private - 에러남. 자식클래스에서도 접근불가함.
    this.c=300; //protected - 잘안씀
    this.d=400; //publuc
  }
}
