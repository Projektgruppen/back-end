package aau.projektgruppen.manova.service;

import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.model.projection.QAStudentDTO;
import aau.projektgruppen.manova.repository.OrganisationRepository;
import aau.projektgruppen.manova.repository.QuestionRepository;
import aau.projektgruppen.manova.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The {@code StudentService} class makes 2 methods {@code getApprovedQuestions} and {@code saveQuestion}.
 * @author Laurits Lippert
 * @see Session
 */
@Service
public class StudentService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    /**
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @return the list of questions where the {@code findApproved} is true of the organisation id corresponds with the name.
     * @throws NotFoundException if the repository doesn't know of the organisation.
     */
    public List<QAStudentDTO> getApprovedQuestions(String organisationName) throws NotFoundException {
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new NotFoundException("Organisation with name: " + organisationName + " not found");
        }

        return questionRepository.findApproved(organisation.getCurrentSession());


    }

    /**
     * @param question, takes a question of type Question as an input.
     *                  Inside the method the question is set to a specific session that gets an ID
     *                  for the organisation.
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @return saves the question to the question repository
     * @throws NotFoundException if the repository doesn't know of the organisation.
     */
    public Question saveQuestion(Question question, String organisationName) throws NotFoundException{
        Organisation organisation = organisationRepository.findByName(organisationName);

        if (organisation == null) {
            throw new NotFoundException("Organisation with name: " + organisationName + " not found");
        }

        question.setSession(sessionRepository.getOne(organisation.getCurrentSession()));
        return questionRepository.save(question);
    }
}
