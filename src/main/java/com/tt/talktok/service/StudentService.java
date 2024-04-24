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

        Student dbStudent = studentRepository.findStudentByStuEmail(stuEmail);
        StudentDto dbStudentDto = new StudentDto();
        if(dbStudent !=null) {
<<<<<<< HEAD
            dbStudentDto.setStuNo(dbStudent.getStuNo());
=======
>>>>>>> 673b8f51a6f48018dff5d9778b809e802f3bec39
            dbStudentDto.setStuEmail(dbStudent.getStuEmail());
            dbStudentDto.setStuName(dbStudent.getStuName());
            dbStudentDto.setStuPwd(dbStudent.getStuPwd());
            dbStudentDto.setStuPhone(dbStudent.getStuPhone());
            dbStudentDto.setStuNickname(dbStudent.getStuNickname());
        }
        return dbStudentDto;
    }

    public void join(StudentDto student) {
        Student newStudent = new Student();

        String pwd=student.getStuPwd();
        String encodePwd = passwordEncoder.encode(pwd);

        newStudent.setStuName(student.getStuName());
        newStudent.setStuEmail(student.getStuEmail());
        newStudent.setStuPwd(encodePwd);
        newStudent.setStuPhone(student.getStuPhone());
        newStudent.setStuNickname(student.getStuNickname());

        studentRepository.save(newStudent);
<<<<<<< HEAD

    }


    public void withdraw(String stuEmail) {
        Student dbStudent = studentRepository.findStudentByStuEmail(stuEmail);
        studentRepository.delete(dbStudent);
    }

    public void updatePwd(StudentDto student) {
        String stuEmail = student.getStuEmail();
        Student newStudent = studentRepository.findStudentByStuEmail(stuEmail);

        newStudent.setStuPwd(student.getStuPwd());

        studentRepository.save(newStudent);
=======
>>>>>>> 673b8f51a6f48018dff5d9778b809e802f3bec39

    }


}



