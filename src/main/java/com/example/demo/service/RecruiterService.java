package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

@Service
public class RecruiterService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    AnswerRepository answerRepository;

    public List<Collection> getReviewedQuestions(String organisationName){
        if(organisationName.equals("forsvaret")){
            return questionRepository.getReviewedQuestions((1));
        }else if(organisationName.equals("politiet")){
            return questionRepository.getReviewedQuestions((2));
        }
        return null;
    }

    public Answer updateAnswer(Answer answer, long questionId) {
        Question question = questionRepository.getOne(questionId);
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }
}