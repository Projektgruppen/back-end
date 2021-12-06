package aau.projektgruppen.manova.service;

import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.projection.QARecruiterDTO;
import aau.projektgruppen.manova.model.projection.QASessionDTO;
import aau.projektgruppen.manova.repository.AnswerRepository;
import aau.projektgruppen.manova.repository.OrganisationRepository;
import aau.projektgruppen.manova.repository.QuestionRepository;
import aau.projektgruppen.manova.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The {@code RecruiterService} class makes two methods {@code getReviewedQuestions} and {@code updateAnswer}.
 * @author Laurits Lippert
 * @see aau.projektgruppen.manova.controller.RecruiterController
 * @see OrganisationRepository
 * @see QuestionRepository
 * @see AnswerRepository
 * @see SessionRepository
 */
@Service
public class RecruiterService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    SessionRepository sessionRepository;
    /**
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @return the reviewed questions for a given organisation with the ID that the {@code getId()} returns
     * @throws NotFoundException if the repository doesn't know of the organisation.
     */


    public List<QARecruiterDTO> getReviewedQuestions(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new NotFoundException("Organisation with name: " + organisationName + " not found");
        }

        return questionRepository.findReviewed(organisation.getCurrentSession());
    }

    /**
     * @param answer, of type Answer. Saves answer to {@code answerRepository} and later sets the answer to the
     *                corresponding question and changes the {@code setApproved} to true in the question
     * @param questionId, of type long. The method need the correct questionId in order to save the answer to the
     *                    correct question being answered.
     * @return the questionRepository and saves the question with all its new attributes.
     * @throws NotFoundException if the repository doesn't know if the organisation.
     */
    public Question updateAnswer(Answer answer, long questionId) throws NotFoundException{
        answerRepository.save(answer);
        Question question = questionRepository.findById(questionId).orElseThrow( () ->
            new NotFoundException("Could not find a question with id: " + questionId));

        question.setAnswer(answer);
        question.setTimeOfApproval(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
        question.setApproved(true);
        question.setMarkedForReview(false);
        return questionRepository.save(question);
    }

    /**
     *
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @return the id of the given organisation name by using the {@code findAllSessionsByOrganisationName}
     * @throws NotFoundException, if no organisation with the given {@code organisationName} exists in the {@code organisationRepository}.
     */
    public List<QASessionDTO> getAllSessionsByOrganisationName(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new NotFoundException("Organisation does not exist!");
        }

        return sessionRepository.findAllSessionsByOrganisationName(organisation.getId());
    }
}