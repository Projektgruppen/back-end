package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Answer;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.projection.QAModeratorDTO;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class RecruiterService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    AnswerRepository answerRepository;

    public List<QAModeratorDTO> getReviewedQuestions(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reviewed questions not found");
        }

        return questionRepository.findReviewed(organisation.getId());
    }

    public Question updateAnswer(Answer answer, long questionId) throws NotFoundException{
        answerRepository.save(answer);
        Question question = questionRepository.findById(questionId).orElseThrow( () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find a question with that id");
        });

        question.setAnswer(answer);
        question.setApproved(true);
        question.setMarkedForReview(false);
        return questionRepository.save(question);
    }
}