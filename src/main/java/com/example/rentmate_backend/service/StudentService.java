package com.example.rentmate_backend.service;

import com.example.rentmate_backend.model.Student;
import java.util.List;
public interface StudentService {
    Student createStudent(Student student);
    Student getStudentById(String id);
    List<Student> getAllStudents();
    Student updateStudent(String id, Student Student);
    void deleteStudent(String id);
    List<Student> getStudentsByYearOfEnrollment(int year);
    String getDepartmentByStudentId(String id);
    void deleteStudentsByYearOfEnrollment(int year);
}
