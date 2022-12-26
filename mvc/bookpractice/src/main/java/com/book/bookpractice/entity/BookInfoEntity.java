package com.book.bookpractice.entity;

import java.util.Date;

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
@Table(name="book_info")
public class BookInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bi_seq")       private Long biSeq;
    @Column(name="bi_title")     private String biTitle;
    @Column(name="bi_sub_title") private String biSubTitle;
    @Column(name="bi_price")     private Integer biPrice;
    @Column(name="bi_discount")  private Double biDiscount;
    @Column(name="bi_point")     private Double biPoint;
    @Column(name="bi_pub_dt")    private Date biPubDt;
    @Column(name="bi_category")  private String biCategory;
    @Column(name="bi_publisher") private String biPublisher;
}