package aau.projektgruppen.manova.controller;

import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.model.projection.QARecruiterDTO;
import aau.projektgruppen.manova.model.projection.QASessionDTO;
import aau.projektgruppen.manova.service.RecruiterService;
import aau.projektgruppen.manova.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * The {@code StudentController} class collects all the various functionalities that the student needs.
 * It imports {@code StudentService} and uses its methods.
 *
 * @author Laurits Lippert
 * @see Session
 */
@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    /**
     * Returns every question marked for review from a given organisation.
     * @param organisationName, A {@code String} that contains the name of an organisation.
     * @return A {@code List} containing every question marked for review from a given organisation's session.
     */
    @GetMapping("{organisationName}/questions")
    public List<QARecruiterDTO> getReviewedQuestions(@PathVariable String organisationName){
        try{
            return recruiterService.getReviewedQuestions(organisationName);
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reviewed questions not found", e);
        }
    }

    /**
     *
     * @param questionId
     * @param answer, of type Answer. Updates {@code answer} to question with {@code questionId}
     * @return
     */
    @PutMapping("answer/{questionId}")
    public ResponseEntity<Question> updateAnswer(@PathVariable long questionId, @RequestBody Answer answer) {
        try {
            return ResponseEntity.ok(recruiterService.updateAnswer(answer, questionId));
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reviewed questions not found", e);
        }
    }
    @GetMapping("{organisationName}/logs")
    public List<QASessionDTO>getAllSessionsByOrganisationName(@PathVariable String organisationName){
        try{
            return recruiterService.getAllSessionsByOrganisationName(organisationName);
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Organisation not found", e);
        }
    }


}
