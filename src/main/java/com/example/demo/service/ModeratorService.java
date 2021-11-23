package com.example.demo.service;

import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.projection.QAModeratorDTO;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.user.ModeratorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeratorService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;



    public List<QAModeratorDTO> findUnapprovedSessionQuestions(String session) {
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if (organisation.getName().equals(session)){
                return questionRepository.findUnApproved(organisation.getId());
            }
        }
        return null;
    }

    public List<QAModeratorDTO> findUnapprovedQuestions() {
        return questionRepository.findAllUnApproved();
    }


    public Question approveQuestion(long questionId) {
        Question approveQuestion = questionRepository.findById(questionId).orElseThrow(( () -> new ResourceNotFoundException("Question does not exist with id " + questionId)));
        approveQuestion.setApprove(true);
        approveQuestion.setReview(true);
        return questionRepository.save(approveQuestion);
    }

    public Question reviewQuestion(long questionId) {
        Question reviewQuestion = questionRepository.findById(questionId).orElseThrow(( () -> new ResourceNotFoundException("Question does not exist with id " + questionId)));
        reviewQuestion.setReview(true);
        return questionRepository.save(reviewQuestion);
    }


}
