package data;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Review {
  public String author;
  public Integer score;
  public Date regDt;
  public String content;

  public Review(){}
  public Review(String author, Integer score, String content){
    this.author = author;
    if(score<1){
      this.score=1;
    }else if(score>5){
      this.score = 5;
    }else{
      this.score = score;
    }
    this.regDt = new Date();
    this.content = content;
  }

  @Override
  public String toString() {
    String str="";
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    str+= author+" / "+score+" / "+f.format(regDt)+"\n";
    str+= content+"\n";
    return str;
  }
}
