package com.book.bookpractice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="book_image_info")
public class BookImageInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bii_seq")         private Long biiSeq;
    @Column(name="bii_bi_seq")      private Long biiBiSeq;
    @Column(name="bii_file_path")   private String biiFilePath;
    @Column(name="bii_uri")         private String biiUri;
}