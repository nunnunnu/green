package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import data.BoardData;
// 데이터를 파일로 저장하고 불러오는 기능을 위한 클래스
public class FileManager {
    // 글 정보를 저장하고 불러오기 위한 파일의 경로를 설정한 문자열 상수
    public static final String POST_PATH = "data_files/posts.dat"; 
    // 회원 정보를 저장하고 불러오기 위한 파일의 경로를 설정한 문자열 상수
    public static final String MEMBER_PATH = "data_files/members.dat";
    // 댓글 정보를 저장하고 불러오기 위한 파일의 경로를 설정한 문자열 상수
    public static final String COMMENT_PATH = "data_files/comments.dat";

    // 파일 저장 기능
    public static void saveData(String filePath, List<BoardData> dataList) throws Exception {
        // filePath위치에 있는 파일을 쓰기 모드로 연다.
        BufferedWriter w = new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(
                    new File(filePath) // 파일은 append하지 않고 overwrite(덮어쓰기)모드로 작동
                ), "UTF-8"
            )
        );
        for(BoardData bd : dataList) // 전달된 데이터리스트의 모든 내용을 순차조회
            // *** 인터페이스를 통한 다형성 원리 활용
            // dataList 안에 들어있는 객체들의 실 객체 타입이 MemberInfo라면 MemberInfo클래스 안의 makeDataString()이 실행
            // dataList 안에 들어있는 객체들의 실 객체 타입이 PostInfo라면 PostInfo클래스 안의 makeDataString()이 실행
            // dataList 안에 들어있는 객체들의 실 객체 타입이 PostComment라면 PostComment클래스 안의 makeDataString()이 실행
            w.write(bd.makeDataString()); // 객체를 데이터 문자열 형태로 변환하여 파일에 저장한다.
        w.close();
    }
    // 파일 불러오기 기능
    public static List<String> loadData(String filePath) throws Exception {
        // filePath위치에 있는 파일을 읽기 모드로 연다.
        BufferedReader r = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(
                    new File(filePath)
                ), "UTF-8"
            )
        );
        List<String> dataList = new LinkedList<String>();
        while(true) { 
            String line = r.readLine(); // 파일을 한 줄 단위로 읽어들인다.
            if(line == null) break;
            dataList.add(line); // 읽은 줄을 리스트에 추가한다.
        }
        r.close();
        return dataList; // 만들어진 문자열 타입의 리스트를 내보낸다.
    }
}
