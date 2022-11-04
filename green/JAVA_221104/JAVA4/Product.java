package JAVA4;

public class Product {
  // String name;
  // public String sub_title;
  // protected Integer price;
  // private Integer stock;

  private String name;
  private String sub_title;
  private Integer price;
  private Integer stock;

  public Product(){}
  public Product(String name, String sub_title, Integer price, Integer stock){
    setName(name);
    setSub_title(sub_title);
    setPrice(price);
    setStock(stock);
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSub_title() {
    return this.sub_title;
  }

  public void setSub_title(String sub_title) {
    this.sub_title = sub_title;
  }

  public Integer getPrice() {
    return this.price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Integer getStock() {
    return this.stock;
  }

  public void setStock(Integer stock) {
    this.stock = stock;
  }

  // void showStock(){
  //   System.out.println("재고 : "+stock+"개");
  // }

    
}
