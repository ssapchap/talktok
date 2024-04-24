package com.tt.talktok.controller;

import com.tt.talktok.dto.StudentDto;
import com.tt.talktok.entity.Student;
import com.tt.talktok.service.StudentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final StudentService studentService;


    @GetMapping("/login")
    public String login() {
        return "student/loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute StudentDto student, Model model, HttpSession session) {
        int result = 0;
        System.out.println(student.getStuPwd());
        String email = student.getStuEmail();
        StudentDto dbStudent = studentService.findStudent(email);

        // 등록되지 않은 학생의 경우
        if(dbStudent.getStuEmail() == null){
            System.out.println("등록되지 않은 학생의 경우");
            model.addAttribute("result", result);
            // 등록된 학생의 경우
        } else {
            //비번이 같을때
            if(passwordEncoder.matches(student.getStuPwd(), dbStudent.getStuPwd())){
                result = 1;
                System.out.println("비번이 같을때");
                session.setAttribute("stuEmail", email);
                model.addAttribute("result", result);
            //비번이 다를때
            } else {
                System.out.println("비번이 다를때");
                result = 2;
                model.addAttribute("result", result);
            }
        }
        return "student/login";
    }

    @GetMapping("/join")
    public String join() {
        return "student/joinForm";
    }

    @PostMapping("/join")
    public String join(@ModelAttribute StudentDto student, Model model) {
        int result = 0;

        String stuEmail = student.getStuEmail();

         StudentDto dbStudent = studentService.findStudent(stuEmail);
        //가입된 email = 1, 가입안된 email = 0
        if(dbStudent != null){
            studentService.join(student);
            model.addAttribute("result",result);
            return "student/join";
        }
        return "student/join";
    }

    // 회원 탈퇴
    @GetMapping("/withdraw")
    public String withdraw(HttpSession session, Model model) {

        String stuEmail = (String) session.getAttribute("stuEmail");
        StudentDto dbStudent = studentService.findStudent(stuEmail);

        model.addAttribute("dbStudent", dbStudent);

        return "student/withdraw";
    }

    // 회원 탈퇴
    // 회원탈퇴 양식으로 이동
    /*@PostMapping("/withdraw")
    public String withdraw(@RequestParam("stuPwd") String stuPwd, Model model, HttpSession session) {
        int result=0;

        String stuEmail = (String) session.getAttribute("stuEmail");

        StudentDto dbStudent = studentService.findStudent(stuEmail);

        //비밀번호 일치시 회원탈퇴.
        if (dbStudent.getStuPwd().equals(stuPwd)) {
            studentService.withdraw(stuEmail);
            session.invalidate();

            result=1;
            model.addAttribute("result",result);
            return "student/withdraw";
            //비밀번호 불일치시
        } else {

            model.addAttribute("result",result);
            return "student/withdraw";
        }

    }*/
}
