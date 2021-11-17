package com.example.demo.controller;

import com.example.demo.model.Moderator;
//import com.example.demo.model.QAMessage;
//import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.ModeratorRepository;
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
    private ModeratorRepository moderatorRepository;

    //Check if message is unapproved.
    @GetMapping
    public List<Moderator> getAllUnapprovedQAMessages(){
        return moderatorRepository.getAllUnapprovedQAMessages();
    }

    //Finds message by Id and set approve to true
    @PutMapping("{id}")
    public ResponseEntity<Moderator> approveQuestion(@PathVariable long id) {
        Moderator approveQuestion = moderatorRepository.findById(id).orElseThrow(( () -> new ResourceNotFoundException("Question does not exist with id " + id)));

        approveQuestion.setApprove(true);

        moderatorRepository.save(approveQuestion);

        return ResponseEntity.ok(approveQuestion);
    }
}
