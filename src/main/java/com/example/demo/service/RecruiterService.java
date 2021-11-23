package com.example.demo.service;

import com.example.demo.helper.RecruiterParser;
import com.example.demo.model.Answer;
import com.example.demo.model.Organisation;
import com.example.demo.model.QAMessage;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Array;
import java.util.*;

@Service
public class RecruiterService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    AnswerRepository answerRepository;

    public List<QAMessage> getReviewedQuestions(String organisationName) {
        List<QAMessage> qaMessages;
        switch (organisationName) {
            case "forsvaret":
                qaMessages = RecruiterParser.parse(1, questionRepository);
                return qaMessages;

            case "politiet":
                qaMessages = RecruiterParser.parse(2, questionRepository);
                return qaMessages;
            //add new organisation here case "Folkekirken" fx.
            default:
                return null;
        }
    }

    public Answer updateAnswer(Answer answer, long questionId) {
        Question question = questionRepository.getOne(questionId);
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }
}