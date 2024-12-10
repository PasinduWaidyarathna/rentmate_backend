package com.example.rentmate_backend.controller;

import com.example.rentmate_backend.model.Student;
import com.example.rentmate_backend.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@Tag(name="StudentController",description="To perform operations on students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create a new student
    @Operation(
            summary = "POST operation on students",
            description = "It is used to save student object in database"
    )
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    // Get all students
    @Operation(
            summary = "GET operation on students",
            description = "Endpoint to fetch a list of all students from the database"
    )
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Get student by ID
    @Operation(
            summary = "GET - Find student by ID",
            description = "Endpoint to retrieve a specific student using their unique identifier"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Student student = studentService.getStudentById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    // Update student
    @Operation(
            summary = "PUT operation on students",
            description = "Endpoint to update an existing student's details using their ID"
    )
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    // Delete student by ID
    @Operation(
            summary = "DELETE operation on students",
            description = "Endpoint to remove a specific student from the database using their unique identifier"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get students by year of enrollment
    @Operation(
            summary = "GET - Find students by enrollment year",
            description = "Endpoint to retrieve a list of students enrolled in a specific year"
    )
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Student>> getStudentsByYear(@PathVariable int year) {
        List<Student> students = studentService.getStudentsByYearOfEnrollment(year);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    // Get department by student ID
    @Operation(
            summary = "GET - Retrieve student's department",
            description = "Endpoint to fetch the department of a specific student using their ID"
    )
    @GetMapping("/department/{id}")
    public ResponseEntity<String> getDepartmentById(@PathVariable String id) {
        String department = studentService.getDepartmentByStudentId(id);
        if (department == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    // Delete students by year of enrollment
    @Operation(
            summary = "Delete students by enrollment year",
            description = "Endpoint to remove all students enrolled in a specific year"
    )
    @DeleteMapping("/year/{year}")
    public ResponseEntity<Void> deleteStudentsByYear(@PathVariable int year) {
        studentService.deleteStudentsByYearOfEnrollment(year);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}