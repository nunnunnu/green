package com.green.flo.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="genre_info")
@Builder
public class GenreEntity {
     @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Schema(description="장르번호", example="1")
     @Column(name="genre_seq") private Long seq;
     @Schema(description="장르 명", example="K-POP")
     @Column(name="genre_name") private String name;
}