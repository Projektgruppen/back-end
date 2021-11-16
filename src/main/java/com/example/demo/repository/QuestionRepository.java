package com.example.demo.repository;

import com.example.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository <Question, Long> {
    @Query(value = "SELECT * FROM QUESTION WHERE approve = true", nativeQuery = true)
    List<Question> getAllApprovedQuestions();
}
