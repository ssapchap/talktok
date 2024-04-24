package com.tt.talktok.entity;

<<<<<<< HEAD
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

>>>>>>> 9f116a1177c89e2f8675be55bff856dd51048480
@Getter
@Setter
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
<<<<<<< HEAD
    private int lec_no;
=======
    @Column(name = "lec_no")
    private int lecNo;
>>>>>>> 9f116a1177c89e2f8675be55bff856dd51048480
    private String lec_name;
    private String lec_day;
    private String lec_time;
    private String lec_price;
    private String lec_detail;
    private String lec_startdate;
    private String lec_enddate;
<<<<<<< HEAD
//    @OneToMany(mappedBy = "lecture")
//    private Set<Review> reviews; // 연결된 리뷰
}
=======
}
>>>>>>> 9f116a1177c89e2f8675be55bff856dd51048480
