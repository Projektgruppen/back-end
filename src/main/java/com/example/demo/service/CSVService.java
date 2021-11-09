package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.helper.CSVHelper;
import com.example.demo.repository.MessageRepository;
import com.example.demo.model.QAMessage;

@Service
public class CSVService {

    @Autowired
    MessageRepository repository;

    public ByteArrayInputStream load() {
        List<QAMessage> qaMessages = repository.findAll();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(qaMessages);
        return in;
    }
}
