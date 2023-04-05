package com.green.flo.vo.album;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumInfoVO {
    private String albumName;
    private Date publishDate;
    private Integer country;
    private String introduce;
    private MultipartFile albumImg;
    private Long artistGroup;

    public void setPublishDate(String dt) throws Exception{
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        this.publishDate = formatter.parse(dt);
    }
}
