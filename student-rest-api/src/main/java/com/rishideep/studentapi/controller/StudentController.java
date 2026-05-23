package com.rishideep.studentapi.controller;

import com.rishideep.studentapi.model.Student;
import com.rishideep.studentapi.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // GET /api/students — Get all students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    // GET /api/students/{id} — Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // GET /api/students/email/{email} — Get student by email
    @GetMapping("/email/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable String email) {
        return ResponseEntity.ok(studentService.getStudentByEmail(email));
    }

    // GET /api/students/branch/{branch} — Get students by branch
    @GetMapping("/branch/{branch}")
    public ResponseEntity<List<Student>> getStudentsByBranch(@PathVariable String branch) {
        return ResponseEntity.ok(studentService.getStudentsByBranch(branch));
    }

    // GET /api/students/year/{year} — Get students by year
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Student>> getStudentsByYear(@PathVariable int year) {
        return ResponseEntity.ok(studentService.getStudentsByYear(year));
    }

    // GET /api/students/cgpa/{cgpa} — Get students with CGPA >= value
    @GetMapping("/cgpa/{cgpa}")
    public ResponseEntity<List<Student>> getStudentsByCgpa(@PathVariable double cgpa) {
        return ResponseEntity.ok(studentService.getStudentsByCgpa(cgpa));
    }

    // POST /api/students — Create new student
    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(student));
    }

    // PUT /api/students/{id} — Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                  @Valid @RequestBody Student student) {
        return ResponseEntity.ok(studentService.updateStudent(id, student));
    }

    // DELETE /api/students/{id} — Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student with ID " + id + " deleted successfully.");
    }
}
