package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostComment implements BoardData {
    private Integer pc_no;
    private Integer pc_post_no;
    private String pc_content;
    private Date pc_reg_dt;
    private String pc_author;
    public PostComment() {}
    public PostComment(Integer pc_no, Integer pc_post_no, String pc_content, String pc_author) {
        this.pc_no = pc_no;
        this.pc_post_no = pc_post_no;
        this.pc_content = pc_content;
        this.pc_reg_dt = new Date();
        this.pc_author = pc_author;
    }
    @Override
    public void parseDataString(String dataStr) throws Exception {
        String[] split = dataStr.split("\\|");
        if(split.length != 5) {
            System.out.println("Wrong data format ...");
            return;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.pc_no = Integer.parseInt(split[0]);
        this.pc_post_no = Integer.parseInt(split[1]);
        this.pc_content = split[2];
        this.pc_reg_dt = f.parse(split[3]);
        this.pc_author = split[4];
    }

    @Override
    public String toString() {
        String str = "";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        str += pc_author+" / "+f.format(pc_reg_dt)+"\n";
        str += pc_content+"\n";
        return str;
    }

    @Override
    public String makeDataString() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return pc_no+"|"+pc_post_no+"|"+pc_content+"|"+f.format(pc_reg_dt)+"|"+pc_author+"\r\n";
    }

    public Integer getPc_no() {
        return pc_no;
    }
    public Integer getPc_post_no() {
        return pc_post_no;
    }
    public String getPc_author() {
        return this.pc_author;
    }
}