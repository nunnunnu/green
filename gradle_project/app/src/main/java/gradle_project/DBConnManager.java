package gradle_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnManager {
    private static DBConnManager instance = null;

    private static final String MYSQL_DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/jdbc_test";
    private static final String USER = "root";
    private static final String PWD = "1234";

    Connection conn = null;
    PreparedStatement pstmt = null;

    private DBConnManager(){
        try{
            Class.forName(MYSQL_DRIVER); // 로딩
        }catch(Exception e){
            e.printStackTrace();
        }
    } 
    public static DBConnManager getInstance() {
        if(instance==null){
            instance = new DBConnManager();
        }
        return instance;
    }
    public boolean dbConnection() {
        if(pstmt!=null || conn!=null){
            System.out.println("이미 연결됨");
            return false;
        }
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PWD);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean dbClose() {
        if(pstmt==null || conn==null){
            System.out.println("이미 연결해제됨");
            return false;
        }
        try{
            pstmt.close();
            conn.close();
            pstmt = null;
            conn = null;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public PreparedStatement getPstmt(String sql) {
        if(conn == null){
            System.out.println("연결안되서 실행못함");
            return null;
        }
        try{
            pstmt = conn.prepareStatement(sql);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return pstmt;
    }
    
}
