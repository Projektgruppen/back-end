package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private QuestionRepository testRepo;

    @GetMapping("test")
    public Answer getTest(){
        return testRepo.findUserByStatus((long)1);
    }

    //Check if message is approved.
    @GetMapping("/{organisationName}")
    public List<Collection> getAllApprovedQuestions(@PathVariable String organisationName){
        return studentService.getApprovedQuestions(organisationName);
    }

    //Create new message
    @PostMapping()
    public Question createQuestion(@RequestBody Question question){
        return null;
    }

}
