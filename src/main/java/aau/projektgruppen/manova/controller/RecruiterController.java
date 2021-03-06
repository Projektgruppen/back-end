package aau.projektgruppen.manova.controller;

import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.model.Question;
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
 */
@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    /**
     * Returns every question marked for review from a given organisation.
     *
     * @param organisationName, A {@code String} that contains the name of an organisation.
     * @return A {@code List} containing every question marked for review from a given organisation's session.
     */
    @GetMapping("{organisationName}/questions")
    public List<QARecruiterDTO> findReviewedQuestions(@PathVariable String organisationName) {
        try {
            return recruiterService.findReviewedQuestions(organisationName);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reviewed questions not found", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @param questionId, a long containing the ID of the question.
     * @param answer, of type Answer. Updates {@code answer} to question with {@code questionId}
     * @return A call to the {@code updateAnswer} in the recruiter service layer.
     */
    @PutMapping("answer/{questionId}")
    public ResponseEntity<Question> updateAnswer(@PathVariable long questionId, @RequestBody Answer answer) {
        try {
            return ResponseEntity.ok(recruiterService.updateAnswer(answer, questionId));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Reviewed questions not found", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @param organisationName The name of the specific organisation ex. forsvaret or politiet.
     * @return A call to the {@code updateAnswer} in the recruiter service layer.
     */
    @GetMapping("{organisationName}/logs")
    public List<QASessionDTO> findAllSessionsByOrganisationName(@PathVariable String organisationName) {
        try {
            return recruiterService.findAllSessionsByOrganisationName(organisationName);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, " Organisation not found", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }


}
