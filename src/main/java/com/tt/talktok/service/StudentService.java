package com.tt.talktok.service;

import com.tt.talktok.dto.StudentDto;
import com.tt.talktok.entity.Student;
import com.tt.talktok.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final StudentRepository studentRepository;

    public StudentDto findStudent(String stuEmail) {
        StudentDto dbStudent = studentRepository.findStudentByStuEmail(stuEmail);

        return dbStudent;
    }

    public void join(StudentDto student) {
        Student dbStudent = new Student();

        String pwd=student.getStuPwd();
        String encodePwd = passwordEncoder.encode(pwd);


        dbStudent.setStuName(student.getStuName());
        dbStudent.setStuEmail(student.getStuEmail());
        dbStudent.setStuPwd(encodePwd);
        dbStudent.setStuPhone(student.getStuPhone());
        dbStudent.setStuNickname(student.getStuNickname());

        studentRepository.save(dbStudent);
    }

    public void withdraw(String stuEmail) {
        //넘어온 email을 기준으로 db에 저장된 student 정보를 가져옴.
        StudentDto dbStudent = studentRepository.findStudentByStuEmail(stuEmail);

        String stuNo = dbStudent.getStuNo();

        studentRepository.deleteStudentByStuNo(stuNo);


    }
}



