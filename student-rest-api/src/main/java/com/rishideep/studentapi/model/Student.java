package com.rishideep.studentapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Branch is required")
    private String branch;

    @Min(value = 1, message = "Year must be at least 1")
    @Max(value = 4, message = "Year must be at most 4")
    private int year;

    @DecimalMin(value = "0.0", message = "CGPA must be at least 0.0")
    @DecimalMax(value = "10.0", message = "CGPA must be at most 10.0")
    private double cgpa;

    // ─── Constructors ───────────────────────────────────────────────
    public Student() {}

    public Student(String name, String email, String branch, int year, double cgpa) {
        this.name = name;
        this.email = email;
        this.branch = branch;
        this.year = year;
        this.cgpa = cgpa;
    }

    // ─── Getters & Setters ──────────────────────────────────────────
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getBranch() { return branch; }
    public void setBranch(String branch) { this.branch = branch; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', email='" + email +
               "', branch='" + branch + "', year=" + year + ", cgpa=" + cgpa + "}";
    }
}
