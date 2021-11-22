package com.example.demo.repository;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Collection;
import java.util.List;

public interface QuestionRepository extends JpaRepository <Question, Long> {
    @Query(value = "SELECT * FROM QUESTION WHERE approve = true", nativeQuery = true)
    List<Question> getAllApprovedQuestions();


    @Query(value = "SELECT answers.answer, questions.question\n" +
            "FROM answers\n" +
            "INNER JOIN  questions ON answers.id = questions.id\n" +
            "WHERE questions.session_id = ?1", nativeQuery = true)
    List<Collection> getApprovedQuestions(int session_id);

    @Query("SELECT u FROM Answer u WHERE u.id = ?1")
    Answer findUserByStatus(long id);

}
