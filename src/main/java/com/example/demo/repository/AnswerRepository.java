package com.example.demo.repository;

import com.example.demo.model.Answer;
import com.example.demo.model.QAMessage;
import com.example.demo.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository <Answer, Long> {
    //!TODO: Change queries, so they match the models.
    @Query(value = "SELECT * FROM ANSWER WHERE (answer IS NULL AND approve = true)", nativeQuery = true)
    List<Answer> getAllNoneAnsweredApprovedQAMessages();

}
