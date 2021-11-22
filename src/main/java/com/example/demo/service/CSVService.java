package com.example.demo.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.helper.CSVHelper;


@Service
public class CSVService {

    @Autowired
    QuestionRepository qRepository;
    AnswerRepository aRepository;

    public ByteArrayInputStream load() {
        List<Question> questions = qRepository.findAll();
        List<Answer> answers = aRepository.findAll();

        ByteArrayInputStream in = CSVHelper.qaMessageToCSV(questions, answers);
        return in;
    }
}
