package com.example.demo.controller;


import com.example.demo.model.QAMessage;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private MessageRepository messageRepository;

    //Check if message is approved.
    @GetMapping
    public List<QAMessage> getAllApprovedQAMessages(){
        return messageRepository.getAllApprovedQAMessages();
    }

    //Create new message
    @PostMapping
    public QAMessage createQAMessage(@RequestBody QAMessage qaMessage){
        return messageRepository.save(qaMessage);
    }

}
