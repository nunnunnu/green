import java.util.ArrayList;
import java.util.List;

public class Store {
  public StoreBasicInfo basicInfo;
  public StoreDetialInfo detialInfo;
  public StoreBusinessInfo businessInfo;
  public List<StoreMenu> menus;
  public List<Review> reviews;

  public Store(StoreBasicInfo basicInfo, StoreDetialInfo detialInfo, StoreBusinessInfo businessInfo){
    this.basicInfo = basicInfo;
    this.detialInfo = detialInfo;
    this.businessInfo = businessInfo; 
    menus = new ArrayList<StoreMenu>();
    reviews = new ArrayList<Review>();
  }

  public void addReview(Review review){
    reviews.add(review);
    Integer scoreSum = 0;
    for(Review r : reviews){
      scoreSum += r.score;
    }
    this.basicInfo.score = scoreSum / (double)(reviews.size());
  }
  public void showReview(){
    if(reviews.size()==0){
      System.out.println("등록된 리뷰가 없습니다.");
    }else{
      for(int i=0;i<reviews.size();i++){
        System.out.println(i+"번째 리뷰"+reviews.get(i));
        
      }
    }
  }

  @Override
  public String toString(){
    return basicInfo.toString()+detialInfo+businessInfo;
  }
}
