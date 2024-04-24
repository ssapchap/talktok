package com.tt.talktok.dto;

import com.tt.talktok.entity.Teacher;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class TeacherDto {
    private int tea_no;
    private String tea_name;
    private String tea_email;
    private String tea_phone;
    private String tea_nickname;
    private String tea_intro;
    private String tea_detail;
    private String tea_career;
    private String tea_nation;
    private String tea_image;

}
