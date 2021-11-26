package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.model.projection.QAStudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * Returns every approved question from a given organisation.
     * @param organisationName, A {@code String} that contains the name of an organisation.
     * @return A {@code List} containing every approved question from a given organisation's session.
     */
    @GetMapping("{organisationName}/questions")
    public List<QAStudentDTO> getAllApprovedQuestions(@PathVariable String organisationName){
        return studentService.getApprovedQuestions(organisationName);
    }

    /**
     * Creates a new question entity in the database from a given {@code Question} object and an organisation name.
     * @param question, A {@code Question} object containing the question to send to the database.
     * @param organisationName, A {@code String} object containing the name of an organisation.
     * @return {@code ResponseEntity} containing a {@code Question} object.
     */
    @PostMapping("{organisationName}/question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question, @PathVariable String organisationName){
        return ResponseEntity.ok(studentService.saveQuestion(question, organisationName));
    }

}
