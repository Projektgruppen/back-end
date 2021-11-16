package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository <Student, Long> {
    @Query(value = "SELECT * FROM Question WHERE approve = true", nativeQuery = true)
    List<Student> getAllApprovedQuestions();
}