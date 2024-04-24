package com.tt.talktok.entity;

import jakarta.persistence.*;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
=======
import lombok.*;
>>>>>>> 9f116a1177c89e2f8675be55bff856dd51048480

@Getter
@Setter
@Entity
<<<<<<< HEAD
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue
    private int tea_no;
=======
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int tea_no;

>>>>>>> 9f116a1177c89e2f8675be55bff856dd51048480
    private String tea_name;
    private String tea_email;
    private String tea_pwd;
    private String tea_phone;
    private String tea_nickname;
    private String tea_account;
    private String tea_intro;
    private String tea_detail;
    private String tea_career;
    private String tea_nation;
<<<<<<< HEAD
//    @OneToMany(mappedBy = "teacher")
//    private Set<Review> reviews; // 연결된 리뷰
=======

>>>>>>> 9f116a1177c89e2f8675be55bff856dd51048480
}
