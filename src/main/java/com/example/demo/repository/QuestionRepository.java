package com.example.demo.repository;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Collection;
import java.util.List;

public interface QuestionRepository extends JpaRepository <Question, Long> {
    @Query(value = "SELECT answers.answer, questions.question\n" +
            "FROM answers\n" +
            "INNER JOIN questions ON answers.id = questions.id\n" +
            "WHERE questions.session_id = ?1", nativeQuery = true)
    List<Collection> getApprovedQuestions(int session_id);

    @Query(value = "SELECT answers.question_id, questions.question, answers.id, answers.answer\n" +
        "FROM answers\n" +
        "INNER JOIN questions ON answers.id = questions.id\n" +
        "WHERE questions.session_id = ?1 \n" +
        "AND questions.review = true", nativeQuery = true)
    List<Collection> getReviewedQuestions(long session_id);

}
