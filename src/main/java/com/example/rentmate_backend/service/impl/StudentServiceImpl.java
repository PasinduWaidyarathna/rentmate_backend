package com.example.rentmate_backend.service.impl;

import com.example.rentmate_backend.exceptions.student.StudentException;
import com.example.rentmate_backend.model.Student;
import com.example.rentmate_backend.repository.StudentRepository;
import com.example.rentmate_backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(String id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null); // Return null or throw an exception if not found
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(String id, Student updatedStudent) {
        /*if (studentRepository.existsById(id)) {
            return studentRepository.save(student);
        }
        return null; // Return null or throw an exception if not found*/
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            // Map the updated properties from the incoming student object
            Student upStd = existingStudent.get();
            upStd.setFirstName(updatedStudent.getFirstName());
            upStd.setLastName(updatedStudent.getLastName());
            upStd.setEmail(updatedStudent.getEmail());
            upStd.setDepartment(updatedStudent.getDepartment());
            upStd.setYearOfEnrollment(updatedStudent.getYearOfEnrollment());

            // Update other properties as needed
            return studentRepository.save(upStd);
        } else {
            throw new StudentException("Student with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
    @Override
    public List<Student> getStudentsByYearOfEnrollment(int year) {
        return studentRepository.findByYearOfEnrollment(year);
    }

    @Override
    public String getDepartmentByStudentId(String id) {
        return studentRepository.findDepartmentByStudentId(id);
    }

    @Override
    public void deleteStudentsByYearOfEnrollment(int year) {
        studentRepository.deleteByYearOfEnrollment(year);
    }
}
