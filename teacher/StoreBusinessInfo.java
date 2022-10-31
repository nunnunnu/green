public class StoreBusinessInfo {
    // Business Info
    String store_business_owner; // 사업주
    String store_business_name; // 사업장 이름
    String store_business_address; // 사업장 주소
    String store_business_number; // 사업자 등록번호

    public StoreBusinessInfo(String owner, String name, String address, String number) {
        this.store_business_owner = owner;
        this.store_business_name = name;
        this.store_business_address = address;
        this.store_business_number = number;
    }
}
