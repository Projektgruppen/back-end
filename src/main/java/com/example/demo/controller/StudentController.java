package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    //!TODO: Virker ikke skal omtænkes iforhold til ikke at sende ét objekt med alt info. Dette påvirker også frontend.
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    //Check if message is approved.
    @GetMapping("/getQ")
    public List<Question> getAllApprovedQuestions(){
        return questionRepository.getAllApprovedQuestions();
    }

    @GetMapping("/getA")
    public List<Answer> getAllAnswers(){return answerRepository.findAll();}

    //Create new message
    @PostMapping()
    public Question createQuestion(@RequestBody Question question){
        return questionRepository.save(question);
    }

}
