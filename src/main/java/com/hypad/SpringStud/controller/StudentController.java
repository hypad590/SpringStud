package com.hypad.SpringStud.controller;

import com.hypad.SpringStud.model.Student;
import com.hypad.SpringStud.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public List<Student> findAllStudents(){
        //todo
        return studentService.findAllStudents();
    }

    @PostMapping("save_student")
    public String saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return "Student "+ student.getFirstName() +" saved";
    }

    @GetMapping("/{email}")
    public Student getStudent(@PathVariable String email){
        return studentService.findByEmail(email);
    }

    @PutMapping("update_student")
    public Student updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }

    @DeleteMapping("delete_student/{email}")
    public void deleteStudent(@PathVariable String email){
        studentService.deleteStudent(email);
    }
}
