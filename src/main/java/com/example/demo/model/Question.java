package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;
    private boolean approve;
    private boolean review;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    @JsonIgnore
    private Session session;

    //Constructors
    public Question(String question, boolean approve, boolean review, Session session) {
    this.question = question;
    this.approve = approve;
    this.review = review;
    this.session = session;
    }

    public Question() {
    }

    public Question(long l, String foo) {
    }

    //Methods
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public boolean isApprove() {
        return approve;
    }

    public boolean getApprove() {
        return approve;
    }

    public boolean isReview() {
        return review;
    }

    public void setReview(boolean review) {
        this.review = review;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", approve=" + approve +
                ", review=" + review +
                ", session=" + session +
                '}';
    }
}
