package aau.projektgruppen.manova.service;

import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.projection.QAStudentDTO;
import aau.projektgruppen.manova.repository.OrganisationRepository;
import aau.projektgruppen.manova.repository.QuestionRepository;
import aau.projektgruppen.manova.repository.SessionRepository;
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
