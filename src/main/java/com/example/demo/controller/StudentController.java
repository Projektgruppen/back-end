package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private QuestionRepository questionRepository;

    //Check if message is approved.
    @GetMapping
    public List<Question> getAllApprovedQuestions(){
        return questionRepository.getAllApprovedQuestions();
    }

    //Create new message
    @PostMapping()
    public Question createQuestion(@RequestBody Question question){
        return questionRepository.save(question);
    }

}
