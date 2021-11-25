package com.example.demo;

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

    @Autowired private QuestionRepository questionRepository;
    @Autowired private AnswerRepository answerRepository;
    @Autowired private SessionRepository sessionRepository;
    @Autowired private OrganisationRepository organisationRepository;

    @Override
    public void run(String... args){

        //TODO: Remove this if no one has use for it.

        //Make organisation
        Organisation forsvaret = new Organisation("forsvaret");
        forsvaret.setCurrentSession(1);
        organisationRepository.save(forsvaret);
        Organisation politiet = new Organisation("politiet");
        politiet.setCurrentSession(2);
        organisationRepository.save(politiet);

        //Make Session
        Session forsvaretSession = new Session(forsvaret);
        sessionRepository.save(forsvaretSession);
        Session politietSession = new Session(politiet);
        sessionRepository.save(politietSession);

        //Make Questions
        Session testSession = sessionRepository.getOne((long)1);
        Question question = new Question("Spørgsmål 1", testSession);
        questionRepository.save(question);

        Session testSession2 = sessionRepository.getOne((long)2);
        Question question2 = new Question("Spørgsmål 2", testSession2);
        questionRepository.save(question2);

        Session testSession3 = sessionRepository.getOne((long)2);
        Question question3 = new Question("Spørgsmål 3", testSession3);
        questionRepository.save(question3);

        Session testSession4 = sessionRepository.getOne((long)2);
        Question question4 = new Question("Spørgsmål 4", testSession4);
        questionRepository.save(question4);

        Session testSession5 = sessionRepository.getOne((long)2);
        Question question5 = new Question("Spørgsmål 5", testSession5);
        questionRepository.save(question5);

        //Make Answers
        Answer answer = new Answer("svar 1");
        answerRepository.save(answer);
        Question foundQuestion = questionRepository.findById(1L).get();
        foundQuestion.setAnswer(answer);
        questionRepository.save(foundQuestion);

        Answer answer3 = new Answer("svar 3");
        answerRepository.save(answer3);
        Question foundQuestion3 = questionRepository.findById(3L).get();
        foundQuestion3.setAnswer(answer3);
        questionRepository.save(foundQuestion3);

        Answer answer4 = new Answer("svar 4");
        answerRepository.save(answer4);
        Question foundQuestion4 = questionRepository.findById(4L).get();
        foundQuestion4.setAnswer(answer4);
        questionRepository.save(foundQuestion4);

    }
}

