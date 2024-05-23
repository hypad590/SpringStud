package com.hypad.SpringStud.repository;

import com.hypad.SpringStud.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentDAO {
    private final List<Student> students = new ArrayList<>();

    public List<Student> findAllStudents() {
        return students;
    }

    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        return students.stream()
                .filter(element -> element
                        .getEmail().equals(email))
                .findFirst().orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0,students.size())
                .filter(index ->
                        students.get(index).getEmail().equals(student)
                ).findFirst()
                .orElse(-1);
        if(studentIndex > -1){
            students.add(studentIndex, student);
            return  student;
        }
        else{
            return null;
        }
    }

    public void deleteStudent(String email) {
        var student = findByEmail(email);
        if(student != null){
            students.remove(student);
        }
    }

}
