package com.example.demo.controller;

import com.example.demo.model.QAMessage;
import com.example.demo.repository.MessageRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/recruiters")
public class RecruiterController {

    @Autowired
    private MessageRepository messageRepository;

    //Check if message is approved.
    @GetMapping
    public List<QAMessage> getAllReviewedQAMessages(){
        return messageRepository.getAllReviewedQAMessages();
    }

    @PutMapping("{id}")
    public ResponseEntity<QAMessage> updateQAMessageAnswer(@PathVariable long id, @RequestBody String answer) throws JSONException {
        QAMessage updateQAMessageAnswer = messageRepository.findById(id).orElseThrow(( () -> new ResourceNotFoundException("QAMessage does not exist with id " + id)));

        JSONObject answerObj = new JSONObject(answer);
        String answerString = (String) answerObj.get("a");

        updateQAMessageAnswer.setAnswer(answerString);

        messageRepository.save(updateQAMessageAnswer);

        return ResponseEntity.ok(updateQAMessageAnswer);
    }

}
