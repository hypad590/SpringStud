package com.hypad.SpringStud.service;

import com.hypad.SpringStud.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
public interface StudentService {
    List<Student> findAllStudents();

    Student saveStudent(Student student);

    Student findByEmail(String email);

    Student updateStudent(Student student);

    void deleteStudent(String email);
}
