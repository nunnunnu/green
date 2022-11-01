public class StoreBusinessInfo {
  String business_owner;
  String business_name;
  String business_address;
  String business_number;

  public StoreBusinessInfo(
      String business_owner,
      String business_name,
      String business_address,
      String business_number
    ){
      this.business_owner = business_owner;
      this.business_name = business_name;
      this.business_address = business_address;
      this.business_number = business_number;
      
    }
    public String toString(){
      String str = "";
      str +="대표자 : "+business_owner+"\n";
      str +="상호명 : "+business_name+"\n";
      str +="사업자주소 : "+business_address+"\n";
      str +="사업자등록번호 : "+business_number;

      return str;
    }
}
