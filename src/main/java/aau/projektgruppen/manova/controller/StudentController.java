package aau.projektgruppen.manova.controller;

import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.exception.NotFoundException;
import aau.projektgruppen.manova.model.projection.QAStudentDTO;
import aau.projektgruppen.manova.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * The {@code StudentController} class collects all the various functionalities that the student needs.
 * Imports {@code StudentService} and uses its methods.
 *
 * @author Laurits Lippert
 */

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Returns every approved question from a given organisation.
     *
     * @param organisationName, A {@code String} that contains the name of an organisation.
     * @return A {@code List} containing every approved question from a given organisation's session.
     */
    @GetMapping("{organisationName}/questions")
    public List<QAStudentDTO> getAllApprovedQuestions(@PathVariable String organisationName) {
        try {
            return studentService.getApprovedQuestions(organisationName);
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find approved questions for: " + organisationName, e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

    /**
     * Creates a new question entity in the database from a given {@code Question} object and an organisation name.
     *
     * @param question,         A {@code Question} object containing the question to send to the database.
     * @param organisationName, A {@code String} object containing the name of an organisation.
     * @return A {@code ResponseEntity} containing a {@code Question} object.
     */
    @PostMapping("{organisationName}/question")
    public ResponseEntity<Question> createQuestion(@PathVariable String organisationName, @RequestBody Question question) {
        System.out.println(organisationName + " " + question);
        try {
            return ResponseEntity.ok(studentService.saveQuestion(question, organisationName));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not create question", e);
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return null;
        }
    }

}
