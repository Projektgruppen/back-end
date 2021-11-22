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
        Organisation forsvaret = new Organisation("Forsvaret");
        organisationRepository.save(forsvaret);
        Organisation politiet = new Organisation("Politiet");
        organisationRepository.save(politiet);

        //Make Session
        Session forsvaretSession = new Session(forsvaret);
        sessionRepository.save(forsvaretSession);
        Session politietSession = new Session(politiet);
        sessionRepository.save(politietSession);

        //Make Questions
        Session testSession = sessionRepository.getOne((long)1);
        Question question = new Question("Spørgsmål 1", true, true, testSession);
        questionRepository.save(question);

        Session testSession2 = sessionRepository.getOne((long)2);
        Question question2 = new Question("Spørgsmål 2", true, true, testSession2);
        questionRepository.save(question2);

        Session testSession3 = sessionRepository.getOne((long)2);
        Question question3 = new Question("Spørgsmål 3", true, true, testSession3);
        questionRepository.save(question3);

        Session testSession4 = sessionRepository.getOne((long)2);
        Question question4 = new Question("Spørgsmål 4", true, true, testSession4);
        questionRepository.save(question4);

        //Make Answers
        Answer answer = new Answer("Svar 1", questionRepository.getOne((long)1));
        answerRepository.save(answer);
        Answer answer2 = new Answer("Svar 2", questionRepository.getOne((long)2));
        answerRepository.save(answer2);
        Answer answer3 = new Answer("Svar 3", questionRepository.getOne((long)3));
        answerRepository.save(answer3);
        Answer answer4 = new Answer("Svar 4", questionRepository.getOne((long)4));
        answerRepository.save(answer4);

    }

}

