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

public class FileManager {
    public static final String POST_PATH = "data_files/posts.dat";
    public static final String MEMBER_PATH = "data_files/members.dat";
    public static final String COMMENT_PATH = "data_files/comments.dat";

    public static void saveData(String filePath, List<BoardData> dataList) throws Exception {
        BufferedWriter w = new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(
                    new File(filePath)
                ), "UTF-8"
            )
        );
        for(BoardData bd : dataList)
            w.write(bd.makeDataString());
        w.close();
    }
    public static List<String> loadData(String filePath) throws Exception {
        BufferedReader r = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(
                    new File(filePath)
                ), "UTF-8"
            )
        );
        List<String> dataList = new LinkedList<String>();
        while(true) {
            String line = r.readLine();
            if(line == null) break;
            dataList.add(line);
        }
        r.close();
        return dataList;
    }
}
