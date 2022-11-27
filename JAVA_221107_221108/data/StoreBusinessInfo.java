package data;
public class StoreBusinessInfo {
  public String owner;
  public String store;
  public String address;
  public String regNo;

  public StoreBusinessInfo(){}
  public StoreBusinessInfo(String s1,String s2,String s3,String s4){
    this.owner = s1;
    this.store = s2;
    this.address = s3;
    this.regNo = s4;
  }
  @Override
  public String toString() {
    return
      "사업주 : "+owner+"\n"+
      "상호명 : "+store+"\n"+
      "주소 : "+address+"\n"+
      "사업자등록번호 : "+regNo+"\n";
  }
  public String getDataString(){
    return owner+";"+store+";"+address+";"+regNo;
  }
}
