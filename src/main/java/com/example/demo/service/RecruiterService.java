package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.projection.QARecruiterDTO;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class RecruiterService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    AnswerRepository answerRepository;

    public List<QARecruiterDTO> getReviewedQuestions(String organisationName) {
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if (organisation.getName().equals(organisationName)){
                return questionRepository.findReviewed(organisation.getId());
            }
        }
        return null;

    }

    public Answer updateAnswer(Answer answer, long questionId) {
        Question question = questionRepository.getOne(questionId);
        question.setApprove(true);
        answer.setQuestion(question);
        return answerRepository.save(answer);
    }
}