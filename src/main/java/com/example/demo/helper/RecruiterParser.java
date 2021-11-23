package com.example.demo.helper;

import com.example.demo.model.QAMessage;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class RecruiterParser {

    public static List<QAMessage> parse(long id, QuestionRepository questionRepository){
        List<Collection> reviewedCollection = questionRepository.getReviewedQuestions(id);

        List<QAMessage> qaMessages = reviewedCollection.stream().map(line -> {

            String [] strings = Arrays.toString(line.toArray()).split(",");
            List<String> reviewAsString = Arrays.asList(strings);

            QAMessage qaMessage = new QAMessage(Long.parseLong(reviewAsString.get(0).substring(1)), reviewAsString.get(1).trim());
            qaMessage.setAnswerId(Long.parseLong(reviewAsString.get(0).substring(1)));
            qaMessage.setAnswer(reviewAsString.get(2).substring(0,reviewAsString.get(2).length() -1).trim());
            return qaMessage;
        }).toList();
        return qaMessages;
    }
}
