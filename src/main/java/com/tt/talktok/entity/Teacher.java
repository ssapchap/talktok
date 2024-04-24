package com.tt.talktok.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue
    private int tea_no;
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
//    @OneToMany(mappedBy = "teacher")
//    private Set<Review> reviews; // 연결된 리뷰
}
