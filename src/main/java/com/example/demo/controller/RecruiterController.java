package com.example.demo.controller;

import com.example.demo.model.Answer;
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

    //Check if message is approved.
    @GetMapping("{organisationName}/questions")
    public List<QARecruiterDTO> getReviewedQuestions(@PathVariable String organisationName){
        return recruiterService.getReviewedQuestions(organisationName);
    }
    @PutMapping("answer/{questionId}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable long questionId,@RequestBody Answer answer) {
        return ResponseEntity.ok(recruiterService.updateAnswer(answer, questionId));
    }

}
