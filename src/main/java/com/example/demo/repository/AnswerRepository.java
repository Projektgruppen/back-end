package com.example.demo.repository;

import com.example.demo.model.Answer;
//import com.example.demo.model.QAMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository <Answer, Long> {
}
