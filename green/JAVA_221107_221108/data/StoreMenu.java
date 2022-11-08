package data;
public class StoreMenu {
  public String menu_img;
  public String menu_name;
  public String menu_desc;
  public Integer menu_price;

  public StoreMenu(){}
  public StoreMenu(String menu_img,String menu_name,String menu_desc,Integer menu_price){
    this.menu_img = menu_img;
    this.menu_name = menu_name;
    this.menu_desc = menu_desc;
    this.menu_price = menu_price;
  }
  @Override
  public String toString() {
    return 
      "이미지 : "+menu_img+"\n"+menu_name+" / "+menu_price+"원\n"+menu_desc;


  }
}
