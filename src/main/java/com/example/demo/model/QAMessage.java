package com.example.demo.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "QAMessage")
public class QAMessage {
    @Id
    @SequenceGenerator(
            name = "id_sequence",
            sequenceName = "id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = SEQUENCE,
                    generator = "id_sequence"
    )

    @Column(
            name = "id",
            updatable = false
    )
    private Long id;

    @Column(
            name = "approve",
            columnDefinition = "BOOLEAN"
    )
    private boolean approve;

    @Column(
            name = "review",
            columnDefinition = "BOOLEAN"
    )
    private boolean review;


    @Column(
            name = "question",
            nullable = false,
            columnDefinition = "TEXT"

    )
    private String question;

    @Column(
            name = "answer",
            columnDefinition = "TEXT"

    )
    private String answer;

    public QAMessage() {

    }

    public QAMessage(Long id, boolean approve, boolean review, String question, String answer) {
        this.id = id;
        this.approve = approve;
        this.review = review;
        this.question = question;
        this.answer = answer;
    }

    public boolean isReview() {
        return review;
    }

    public void setReview(boolean review) {
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    @Override
    public String toString() {
        return "QAMessage{" +
                "id=" + id +
                ", approve=" + approve +
                ", review=" + review +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
