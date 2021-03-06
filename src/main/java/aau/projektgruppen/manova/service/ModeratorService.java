package aau.projektgruppen.manova.service;

import aau.projektgruppen.manova.exception.BadRequestException;
import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.model.projection.QAModeratorDTO;
import aau.projektgruppen.manova.repository.OrganisationRepository;
import aau.projektgruppen.manova.repository.QuestionRepository;
import aau.projektgruppen.manova.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

/**
 * The {@code ModeratorService} class makes the following methods:
 * {@code findUnapprovedSessionQuestions}, {@code findUnapprovedQuestions}, {@code approveQuestion}, {@code reviewQuestion},
 * {@code toggleSession}, {@code toggleAutoreview}, {@code newSession}, {@code newOrganisation}.
 *
 * @see aau.projektgruppen.manova.controller.ModeratorController
 * @see OrganisationRepository
 * @see QuestionRepository
 * @see SessionRepository
 */

@Service
public class ModeratorService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    SessionRepository sessionRepository;

    /**
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @return All the unapproved questions in the question repository for that organisation.
     * @throws NotFoundException if the repository doesn't know of the organisation.
     */
    public List<QAModeratorDTO> findUnapprovedSessionQuestions(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new NotFoundException("Organisation with name: " + organisationName + " not found");
        }

        return questionRepository.findUnApproved(organisation.getCurrentSessionId());
    }

    public List<QAModeratorDTO> findUnapprovedQuestions(){
        return questionRepository.findAllUnApproved();
    }

    /**
     *
     * @param questionId, of type long. The method need the correct questionId in order to save the answer to the correct question being answered.
     * @return A new boolean value (true) for approveQuestion to the questionRepository if the if-statement is fulfilled
     * @throws NotFoundException if the repository doesn't know of the organisation.
     */
    public Question approveQuestion(long questionId) throws NotFoundException {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        if (optionalQuestion.isPresent()) {
            Question approveQuestion = optionalQuestion.get();
            approveQuestion.setApproved(true);
            approveQuestion.setTimeOfApproval(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
            approveQuestion.setMarkedForReview(true);
            return questionRepository.save(approveQuestion);
        } else {
            throw new NotFoundException("Question with id " + questionId + " not found");
        }
    }

    /**
     *
     * @param questionId, of type long. The method need the correct questionId in order to save the answer to the correct question being answered.
     * @return A new boolean value (true) for reviewQuestion to the questionRepository if the if-statement is fulfilled.
     * @throws NotFoundException if the repository doesn't know of the organisation.
     */
    public Question reviewQuestion(long questionId) throws NotFoundException {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);

        if(optionalQuestion.isPresent()) {
            Question reviewQuestion = optionalQuestion.get();
            reviewQuestion.setMarkedForReview(true);
            return questionRepository.save(reviewQuestion);
        } else {
            throw new NotFoundException("Question with id: " + questionId + "not found");
        }
    }

    /**
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @param state, takes a string that should be either true or false.
     * @return Session to the sessionRepository.
     * @throws NotFoundException if the repository doesn't know of the organisation or state.
     * @throws BadRequestException if the given state is not valid.
     */
    public Session toggleSession(String organisationName, String state) throws NotFoundException, BadRequestException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new NotFoundException("Organisation with name: " + organisationName + " not found");
        }

        Session session = sessionRepository.getOne(organisation.getCurrentSessionId());
        if (state.equals("true")){
            session.setLive(true);
        } else if(state.equals("false")){
            session.setLive(false);
        } else {
            throw new BadRequestException("The given state was neither true nor false");
        }

        return sessionRepository.save(session);

    }

    /**
     *
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @param state, takes a string that should be either true or false.
     * @return Session to the sessionRepository.
     * @throws NotFoundException if the repository doesn't know of the organisation.
     * @throws BadRequestException if the given state is not valid
     */
    public Session toggleAutoreview(String organisationName, String state) throws NotFoundException, BadRequestException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new NotFoundException("Organisation with name: " + organisationName + " not found");
        }

        Session session = sessionRepository.getOne(organisation.getCurrentSessionId());

        if (state.equals("true")){
            session.setAutoReview(true);
        } else if(state.equals("false")){
            session.setAutoReview(false);
        } else {
            throw new BadRequestException("The given state was neither true nor false");
        }
        return sessionRepository.save(session);
    }

    /**
     *
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @return {@code Session} containing an organisation.
     * @throws NotFoundException if the repository doesn't know of the organisation.
     */
    public Session newSession(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new NotFoundException("Organisation with name: " + organisationName + " not found");
        }

        Session session = new Session(organisation);
        sessionRepository.save(session);
        organisation.setCurrentSessionId(session.getId());
        organisationRepository.save(organisation);

        return session;
    }

    /**
     * @param organisation, takes a string as input to see if the repository knows of the organisation.
     * @return Organisation to organisation repository
     */
    public Organisation newOrganisation(Organisation organisation){
        organisation.setName(organisation.getName().toLowerCase());
        return organisationRepository.save(organisation);
    }

    /**
     * @return All organisations in the organisation repository
     */
    public List<Organisation> findAllOrganisations() {
        return organisationRepository.findAll();
    }

    /**
     *
     * @return A list of all organisations with a new session.
     * @throws NotFoundException if the findAll method returns no organisations
     */
    public List<Organisation> newSessionForAll() throws NotFoundException {
        List<Organisation> organisations = organisationRepository.findAll();
        if (organisations == null) {
            throw new NotFoundException("Organisations not found");
        }
        for(Organisation organisation : organisations){
            Session session = new Session(organisation);
            sessionRepository.save(session);
            organisation.setCurrentSessionId(session.getId());
            organisationRepository.save(organisation);
        }
        return organisations;
    }
}
