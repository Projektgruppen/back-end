package com.example.demo.repository;

import com.example.demo.model.Answer;
import com.example.demo.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository <Answer, Long> {

}
