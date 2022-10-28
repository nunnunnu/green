package JAVA_221028;

import java.util.Date;

public class MovieBasicInfo {
  String[] status_list = { "개봉예정", "상영중", "상영종료", "재개봉", "VOD" };
  String title_kor; //한글제목
  String title_eng; //영어제목
  int status; //0:개봉예정, 1:상영중, 2:상영종료, 3:재개봉, 4:VOD
  double audience_score; //관람객평점
  double netizen_score; //네티즌 평점
  double critic_score; //기자,평론가 평점
  String genre; //장르
  String country; //국가
  int running_time; //상영시간
  Date opening_dt; //날짜데이터를 dt로 씀, 개봉일
  String director; //감독
  String main_actor; //주연배우
  String sub_actor; //조연배우
  int viewing_age; //관람등급
  int acc_audience; //누적관객
  String poster_img; //포스터이미지

  void showInfo(){
    System.out.println(title_kor + "(" + title_eng + ")"+" ["+status_list[status]+"]");
    System.out.printf("관람객 평점 : %.2f / 네티즌 평점 : %.2f / 기자, 평론가 평점 : %.2f\n",audience_score, netizen_score, critic_score);
    System.out.println("장르 : " + genre + " / 국가 : " + country + " / 상영시간 : " + running_time + "분");
    System.out.println("개봉일 : " + opening_dt + " / 감독" + director + " / 주연 : " + main_actor + " / 조연 : " + sub_actor);
    String str_viewing_age = "";
    if (viewing_age == 0){
      str_viewing_age = "전체관람";
    }
    else {
      str_viewing_age = viewing_age + "세 이상 관람가";
    }
    System.out.println("관람등급 : "+str_viewing_age+"누적관객 : "+acc_audience+"명 / 포스터이미지 : "+poster_img);
  }
  void changeMovieStatus(int status){
    if(status<0 || status >= status_list.length){
      System.out.println("상태변경 실패 (0~4중 입력)");
      return;
    }
    System.out.println("상태 변경 : "+status_list[this.status]+" -> "+status_list[status]);
    status=status;
  }
  void changeAudienceScore(double score){
    System.out.println("관람객 평점 변경 : "+this.audience_score+" -> "+score);
    audience_score=score;
  }
  void changeNetizenScore(double score){
    System.out.println("네티즌 평점 변경 : "+this.netizen_score+" -> "+score);
    netizen_score=score;
    
  }
  void changeCriticScore(double score){
    System.out.println("기자, 평론가 평점 변경 : "+this.critic_score+" -> "+score);
    this.critic_score=score;
  }
  void addAudienceCount(int count){
    System.out.println("누적 관객 수 : "+acc_audience+" -> "+count);
    acc_audience=count;
  }
}
