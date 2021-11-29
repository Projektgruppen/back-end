package aau.projektgruppen.manova.service;

import aau.projektgruppen.manova.repository.QuestionRepository;
import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.projection.QAModeratorDTO;
import aau.projektgruppen.manova.repository.AnswerRepository;
import aau.projektgruppen.manova.repository.OrganisationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class RecruiterService {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    OrganisationRepository organisationRepository;

    @Autowired
    AnswerRepository answerRepository;

    public List<QAModeratorDTO> getReviewedQuestions(String organisationName) throws NotFoundException {
        List<Organisation> organisations = organisationRepository.findAll();

        for (Organisation organisation: organisations) {
            if (organisation.getName().equals(organisationName)){
                return questionRepository.findReviewed(organisation.getId());
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reviewed questions not found");

    }

    public Question updateAnswer(Answer answer, long questionId) throws NotFoundException{
        answerRepository.save(answer);
        Question question = questionRepository.findById(questionId).orElseThrow( () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find a question with that id");
        });
        question.setAnswer(answer);
        question.setApproved(true);
        question.setMarkedForReview(false);
        return questionRepository.save(question);
    }
}