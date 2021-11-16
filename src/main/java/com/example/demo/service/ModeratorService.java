package com.example.demo.service;

import com.example.demo.model.QAMessage;
import com.example.demo.repository.MessageRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeratorService {

    @Autowired
    MessageRepository messageRepository;

    //Reviews a QAMessage from id
    public QAMessage reviewQAMessage(Long id){
        QAMessage qaMessage = findByID(id);
        qaMessage.setReview(true);
        messageRepository.save(qaMessage);
        return qaMessage;
    }

    //Approves and Reviews a QAMessage from id
    public QAMessage approveAndReviewQAMessage(Long id){
        QAMessage qaMessage = findByID(id);
        qaMessage.setApprove(true);
        qaMessage.setReview(true);
        messageRepository.save(qaMessage);
        return qaMessage;
    }

    //Finds QAMessage by id
    private QAMessage findByID(Long id){
        return messageRepository.findById(id).orElseThrow(( () -> new ResourceNotFoundException("QAMessage does not exist with id " + id)));
    }
    //Calls messageRepo to return all unapproved messages
    public List<QAMessage> getAllUnapprovedQAMessages(){
        return messageRepository.getAllUnapprovedQAMessages();
    }

}
