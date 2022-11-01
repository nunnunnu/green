public class DeliveryBoundary{
  int boundary;
  int price;
  public DeliveryBoundary(int boundary, int price){
    setBountdary(boundary);
    setPrice(price);
  }
  void setBountdary(int boundary){
    if(boundary>0){
      this.boundary=boundary;
    }
  }
  void setPrice(int price){
    if(price>0){
      this.price=price;
    }
  }
}