package com.example.demo.repository;

import com.example.demo.model.Question;
import com.example.demo.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends JpaRepository <Question, Long> {
    @Query(value = "SELECT * FROM QUESTION WHERE approve = true", nativeQuery = true)
    List<Question> getAllApprovedQuestions();


    @Query(value = "SELECT answers.id, answers.answer, questions.question\n" +
            "FROM answers\n" +
            "INNER JOIN  questions ON answers.id = questions.id\n" +
            "WHERE questions.session_id = ?1", nativeQuery = true)
    List<Object> getApprovedQuestions(int session_id);

}
