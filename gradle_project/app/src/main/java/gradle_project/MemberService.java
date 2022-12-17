package gradle_project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Result;

public class MemberService {
    private static MemberService instance = null;
    public static Integer loginUser = null;
    public static Scanner s = new Scanner(System.in);

    private MemberService(){}

    public static MemberService getInstance() {
        if(instance==null){
            instance=new MemberService();
        }
        return instance;
    }
    public Boolean memberJoin(String id, String pwd) throws Exception{
        DBConnManager dbManager = DBConnManager.getInstance();
        dbManager.dbConnection();

        String sql = "insert into member_info(mi_id, mi_pwd) values(?,?);";
        PreparedStatement pstmt = dbManager.getPstmt(sql);
        
        pstmt.setString(1, id);
        pstmt.setString(2, pwd);
        pstmt.executeUpdate();
        return true;
    }
    public Boolean isDuplicateId(String id) throws Exception{
        DBConnManager dbManager = DBConnManager.getInstance();
        dbManager.dbConnection();

        String sql = "select count(*) from member_info where mi_id=?";
        PreparedStatement pstmt = dbManager.getPstmt(sql);
        pstmt.setString(1, id);
        ResultSet rs = pstmt.executeQuery();
        rs.next();
        if(rs.getInt(1)>=1){
            dbManager.dbClose();
            return true;
        }
        dbManager.dbClose();
        return false;
    }
}
