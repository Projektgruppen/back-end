package com.example.demo.controller;

import com.example.demo.model.QAMessage;
import com.example.demo.repository.MessageRepository;
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
    private MessageRepository messageRepository;

    //Check if message is unapproved.
    @GetMapping
    public List<QAMessage> getUnapprovedMessages(){
        return messageRepository.findUnapprovedMessage();
    }

    //Finds message by Id and set approve to true
    @PutMapping("{id}")
    public ResponseEntity<QAMessage> approveMessage(@PathVariable long id) {
        QAMessage approveQAMessage = messageRepository.findById(id).orElseThrow(( () -> new ResourceNotFoundException("QAMessage does not exist with id " + id)));

        approveQAMessage.setApprove(true);

        messageRepository.save(approveQAMessage);

        return ResponseEntity.ok(approveQAMessage);
    }
}
