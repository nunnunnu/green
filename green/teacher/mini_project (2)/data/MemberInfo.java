package data;

import java.text.SimpleDateFormat;
import java.util.Date;
// 사용자 정보 클래스, BoardData 인터페이스를 구현(상속) 한다.
public class MemberInfo implements BoardData {
    private String mi_id; // 사용자 아이디
    private String mi_pwd; // 사용자 비밀번호
    private String mi_name; // 사용자 이름(닉네임)
    private String mi_birth; // 사용자 주민등록번호
    private Boolean mi_gen; // 성별
    private Date mi_reg_dt; // 등록일
    private Integer mi_status; // 사용자 상태
    public MemberInfo() {} // 기본생성자
    // 파라미터 있는 생성자
    public MemberInfo(String mi_id, String mi_pwd, String mi_name, String mi_birth, Integer mi_status) {
        this.mi_id = mi_id; // 파라미터 값을 멤버변수에 저장
        this.mi_pwd = mi_pwd; // 파라미터 값을 멤버변수에 저장
        this.mi_name = mi_name; // 파라미터 값을 멤버변수에 저장
        this.mi_birth = mi_birth; // 파라미터 값을 멤버변수에 저장
        String[] birthSplit = mi_birth.split("-"); // 성별 추출을 위한 주민등록번호 split
        // 주민등록번호 뒷자리의 첫번째 수가 홀수라면 true, 짝수라면 false가 저장된다.
        this.mi_gen = Integer.parseInt(birthSplit[1].substring(0, 1)) % 2 == 1;
        this.mi_reg_dt = new Date(); // 현재 시간으로 가입일 설정
        this.mi_status = mi_status; // 파라미터 값을 멤버변수에 저장
    }
    @Override
    // 인터페이스에 정의된
    // 데이터 String으로부터 객체 값으로 변환하는 기능 실제 구현
    public void parseDataString(String dataStr) throws Exception {
        String[] split = dataStr.split(","); // 입력된 문자열을 , 기준으로 분할
        if(split.length != 7) { // 분할된 데이터가 7개가 아니라면
            // 데이터 형식이 잘못되었다 판단하고, 메시지 출력
            System.out.println("Data String Format is Wrong..");
            return; // 종료
        }
        // split된 배열의 0~6 까지의 인덱스를 각 멤버변수에 설정
        this.mi_id = split[0];
        this.mi_pwd = split[1];
        this.mi_name = split[2];
        this.mi_birth = split[3];
        this.mi_gen = Boolean.parseBoolean(split[4]); // String에서 Boolean으로 변환
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.mi_reg_dt = f.parse(split[5]); // String에서 java.util.Date로 변환
        this.mi_status = Integer.parseInt(split[6]); // String에서 Integer로 변환
    }
    @Override
    // 인터페이스에 정의된
    // 객체 값으로부터 데이터 String으로 변환하는 기능 실제 구현
    public String makeDataString() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDt = f.format(mi_reg_dt); // java.util.Date에서 String으로 변환
        // , 를 기준으로 모든 멤버변수를 나열하여 문자열을 구성해서 내보내줌
        return mi_id+","+mi_pwd+","+mi_name+","+mi_birth+","+mi_gen+","+strDt+","+mi_status+"\r\n";
    }
    // mi_name이 private이므로 필요한 getter 메서드
    public String getMi_name() {
        return this.mi_name;
    }
    // mi_id가 private이므로 필요한 getter 메서드
    public String getMi_id() {
        return this.mi_id;
    }
    // mi_birth가 private이므로 필요한 getter 메서드
    public String getMi_birth() {
        return this.mi_birth;
    }
    // mi_pwd가 private이므로 필요한 getter 메서드
    public String getMi_pwd() {
        return this.mi_pwd;
    }
    // mi_pwd가 private이므로 필요한 setter 메서드
    public void setMi_pwd(String mi_pwd) {
        this.mi_pwd = mi_pwd;
    }
    // mi_name이 private이므로 필요한 setter 메서드
    public void setMi_name(String mi_name) {
        this.mi_name = mi_name;
    }
    // mi_status가 private이므로 필요한 setter 메서드
    public void setMi_status(Integer mi_status) {
        this.mi_status = mi_status;
    }
    @Override
    // 객체 정보를 출력하기 위한 toString() 메서드 구현
    public String toString() {
        String str = "";
        String strBirth = mi_birth.substring(0,8)+"******";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String strStatus = "";
        if(mi_status == 1) strStatus = "정상사용";
        else if(mi_status == 2) strStatus = "이용정지";
        else if(mi_status == 3) strStatus = "영구정지";
        else if(mi_status == 4) strStatus = "탈퇴";
        str += 
            "아이디 : "+mi_id+"\n"+
            "비밀번호 : "+"*********"+"\n"+
            "이름(닉네임) : "+mi_name+"\n"+
            "주민등록번호 : "+strBirth+"\n"+
            "성별 : "+(mi_gen?"남":"여")+"\n"+
            "가입일 : "+f.format(mi_reg_dt)+"\n"+
            "회원상태 : "+strStatus+"\n";
        return str;
    }
}
