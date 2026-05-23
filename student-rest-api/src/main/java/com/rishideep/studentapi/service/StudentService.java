package com.rishideep.studentapi.service;

import com.rishideep.studentapi.exception.StudentNotFoundException;
import com.rishideep.studentapi.model.Student;
import com.rishideep.studentapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    // Get student by email
    public Student getStudentByEmail(String email) {
        return studentRepository.findByEmail(email)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with email: " + email));
    }

    // Get students by branch
    public List<Student> getStudentsByBranch(String branch) {
        return studentRepository.findByBranch(branch);
    }

    // Get students by year
    public List<Student> getStudentsByYear(int year) {
        return studentRepository.findByYear(year);
    }

    // Get students by minimum CGPA
    public List<Student> getStudentsByCgpa(double cgpa) {
        return studentRepository.findByCgpaGreaterThanEqual(cgpa);
    }

    // Create new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update existing student
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existing = getStudentById(id);
        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setBranch(updatedStudent.getBranch());
        existing.setYear(updatedStudent.getYear());
        existing.setCgpa(updatedStudent.getCgpa());
        return studentRepository.save(existing);
    }

    // Delete student
    public void deleteStudent(Long id) {
        Student existing = getStudentById(id);
        studentRepository.delete(existing);
    }
}
