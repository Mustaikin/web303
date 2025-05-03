package org.example.lab2.service;
import org.example.lab2.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Long id, Student updatedStudent);
    void deleteStudent(Long id);

    void setStudent(Student student);
}
