package com.example.demo.service;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.projection.QAStudentDTO;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OrganisationRepository organisationRepository;


    public List<QAStudentDTO> getApprovedQuestions(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find approved questions for: " + organisationName);
        }

        return questionRepository.findApproved(organisation.getId());


    }

    public Question saveQuestion(Question question, String organisationName) throws NotFoundException{
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find organisation");
        }

        question.setSession(sessionRepository.getOne(organisation.getId()));
        return questionRepository.save(question);
    }
}
