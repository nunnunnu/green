package data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PostInfo implements BoardData {
    private Integer post_no;
    private String post_title;
    private String post_content;
    private Date post_reg_dt;
    private Date post_mod_dt;
    private String post_author;
    private Integer post_status;
    public PostInfo() {}
    public PostInfo(Integer post_no,String post_title,String post_content,String post_author,Integer post_status) {
        this.post_no = post_no;
        this.post_title = post_title;
        this.post_content = post_content;
        this.post_reg_dt = new Date();
        this.post_mod_dt = new Date();
        this.post_author = post_author;
        this.post_status = post_status;
    }
    @Override
    public void parseDataString(String dataStr) throws Exception {
        String[] split = dataStr.split("\\|");
        if(split.length != 7) {
            System.out.println("Wrong data format ...");
            return;
        }
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.post_no = Integer.parseInt(split[0]);
        this.post_title = split[1];
        this.post_content = split[2];
        this.post_reg_dt = f.parse(split[3]);
        this.post_mod_dt = f.parse(split[4]);
        this.post_author = split[5];
        this.post_status = Integer.parseInt(split[6]);
    }
    @Override
    public String makeDataString() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return post_no+"|"+post_title+"|"+post_content+"|"+f.format(post_reg_dt)+"|"+f.format(post_mod_dt)+"|"+post_author+"|"+post_status+"\r\n";
    }
    
    public void showPostSummary() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.printf("%-5s %-20s %-20s %-16s\n", post_no, post_title, f.format(post_reg_dt), post_author);
    }
    
    public void showPostDetail() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("제목 : "+post_title+" / 작성자 : "+post_author+" / 등록일 : "+f.format(post_reg_dt)+" / 수정일 : "+f.format(post_mod_dt));
        System.out.println("------------------------------------------------------------------------");
        System.out.println(post_content);
    }

    public Integer getPost_no() {
        return this.post_no;
    }
    public Integer getPost_status() {
        return this.post_status;
    }
    public String getPost_author() {
        return this.post_author;
    }
    public String getPost_title() {
        return this.post_title;
    }
    public String getPost_content() {
        return this.post_content;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }
    public void setPost_status(Integer post_status) {
        this.post_status = post_status;
    }
    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }
    public void setPost_mod_dt(Date post_mod_dt) {
        this.post_mod_dt = post_mod_dt;
    }
}
