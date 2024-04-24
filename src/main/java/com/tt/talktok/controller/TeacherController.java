package com.tt.talktok.controller;

import com.tt.talktok.dto.TeacherDto;
import com.tt.talktok.entity.Teacher;
import com.tt.talktok.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    // 선생님 목록 조회
    @GetMapping("/list")
    public String list(Model model) {
        List<TeacherDto> teacherList = teacherService.list();
        model.addAttribute("teacherList", teacherList);


        return "teacher/list";
    }

    @GetMapping("/detail")
    public String teacherDetail(@RequestParam("tea_no") int tea_no, Model model) {

        TeacherDto teacherDetail = teacherService.getTeacherDetail(tea_no);
        model.addAttribute("teacherDetail", teacherDetail);

        return "teacher/detail";
    }
}