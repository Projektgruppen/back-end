package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OrganisationRepository organisationRepository;


    public List<Collection> getApprovedQuestions(String organisationName){
        //!TODO fixes noget med enums her måske. (eller noget som henter listen af organisationer i databasen og sammenligner med dem) map måske?
        if(organisationName.equals("forsvaret")){

            return questionRepository.getApprovedQuestions((1));
        }else if(organisationName.equals("politiet")){
            return questionRepository.getApprovedQuestions((2));
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
