package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberInfo implements BoardData {
    private String mi_id;
    private String mi_pwd;
    private String mi_name;
    private String mi_birth;
    private Boolean mi_gen;
    private Date mi_reg_dt;
    private Integer mi_status;
    public MemberInfo() {}
    public MemberInfo(String mi_id, String mi_pwd, String mi_name, String mi_birth, Integer mi_status) {
        this.mi_id = mi_id;
        this.mi_pwd = mi_pwd;
        this.mi_name = mi_name;
        this.mi_birth = mi_birth;
        String[] birthSplit = mi_birth.split("-");
        this.mi_gen = Integer.parseInt(birthSplit[1].substring(0, 1)) % 2 == 1;
        this.mi_reg_dt = new Date();
        this.mi_status = mi_status;
    }
    @Override
    public void parseDataString(String dataStr) throws Exception {
        String[] split = dataStr.split(",");
        if(split.length != 7) {
            System.out.println("Data String Format is Wrong..");
            return;
        }
        this.mi_id = split[0];
        this.mi_pwd = split[1];
        this.mi_name = split[2];
        this.mi_birth = split[3];
        this.mi_gen = Boolean.parseBoolean(split[4]);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.mi_reg_dt = f.parse(split[5]);
        this.mi_status = Integer.parseInt(split[6]);
    }
    @Override
    public String makeDataString() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDt = f.format(mi_reg_dt);
        return mi_id+","+mi_pwd+","+mi_name+","+mi_birth+","+mi_gen+","+strDt+","+mi_status+"\r\n";
    }
    public String getMi_name() {
        return this.mi_name;
    }
    public String getMi_id() {
        return this.mi_id;
    }
    public String getMi_birth() {
        return this.mi_birth;
    }
    public String getMi_pwd() {
        return this.mi_pwd;
    }

    public void setMi_pwd(String mi_pwd) {
        this.mi_pwd = mi_pwd;
    }
    public void setMi_name(String mi_name) {
        this.mi_name = mi_name;
    }
    public void setMi_status(Integer mi_status) {
        this.mi_status = mi_status;
    }
    @Override
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
