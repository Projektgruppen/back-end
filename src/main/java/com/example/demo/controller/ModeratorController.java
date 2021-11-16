package com.example.demo.controller;

import com.example.demo.model.QAMessage;
import com.example.demo.repository.MessageRepository;
import com.example.demo.service.ModeratorService;
import org.apache.velocity.exception.ResourceNotFoundException;
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

    //Check if message is unapproved.
    @GetMapping

    public List<QAMessage> getALlUnapprovedQAMessages(){
        return moderatorService.getAllUnapprovedQAMessages();
    }

    //Finds message by Id and set approve to true
    @PutMapping("approve/{id}")
    public ResponseEntity<QAMessage> approve(@PathVariable long id) {
        return ResponseEntity.ok(moderatorService.approveAndReviewQAMessage(id));
    }

    //When we review we dont do anyting else
    @PutMapping("review/{id}")
    public ResponseEntity<QAMessage> review(@PathVariable long id) {
        return ResponseEntity.ok(moderatorService.reviewQAMessage(id));
    }
}
