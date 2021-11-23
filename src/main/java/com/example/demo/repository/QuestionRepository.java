package com.example.demo.repository;

import com.example.demo.model.Question;
import com.example.demo.model.projection.QARecruiterDTO;
import com.example.demo.model.projection.QAStudentDTO;
import com.example.demo.model.projection.QAModeratorDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Collection;
import java.util.List;

public interface QuestionRepository extends JpaRepository <Question, Long> {
    @Query("SELECT new com.example.demo.model.projection.QAStudentDTO(q.question, a.answer) FROM Answer a JOIN a.question q WHERE a.question.approve = true")
    List<QAStudentDTO> findApproved(long session_id);

    @Query("SELECT new com.example.demo.model.projection.QARecruiterDTO(q.question, a.answer, q.id, a.id) FROM Answer a JOIN a.question q WHERE a.question.review = true")
    List<QARecruiterDTO> findReviewed(long session_id);

    @Query("SELECT new com.example.demo.model.projection.QAModeratorDTO(q.question, q.id) FROM Question q WHERE q.approve = false")
    List<QAModeratorDTO> findUnApproved(long session_id);






}
