package com.tt.talktok.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    private int lec_no;
    private String lec_name;
    private String lec_day;
    private String lec_time;
    private String lec_price;
    private String lec_detail;
    private String lec_startdate;
    private String lec_enddate;
//    @OneToMany(mappedBy = "lecture")
//    private Set<Review> reviews; // 연결된 리뷰
}