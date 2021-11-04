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
    public void run(String... args) throws Exception {
        QAMessage qaMessage = new QAMessage();
        qaMessage.setQuestion("Hvor høj skal man være for at komme i forsvaret?");
        qaMessage.setAnswer("167cm");
        qaMessage.setApprove(true);
        messageRepository.save(qaMessage);

        QAMessage qaMessage2 = new QAMessage();
        qaMessage2.setQuestion("Hvilke våben skyder man med?");
        qaMessage2.setAnswer("");
        qaMessage2.setApprove(true);
        messageRepository.save(qaMessage2);

    }

}

