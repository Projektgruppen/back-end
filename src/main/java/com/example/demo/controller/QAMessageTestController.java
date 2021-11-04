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
@RequestMapping("/api/v1/test")
public class QAMessageTestController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping
    public List<QAMessage> getAllStudents(){
        return messageRepository.findAll();
    }

    //Build create employee REST API
    @PostMapping
    public QAMessage createStudent(@RequestBody QAMessage QAMessage){
        return messageRepository.save(QAMessage);
    }

    //build get employee by id
    @GetMapping("{id}")
    public ResponseEntity<QAMessage> getStudentById(@PathVariable  long id){
        QAMessage QAMessage = messageRepository.findById(id).orElseThrow(( () -> new ResourceNotFoundException("QAMessage not exist with id " + id)));

        return ResponseEntity.ok(QAMessage);
    }

    //build update student REST API
    @PutMapping("{id}")
    public ResponseEntity<QAMessage> updateStudent(@PathVariable long id, @RequestBody QAMessage QAMessageDetails){
        QAMessage updateQAMessage = messageRepository.findById(id).orElseThrow(( () -> new ResourceNotFoundException("QAMessage does not exist with id " + id)));


        updateQAMessage.setQuestion((QAMessageDetails.getQuestion()));
        updateQAMessage.setAnswer((QAMessageDetails.getAnswer()));
        updateQAMessage.setApprove(QAMessageDetails.isApprove());

        messageRepository.save(updateQAMessage);

        return ResponseEntity.ok(updateQAMessage);
    }

    //Approve message
    @PutMapping("/approve/{id}")
    public ResponseEntity<QAMessage> approveMessage(@PathVariable String id){
        QAMessage approveQAMessage = messageRepository.findById(Long.parseLong(id)).orElseThrow(( () -> new ResourceNotFoundException("QAMessage does not exist with id" + id)));

        approveQAMessage.setApprove(true);

        messageRepository.save(approveQAMessage);

        return ResponseEntity.ok(approveQAMessage);
    }
}
