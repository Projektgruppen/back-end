package com.example.demo.repository;

import com.example.demo.model.QAMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface MessageRepository extends JpaRepository<QAMessage,Long> {

    //Students
    @Query(value = "SELECT * FROM QAMessage WHERE approve = true", nativeQuery = true)
    List<QAMessage> getAllApprovedQAMessages();

    //Moderators
    @Query(value = "SELECT * FROM QAMessage", nativeQuery = true)
    List<QAMessage> getAllUnapprovedQAMessages();

    //Recruiters!TODO add review
    @Query(value = "SELECT * FROM QAMessage WHERE review = true", nativeQuery = true)
    List<QAMessage> getAllNoneAnsweredApprovedQAMessages();


}
