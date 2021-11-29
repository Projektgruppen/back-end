package aau.projektgruppen.manova.service;

import aau.projektgruppen.manova.exception.BadRequestException;
import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.repository.OrganisationRepository;
import aau.projektgruppen.manova.repository.QuestionRepository;
import aau.projektgruppen.manova.repository.SessionRepository;
import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.model.projection.QAModeratorDTO;
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
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if (organisation.getName().equals(organisationName)){
                return questionRepository.findUnApproved(organisation.getId());
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No unapproved questions");
    }

    public List<QAModeratorDTO> findUnapprovedQuestions() throws NotFoundException {
        return questionRepository.findAllUnApproved();

    }


    public Question approveQuestion(long questionId) throws NotFoundException {
        Question approveQuestion = questionRepository.findById(questionId).orElseThrow( () ->
            new NotFoundException("Question with id " + questionId + " not found"));
        approveQuestion.setApproved(true);
        approveQuestion.setMarkedForReview(true);
        return questionRepository.save(approveQuestion);
    }

    public Question reviewQuestion(long questionId) throws NotFoundException {
        Question reviewQuestion = questionRepository.findById(questionId).orElseThrow();
        reviewQuestion.setMarkedForReview(true);
        return questionRepository.save(reviewQuestion);
    }

    public Session toggleSession(String organisationName, String state) throws NotFoundException{
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if (organisation.getName().equals(organisationName)){
                Session session = sessionRepository.getOne(organisation.getCurrentSession());
                if (state.equals("true")){
                    session.setLive(true);
                } else if(state.equals("false")){
                    session.setLive(false);
                }
                return sessionRepository.save(session);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organisation not found in repository");
    }

    public Session toggleAutoreview(String organisationName, String state) throws NotFoundException {
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if (organisation.getName().equals(organisationName)){
                Session session = sessionRepository.getOne(organisation.getCurrentSession());
                if (state.equals("true")){
                    session.setAutoReview(true);
                } else if(state.equals("false")){
                    session.setAutoReview(false);
                }
                return sessionRepository.save(session);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organisation not found");
    }

    public Session newSession(String organisationName) throws NotFoundException{
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if(organisation.getName().equals(organisationName)){
                Session session = new Session(organisation);
                sessionRepository.save(session);
                organisation.setCurrentSession(session.getId());
                organisationRepository.save(organisation);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organisation not found");
    }

    public Organisation newOrganisation(Organisation organisation) throws BadRequestException {
        return organisationRepository.save(organisation);
    }
}
