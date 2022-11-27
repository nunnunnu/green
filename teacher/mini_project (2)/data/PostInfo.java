package data;

import java.text.SimpleDateFormat;
import java.util.Date;
// 사용자 정보 클래스, BoardData 인터페이스를 구현(상속) 한다.
public class PostInfo implements BoardData {
    private Integer post_no; // 글 번호
    private String post_title; // 제목
    private String post_content; // 내용
    private Date post_reg_dt; // 등록일
    private Date post_mod_dt; // 수정일
    private String post_author; // 작성자 ID
    private Integer post_status; // 글 상태 (1:정상,2:삭제)
    public PostInfo() {} // 기본생성자
    // 파라미터 있는 생성자
    public PostInfo(Integer post_no,String post_title,String post_content,String post_author,Integer post_status) {
        this.post_no = post_no; // 파라미터 값을 멤버변수에 설정
        this.post_title = post_title; // 파라미터 값을 멤버변수에 설정
        this.post_content = post_content; // 파라미터 값을 멤버변수에 설정
        this.post_reg_dt = new Date(); // 현재 날짜로 작성일 설정
        this.post_mod_dt = new Date(); // 현재 날짜로 수정일 설정
        this.post_author = post_author; // 파라미터 값을 멤버변수에 설정
        this.post_status = post_status; // 파라미터 값을 멤버변수에 설정
    }
    @Override
    // 인터페이스에 정의된
    // 데이터 String으로부터 객체 값으로 변환하는 기능 실제 구현
    public void parseDataString(String dataStr) throws Exception {
        String[] split = dataStr.split("\\|"); // 입력된 문자열을 | 기준으로 분할
        if(split.length != 7) { // 분할된 데이터가 7개가 아니라면
            // 데이터 형식이 잘못되었다 판단하고, 메시지 출력
            System.out.println("Wrong data format ...");
            return; // 종료
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // split된 배열의 0~6 까지의 인덱스를 각 멤버변수에 설정
        this.post_no = Integer.parseInt(split[0]); // String에서 Integer로 변환
        this.post_title = split[1];
        this.post_content = split[2];
        this.post_reg_dt = f.parse(split[3]); // String에서 java.util.Date로 변환
        this.post_mod_dt = f.parse(split[4]); // String에서 java.util.Date로 변환
        this.post_author = split[5];
        this.post_status = Integer.parseInt(split[6]); // String에서 Integer로 변환
    }
    @Override
    // 인터페이스에 정의된
    // 객체 값으로부터 데이터 String으로 변환하는 기능 실제 구현
    public String makeDataString() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // java.util.Date에서 String으로 변환
        // | 를 기준으로 모든 멤버변수를 나열하여 문자열을 구성해서 내보내줌
        return post_no+"|"+post_title+"|"+post_content+"|"+f.format(post_reg_dt)+"|"+f.format(post_mod_dt)+"|"+post_author+"|"+post_status+"\r\n";
    }
    // 글 요약 정보를 출력하는 기능, 글 목록을 보여줄 때 사용
    public void showPostSummary() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜를 String으로 변환하기 위한 formatter
        // 정보 출력
        System.out.printf("%-5s %-20s %-20s %-16s\n", post_no, post_title, f.format(post_reg_dt), post_author);
    }
    // 글 상세 정보 출력, 글 상세보기에서 사용할 기능
    public void showPostDetail() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 날짜를 String으로 변환하기 위한 formatter
        // 글 상세 정보 출력
        System.out.println("제목 : "+post_title+" / 작성자 : "+post_author+" / 등록일 : "+f.format(post_reg_dt)+" / 수정일 : "+f.format(post_mod_dt));
        System.out.println("------------------------------------------------------------------------");
        System.out.println(post_content);
    }
    // post_no가 private이므로 필요한 getter 메서드
    public Integer getPost_no() {
        return this.post_no;
    }
    // post_status가 private이므로 필요한 getter 메서드
    public Integer getPost_status() {
        return this.post_status;
    }
    // post_author가 private이므로 필요한 getter 메서드
    public String getPost_author() {
        return this.post_author;
    }
    // post_title이 private이므로 필요한 getter 메서드
    public String getPost_title() {
        return this.post_title;
    }
    // post_content가 private이므로 필요한 getter 메서드
    public String getPost_content() {
        return this.post_content;
    }
    // post_title이 private이므로 필요한 setter 메서드
    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }
    // post_status가 private이므로 필요한 setter 메서드
    public void setPost_status(Integer post_status) {
        this.post_status = post_status;
    }
    // post_content가 private이므로 필요한 setter 메서드
    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }
    // post_mod_dt가 private이므로 필요한 setter 메서드
    public void setPost_mod_dt(Date post_mod_dt) {
        this.post_mod_dt = post_mod_dt;
    }
}
