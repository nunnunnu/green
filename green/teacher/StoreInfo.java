public class StoreInfo {
    StoreSummaryInfo summary; // 매장 요약정보
    StoreDetailInfo detail; // 매장 상세정보
    StoreBusinessInfo business; // 사업자 정보

    public StoreInfo(StoreSummaryInfo summary, StoreDetailInfo detail, StoreBusinessInfo business) {
        this.summary = summary;
        this.detail = detail;
        this.business = business;
    }
    @Override
    public String toString() {
        return summary.toString()+"\n"+detail.toString();
    }
}