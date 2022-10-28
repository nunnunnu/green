package JAVA_221028;

import java.util.Date;

public class MovieTest {
  public static void main(String[] args) {
    MovieBasicInfo movie = new MovieBasicInfo();
    movie.title_kor = "블랙 아담";
    movie.title_eng = "Black Adam";
    movie.status = 1;
    movie.audience_score = 7.60;
    movie.netizen_score = 7.70;
    movie.critic_score = 5.67;
    movie.genre = "액션, 모험, SF";
    movie.country = "미국";
    movie.running_time = 125;
    // 연도는 현재연도에서 1900뻼
    movie.opening_dt = new Date(122,9,19); //쓰는거 권장안한다고 줄그어짐
    movie.director = "자움 콜렛 세라";
    movie.main_actor = "드웨인 존슨";
    movie.sub_actor = "노아센티네오, 피어스 프로스넌";
    movie.viewing_age = 12;
    movie.acc_audience = 531013;
    movie.poster_img = "poster.jpg";
    
    movie.showInfo();
    System.out.println();

    movie.changeMovieStatus(2);
    System.out.println();
    movie.showInfo();
    System.out.println();
    movie.changeMovieStatus(9);
    movie.changeMovieStatus(1);
    movie.changeMovieStatus(3);
    movie.changeMovieStatus(4);
    System.out.println();
    movie.showInfo();

    movie.changeAudienceScore(8.05);
    movie.changeNetizenScore(6.80);
    movie.changeCriticScore(5.98);
    movie.addAudienceCount(853153);
    movie.showInfo();
  }
}
