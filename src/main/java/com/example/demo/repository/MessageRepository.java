package com.example.demo.repository;

import com.example.demo.model.QAMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface MessageRepository extends JpaRepository<QAMessage,Long> {


    @Query(value = "SELECT * FROM QAMessage WHERE approve = true", nativeQuery = true)
    List<QAMessage> findApprovedMessages();
    //crud
}
