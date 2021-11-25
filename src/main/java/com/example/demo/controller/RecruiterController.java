package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.model.projection.QAModeratorDTO;
import com.example.demo.model.projection.QARecruiterDTO;
import com.example.demo.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    /**
     * Returns every question marked for review from a given organisation.
     * @param organisationName, A {@code String} that contains the name of an organisation.
     * @return A {@code List} containing every question marked for review from a given organisation's session.
     */
    @GetMapping("{organisationName}/questions")
    public List<QAModeratorDTO> getReviewedQuestions(@PathVariable String organisationName){
        return recruiterService.getReviewedQuestions(organisationName);
    }
    @PutMapping("answer/{questionId}")
    public ResponseEntity<Question> updateAnswer(@PathVariable long questionId, @RequestBody Answer answer) {
        return ResponseEntity.ok(recruiterService.updateAnswer(answer, questionId));
    }

}
