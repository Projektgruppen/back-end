package com.example.demo;

import com.example.demo.model.QAMessage;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void run(String... args){

        //Test example 1
        QAMessage qaMessage = new QAMessage();
        qaMessage.setQuestion("Hvor høj skal man være for at komme i forsvaret?");
        qaMessage.setAnswer("167cm");
        qaMessage.setApprove(true);
        messageRepository.save(qaMessage);

        //Test example 2
        QAMessage qaMessage2 = new QAMessage();
        qaMessage2.setQuestion("Hvilke våben skyder man med?");
        qaMessage2.setAnswer(null);
        qaMessage2.setApprove(true);
        messageRepository.save(qaMessage2);

        //Test example 2
        QAMessage qaMessage3 = new QAMessage();
        qaMessage3.setQuestion("SPAAAAM!!");
        qaMessage3.setAnswer(null);
        qaMessage3.setApprove(false);
        messageRepository.save(qaMessage3);

        //Test example 2
        QAMessage qaMessage4 = new QAMessage();
        qaMessage4.setQuestion("SPAAAAM!! 2");
        qaMessage4.setAnswer(null);
        qaMessage4.setApprove(false);
        messageRepository.save(qaMessage4);

    }

}

