package com.example.demo.controller;

//import com.example.demo.model.QAMessage;
//import com.example.demo.repository.MessageRepository;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.Session;
import com.example.demo.model.projection.QAModeratorDTO;
import com.example.demo.service.ModeratorService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/moderator")
public class ModeratorController {

    @Autowired
    private ModeratorService moderatorService;

    /**
     * Returns every unapproved question from a given session.
     * @param session, A {@code String} that contains the name of a session.
     * @return A {@code List} containing every approved question from a given organisation's session.
     */
    @GetMapping("{session}/questions")
    public List<QAModeratorDTO> getAllUnapprovedSessionQuestions(@PathVariable String session){
        try{
            return moderatorService.findUnapprovedSessionQuestions(session);
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No unapproved questions", e);
        }
    }

    //Check if message is unapproved.
    @GetMapping("questions")
    public List<QAModeratorDTO> getAllUnapprovedQuestions(){
        try {
            return moderatorService.findUnapprovedQuestions();
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No unapproved questions", e);
        }
    }

    //Finds message by Id and set approve to true
    @PutMapping("approve/{questionId}")
    public ResponseEntity<Question> approveQuestion(@PathVariable long questionId) {
        try {
            return ResponseEntity.ok(moderatorService.approveQuestion(questionId));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question Id not found" + questionId, e);
        }

    }

    /**
     * Uses a given id to identify a question and set approved to true.
     * @param questionId, A {@code long} specifying the id of the question.
     * @return A {@code ResponseEntity} containing a question.
     */
    @PutMapping("review/{questionId}")
    public ResponseEntity<Question> reviewQuestion(@PathVariable long questionId) {
        try {
            return ResponseEntity.ok(moderatorService.reviewQuestion(questionId));
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Question Id Not Found" + questionId, e);
        }
    }

    //Set session toggle value on/off
    @PutMapping("{organisationName}/toggle/{state}")
    public ResponseEntity<Session> toggleSession(@PathVariable String organisationName, @PathVariable String state) {
        try {
            return ResponseEntity.ok(moderatorService.toggleSession(organisationName,state));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provide correct organisation name", e);
        }
    }

    //Set session toggle value on/off
    @PutMapping("{organisationName}/autoreview/{state}")
    public ResponseEntity<Session> toggleAutoreview(@PathVariable String organisationName, @PathVariable String state) {
        try {
            return ResponseEntity.ok(moderatorService.toggleAutoreview(organisationName,state));
        } catch (NotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provide correct organisation name", e);
        }
    }

    @PostMapping("{organisationName}/newsession")
    public ResponseEntity<Session> newSession(@PathVariable String organisationName){
        try {
            return ResponseEntity.ok(moderatorService.newSession(organisationName));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Provide correct organisation name", e);
        }
    }

    @PostMapping("neworganisation")
    public ResponseEntity<Organisation> newOrganisation(@RequestBody Organisation organisationName){
        try{
            return ResponseEntity.ok(moderatorService.newOrganisation(organisationName));
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide correct organisation name", e);
        }
    }

}
