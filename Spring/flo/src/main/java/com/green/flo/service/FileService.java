package com.green.flo.service;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.Random;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    public String saveImageFile(String type, MultipartFile image) throws Exception{
        System.out.println(image);
        System.out.println(type);
        //파일이 저장될 경로
        Path targetLocation = Paths.get("/home/flo/images/"+type);

        String fileName = image.getOriginalFilename();
        String[] split = fileName.split("\\.");
        String ext = split[split.length-1]; //원 파일에서 확장자 잘라냄
        fileName = generateRandomStr()+"."+ext; //생성한 파일 이름 + 확장자
        //파일저장위치 + 파일명 -> 파일 저장 경로
        targetLocation = targetLocation.resolve(fileName);
        //입력된 파일을 저장될 위치에 복사
        Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING); //REPLACE_EXISTING - 같은 이름 덮어쓰기
        System.out.println("aaa");
        //저장된 위치를 문자열로 변환해서 내어줌
        // return targetLocation.toString();
        return fileName;
    }

    public ResponseEntity<Resource> getImageFile(String type, String filename) throws Exception{
        // Path imgLocation = Paths.get(location).normalize();
        Path imgLocation = Paths.get("/home/flo/images/"+type+"/"+filename).normalize();
        Resource r = new UrlResource(imgLocation.toUri());
        String contentType = "image/jpeg";

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
            .header(HttpHeaders.CONTENT_DISPOSITION, 
            "attachment; filename=\""+URLEncoder.encode(r.getFilename(), "UTF-8"))
            .body(r);
    }
    public Boolean delImageFile(String type, String img){
        //파일이 저장될 경로
        Path targetLocation = Paths.get("/home/flo/images/"+type);
        targetLocation = targetLocation.resolve(img);
        if(!Files.exists(targetLocation)){
            return  false; //파일이 없으면 실패
        }
        try {
            Files.delete(targetLocation);
        }catch (IOException ioe){
            return false; //삭제 실패
        }
        return true;
    }

    public static String generateRandomStr(){
        int leftLimit = 97;
        int rightLimit = 122;
        int targerStringLength = (int)Math.floor(Math.random()*5)+6;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit+1)
                .limit(targerStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        Date dt = new Date();
        generatedString += dt.getTime(); //랜덤문자열+생성 시간으(ms정보)로 중복 이름 피함
        System.out.println(generatedString);
        return  generatedString;
    }

    public String saveMusicFile(String artist, MultipartFile image) throws Exception{
        //파일이 저장될 경로
        Path targetLocation = Paths.get("/home/flo/music/"+artist);
        //해당 위치에 폴더가 없다면
        File dir = new File(targetLocation.normalize().toString()); //OS환경에 맞는 경로 표현 방식으로 변환

        if(!dir.exists()){ //생성한다. -> 아티스트 마다 폴더가 생성됨
            dir.mkdir();
        }

        String fileName = image.getOriginalFilename();
        String[] split = fileName.split("\\.");
        String ext = split[split.length-1]; //원 파일에서 확장자 잘라냄
        fileName = generateRandomStr()+"."+ext; //생성한 파일 이름 + 확장자
        //파일저장위치 + 파일명 -> 파일 저장 경로
        targetLocation = targetLocation.resolve(fileName);
        //입력된 파일을 저장될 위치에 복사
        Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING); //REPLACE_EXISTING - 같은 이름 덮어쓰기
        //저장된 위치를 문자열로 변환해서 내어줌
        // return targetLocation.toString();
        return fileName;
    }
    public ResponseEntity<Resource> getMusicFile(String artist, String filename) throws Exception{
        // Path imgLocation = Paths.get(location).normalize();
        Path imgLocation = Paths.get("/home/flo/music/"+artist+"/"+filename).normalize();
        Resource r = new UrlResource(imgLocation.toUri());
        String contentType = "application/octet-stream";

        return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\""+URLEncoder.encode(r.getFilename(), "UTF-8"))
                .body(r);
    }
}
