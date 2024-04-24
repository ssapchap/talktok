package com.tt.talktok.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name="review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rev_no;

    @Column
    private String rev_name;
    @Column
    private String rev_detail;
    @Column
    private String rev_writer;
    @Column
    private String rev_readcount;
    @Column
    private int rev_score;
    @Column
    private String rev_date;
    @Column
    private int lec_no;
    @Column
    private int tea_no;
//    // Lecture에 대한 ManyToOne 관계 추가
//    @ManyToOne
//    @JoinColumn(name = "lec_no") // Review 테이블에서 외래 키로 작용할 컬럼
//    private Lecture lecture;
//
//    // Teacher에 대한 ManyToOne 관계 추가
//    @ManyToOne
//    @JoinColumn(name = "tea_no") // Review 테이블에서 외래 키로 작용할 컬럼
//    private Teacher teacher;

}
