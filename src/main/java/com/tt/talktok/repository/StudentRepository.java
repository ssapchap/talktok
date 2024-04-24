package com.tt.talktok.repository;

import com.tt.talktok.dto.StudentDto;
import com.tt.talktok.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    StudentDto findStudentByStuEmail(String email);

    @Override
    <S extends Student> S save(S entity);

    void deleteStudentByStuNo(String stuNo);


}
