package data;

import java.text.SimpleDateFormat;
import java.util.Date;
// 사용자 정보 클래스, BoardData 인터페이스를 구현(상속) 한다.
public class PostComment implements BoardData {
    private Integer pc_no; // 댓글 번호
    private Integer pc_post_no; // 글 번호
    private String pc_content; // 댓글 내용
    private Date pc_reg_dt; // 댓글 등록 일
    private String pc_author; // 댓글 작성자 아이디
    public PostComment() {} // 기본생성자
    // 파라미터가 있는 생성자
    public PostComment(Integer pc_no, Integer pc_post_no, String pc_content, String pc_author) {
        this.pc_no = pc_no; // 파라미터 값을 멤버변수에 설정
        this.pc_post_no = pc_post_no; // 파라미터 값을 멤버변수에 설정
        this.pc_content = pc_content; // 파라미터 값을 멤버변수에 설정
        this.pc_reg_dt = new Date(); // 등록일을 현재 날짜로 설정
        this.pc_author = pc_author; // 파라미터 값을 멤버변수에 설정
    }
    @Override
    // 인터페이스에 정의된
    // 데이터 String으로부터 객체 값으로 변환하는 기능 실제 구현
    public void parseDataString(String dataStr) throws Exception {
        String[] split = dataStr.split("\\|"); // 입력된 문자열을 | 기준으로 분할
        if(split.length != 5) {// 분할된 데이터가 5개가 아니라면
            // 데이터 형식이 잘못되었다 판단하고, 메시지 출력
            System.out.println("Wrong data format ...");
            return; // 종료
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // split된 배열의 0~4 까지의 인덱스를 각 멤버변수에 설정
        this.pc_no = Integer.parseInt(split[0]); // String에서 Integer 타입으로 변환
        this.pc_post_no = Integer.parseInt(split[1]); // String에서 Integer 타입으로 변환
        this.pc_content = split[2];
        this.pc_reg_dt = f.parse(split[3]); // String에서 java.util.Date 타입으로 변환
        this.pc_author = split[4];
    }

    @Override
    // 객체 정보를 출력하기 위한 toString() 메서드 구현
    public String toString() {
        String str = "";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        str += pc_author+" / "+f.format(pc_reg_dt)+"\n";
        str += pc_content+"\n";
        return str;
    }

    @Override
    // 인터페이스에 정의된
    // 객체 값으로부터 데이터 String으로 변환하는 기능 실제 구현
    public String makeDataString() {
        // java.util.Date에서 String으로 변환
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // | 를 기준으로 모든 멤버변수를 나열하여 문자열을 구성해서 내보내줌
        return pc_no+"|"+pc_post_no+"|"+pc_content+"|"+f.format(pc_reg_dt)+"|"+pc_author+"\r\n";
    }
    // pc_no가 private이기 때문에 필요한 getter 메서드
    public Integer getPc_no() {
        return pc_no;
    }
    // pc_post_no가 private이기 때문에 필요한 getter 메서드
    public Integer getPc_post_no() {
        return pc_post_no;
    }
    // pc_author가 private이기 때문에 필요한 getter 메서드
    public String getPc_author() {
        return this.pc_author;
    }
}