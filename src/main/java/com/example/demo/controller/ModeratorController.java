package com.example.demo.controller;

//import com.example.demo.model.QAMessage;
//import com.example.demo.repository.MessageRepository;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.Session;
import com.example.demo.model.projection.QAModeratorDTO;
import com.example.demo.service.ModeratorService;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/moderators")
public class ModeratorController {

    @Autowired
    private ModeratorService moderatorService;


    //Get all unapproved questions from session
    @GetMapping("{session}/questions")
    public List<QAModeratorDTO> getAllUnapprovedSessionQuestions(@PathVariable String session){
        return moderatorService.findUnapprovedSessionQuestions(session);
    }

    //Check if message is unapproved.
    @GetMapping("questions")
    public List<QAModeratorDTO> getAllUnapprovedQuestions(){
        return moderatorService.findUnapprovedQuestions();
    }

    //Finds message by Id and set approve to true
    @PutMapping("approve/{questionId}")
    public ResponseEntity<Question> approveQuestion(@PathVariable long questionId) {
        return ResponseEntity.ok(moderatorService.approveQuestion(questionId));
    }

    //Finds message by Id and set approve to true
    @PutMapping("review/{questionId}")
    public ResponseEntity<Question> reviewQuestion(@PathVariable long questionId) {
        return ResponseEntity.ok(moderatorService.reviewQuestion(questionId));
    }

    //Set session toggle value on/off
    @PutMapping("{organisationName}/toggle/{state}")
    public ResponseEntity<Session> toggleSession(@PathVariable String organisationName, @PathVariable String state) {
        return ResponseEntity.ok(moderatorService.toggleSession(organisationName,state));
    }

    //Set session toggle value on/off
    @PutMapping("{organisationName}/autoreview/{state}")
    public ResponseEntity<Session> toggleAutoreview(@PathVariable String organisationName, @PathVariable String state) {
        return ResponseEntity.ok(moderatorService.toggleAutoreview(organisationName,state));
    }


    @PostMapping("{organisationName}/newsession")
    public ResponseEntity<Session> newSession(@PathVariable String organisationName){
        return ResponseEntity.ok(moderatorService.newSession(organisationName));
    }

    @PostMapping("neworganisation")
    public ResponseEntity<Organisation> newOrganisation(@RequestBody Organisation organisationName){
        return ResponseEntity.ok(moderatorService.newOrganisation(organisationName));
    }
    //TODO: reduce boilercode


}
