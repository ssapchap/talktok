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
        System.out.println("로그인 이동");
        int result = 0;

        String email = student.getStuEmail();
        StudentDto dbStudent = studentService.findStudent(email);

        // 등록되지 않은 학생의 경우
        if(dbStudent == null){
            model.addAttribute("result", String.valueOf(result));
            return "student/login";
            // 등록된 학생의 경우
        } else{
            if(passwordEncoder.matches(student.getStuPwd(), dbStudent.getStuPwd())){
                result = 1;

                session.setAttribute("stuEmail", email);
                model.addAttribute("result", String.valueOf(result));
                return "student/login";
            } else {
                result = 2;
                session.setAttribute("result", String.valueOf(result));
                return  "student/login";
            }
        }

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

        // tring.valueOf(result)를 사용하여 숫자를 문자열로 변환한 후 모델에 추가해야 합니다. 그러면 Thymeleaf가 HTML로 렌더링할 때 숫자를 문자열로 출력하게 됩니다
        //가입된 email = 1, 가입안된 email = 0
        if(dbStudent==null){
            studentService.join(student);
            result =1;
            model.addAttribute("result",String.valueOf(result));
            return "student/join";
        }
        model.addAttribute("result",String.valueOf(result));
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
    @PostMapping("/withdraw")
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

    }
}