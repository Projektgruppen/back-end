package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.QAMessage;
import com.example.demo.model.Question;
import org.apache.velocity.exception.ResourceNotFoundException;
import com.example.demo.service.RecruiterService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService;

    //Check if message is approved.
    @GetMapping("/{organisationName}")
    public List<QAMessage> getReviewedQuestions(@PathVariable String organisationName){
        return recruiterService.getReviewedQuestions(organisationName);
    }
    @PutMapping("/{questionId}")
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer, @PathVariable long questionId) {
        return ResponseEntity.ok(recruiterService.updateAnswer(answer, questionId));
    }

}
