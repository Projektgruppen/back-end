package com.example.demo;

//import com.example.demo.model.QAMessage;
//import com.example.demo.repository.MessageRepository;
import com.example.demo.model.Answer;
import com.example.demo.model.Organisation;
import com.example.demo.model.Question;
import com.example.demo.model.Session;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.OrganisationRepository;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.repository.SessionRepository;
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
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private OrganisationRepository organisationRepository;

    @Override
    public void run(String... args){

        //Make organisation
        Organisation organisation = new Organisation();
        organisationRepository.save(organisation);

        //Make Session
        Session session = new Session(organisation);
        sessionRepository.save(session);

        //Make Questions
        Session testSession = sessionRepository.getOne((long)1);
        Question question = new Question("Hejsa", true, true, testSession);
        questionRepository.save(question);

        Session testSession2 = sessionRepository.getOne((long)1);
        Question question2 = new Question("Hejsa2", true, true, testSession2);
        questionRepository.save(question2);

        //Make Answers
        Answer answer = new Answer("hej med dig", questionRepository.getOne((long)1));
        answerRepository.save(answer);

    }

}

