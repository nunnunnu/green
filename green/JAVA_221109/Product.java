import java.security.PublicKey;

public class Product {
  public String name;
  public Integer price;
  public Integer stock;

  @Override
  public String toString() {
    return name+","+price+","+stock;
  }
}
