package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "answers")
public class Answer {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;

    @OneToOne
    private Question question;

    //Constructors
    public Answer(String answer, Question question){
    this.answer = answer;
    this.question = question;
    }

    public Answer() {

    }

    //Methods
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getAnswer(){return answer;}

    public String setAnswer(String answer){return this.answer = answer;}


    public Long getId() {
        return id;
    }

}
