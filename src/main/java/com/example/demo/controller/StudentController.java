package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.model.projection.QAStudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //makes it so that everyone can access the api Alternative use: origins = {"http://localhost:3000/"}
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //Check if message is approved.
    @GetMapping("{session}/questions")
    public List<QAStudentDTO> getAllApprovedQuestions(@PathVariable String session){
        return studentService.getApprovedQuestions(session);
    }

    //Create new message
    @PostMapping("{session}/question")
    public ResponseEntity<Question> createQuestion(@RequestBody Question question, @PathVariable String session){
        return ResponseEntity.ok(studentService.saveQuestion(question, session));
    }

}
