package com.example.demo.service;

import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.projection.QAStudentDTO;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OrganisationRepository organisationRepository;


    public List<QAStudentDTO> getApprovedQuestions(String organisationName){
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if (organisation.getName().equals(organisationName)){
                return questionRepository.findApproved(organisation.getId());
            }
        }
        return null;
    }

    public Question saveQuestion(Question question, String organisationName) {
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if (organisation.getName().equals(organisationName)){
                question.setSession(sessionRepository.getOne(organisation.getId()));

                return questionRepository.save(question);
            }
        }
        return null;
    }
}
