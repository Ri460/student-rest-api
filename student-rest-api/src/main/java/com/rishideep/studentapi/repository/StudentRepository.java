package com.rishideep.studentapi.repository;

import com.rishideep.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Find student by email
    Optional<Student> findByEmail(String email);

    // Find all students by branch
    List<Student> findByBranch(String branch);

    // Find all students by year
    List<Student> findByYear(int year);

    // Find students with CGPA greater than a value
    List<Student> findByCgpaGreaterThanEqual(double cgpa);
}
