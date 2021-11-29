package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.Session;
import com.example.demo.model.projection.QAModeratorDTO;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ModeratorService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    SessionRepository sessionRepository;

    public List<QAModeratorDTO> findUnapprovedSessionQuestions(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No unapproved questions");
        }

        return questionRepository.findUnApproved(organisation.getId());
    }

    public List<QAModeratorDTO> findUnapprovedQuestions() throws NotFoundException {
        return questionRepository.findAllUnApproved();
    }

    //Consider changing .orElseThrow to the same structure as the other methods
    public Question approveQuestion(long questionId) throws NotFoundException {
        Question approveQuestion = questionRepository.findById(questionId).orElseThrow( () ->
            new NotFoundException("Question with id " + questionId + " not found"));
        approveQuestion.setApproved(true);
        approveQuestion.setMarkedForReview(true);
        return questionRepository.save(approveQuestion);
    }

    //Consider changing .orElseThrow to the same structure as the other methods
    public Question reviewQuestion(long questionId) throws NotFoundException {
        Question reviewQuestion = questionRepository.findById(questionId).orElseThrow();
        reviewQuestion.setMarkedForReview(true);
        return questionRepository.save(reviewQuestion);
    }

    public Session toggleSession(String organisationName, String state) throws NotFoundException{
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organisation with name: " + organisationName + " not found");
        }

        Session session = sessionRepository.getOne(organisation.getCurrentSession());
        if (state.equals("true")){
            session.setLive(true);
        } else if(state.equals("false")){
            session.setLive(false);
        }

        return sessionRepository.save(session);

    }

    public Session toggleAutoreview(String organisationName, String state) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organisation with name: " + organisationName + " not found");
        }

        Session session = sessionRepository.getOne(organisation.getCurrentSession());
        /*
         * Would it make more sense to throw another exception here?
         * after session is initialized? (question for Andres)
         */

        if (state.equals("true")){
            session.setAutoReview(true);
        } else if(state.equals("false")){
            session.setAutoReview(false);
        }
        return sessionRepository.save(session);
    }

    public Session newSession(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organisation with name: " + organisationName + " not found");
        }

        Session session = new Session(organisation);
        sessionRepository.save(session);
        organisation.setCurrentSession(session.getId());
        organisationRepository.save(organisation);

        return session;
    }

    public Organisation newOrganisation(Organisation organisation) throws NotFoundException {
        return organisationRepository.save(organisation);
    }
}
