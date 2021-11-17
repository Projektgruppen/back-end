package com.example.demo;

//import com.example.demo.model.QAMessage;
//import com.example.demo.repository.MessageRepository;
import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
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

    @Override
    public void run(String... args){

        //Test example 1
        Question questions = new Question();
        Answer answers = new Answer();


        questions.setQuestion("Hvor høj skal man være for at komme i forsvaret?");
        answers.setAnswer("167cm");
        questions.setApprove(true);
        questionRepository.save(questions);
        answerRepository.save(answers);

        /*
        //Test example 2
        QAMessage qaMessage2 = new QAMessage();
        qaMessage2.setQuestion("Hvilke våben skyder man med?");
        qaMessage2.setAnswer(null);
        qaMessage2.setApprove(true);
        messageRepository.save(qaMessage2);

         */

    }

}

