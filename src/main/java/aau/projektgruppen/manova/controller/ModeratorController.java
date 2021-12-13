package aau.projektgruppen.manova.controller;

import aau.projektgruppen.manova.exception.BadRequestException;
import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.Session;
import aau.projektgruppen.manova.model.projection.QAModeratorDTO;
import aau.projektgruppen.manova.service.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * The {@code ModeratorController} class collects all the various functionalities that the moderator needs.
 * It imports {@code ModeratorService} and uses its methods.
 *
 * @author Laurits Lippert
 */

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/moderator")
public class ModeratorController {

    @Autowired
    private ModeratorService moderatorService;

    /**
     * Returns every unapproved question from a given session.
     *
     * @param organisationName, A {@code String} that contains the name of a session.
     * @return A {@code List} containing every approved question from a given organisation's session.
     */
    @GetMapping("{organisationName}/questions")
    public List<QAModeratorDTO> getAllUnapprovedSessionQuestions(@PathVariable String organisationName) {
        try {
            return moderatorService.findUnapprovedSessionQuestions(organisationName);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No unapproved questions", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @return all unapproved messages regardless of session id.
     */
    @GetMapping("questions")
    public List<QAModeratorDTO> getAllUnapprovedQuestions() {
        try {
            return moderatorService.findUnapprovedQuestions();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @return all organisations in the system
     */
    @GetMapping("organisations")
    public List<Organisation> getAllOrganisations() {
        try {
            return moderatorService.findAllOrganisations();
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @param questionId a long that has the id of question.
     * @return Finds message by {@code questionId} and set approve to true
     */
    @PutMapping("approve/{questionId}")
    public ResponseEntity<Question> approveQuestion(@PathVariable long questionId) {
        try {
            return ResponseEntity.ok(moderatorService.approveQuestion(questionId));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question Id not found" + questionId, e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * Uses a given id to identify a question and set approved to true.
     *
     * @param questionId, A {@code long} specifying the id of the question.
     * @return A {@code ResponseEntity} containing a question.
     */
    @PutMapping("review/{questionId}")
    public ResponseEntity<Question> reviewQuestion(@PathVariable long questionId) {
        try {
            return ResponseEntity.ok(moderatorService.reviewQuestion(questionId));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question Id Not Found" + questionId, e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @param state,            takes a string that should be either true or false.
     * @return Set session toggle value on/off
     * @throws org.springframework.web.server.ResponseStatusException throws a not found or bad request exception
     */
    @PutMapping("{organisationName}/toggle/{state}")
    public ResponseEntity<Session> toggleSession(@PathVariable String organisationName, @PathVariable String state) {
        try {
            return ResponseEntity.ok(moderatorService.toggleSession(organisationName, state));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provide correct organisation name", e);
        } catch (BadRequestException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide a legal value for state. Either true or false", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @param state,            takes a string that should be either true or false.
     * @return Set session toggle value on/off
     * @throws org.springframework.web.server.ResponseStatusException throws a not found or bad request exception
     */
    @PutMapping("{organisationName}/autoreview/{state}")
    public ResponseEntity<Session> toggleAutoreview(@PathVariable String organisationName, @PathVariable String state) {
        try {
            return ResponseEntity.ok(moderatorService.toggleAutoreview(organisationName, state));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provide correct organisation name", e);
        } catch (BadRequestException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide a legal value for state. Either true or false", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @param organisationName, takes a string as input to see if the repository knows of the organisation.
     * @return creates new session for the given {@code organisationName}
     */
    @PostMapping("{organisationName}/newsession")
    public ResponseEntity<Session> newSession(@PathVariable String organisationName) {
        try {
            return ResponseEntity.ok(moderatorService.newSession(organisationName));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provide correct organisation name", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    @PostMapping("/newsessionforall")
    public ResponseEntity<List<Organisation>> newSessionForAll() {
        try {
            return ResponseEntity.ok(moderatorService.newSessionForAll());
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provide correct organisations", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * @param organisation, takes a string as input to see if the repository knows of the organisation.
     * @return creates a new organisation with the name {@code organisationName}.
     */
    @PostMapping("neworganisation")
    public ResponseEntity<Organisation> newOrganisation(@RequestBody Organisation organisation) {
        try {
            return ResponseEntity.ok(moderatorService.newOrganisation(organisation));
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }
}
