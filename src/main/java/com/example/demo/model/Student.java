package com.example.demo.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Student")
public class Student {
    @Id
    @SequenceGenerator(
        name = "id_sequence",
        sequenceName = "id_sequence",
        allocationSize = 1
    )
    Integer id;
    @GeneratedValue(strategy = SEQUENCE,
        generator = "id_sequence"
    )
    @Column(
        name = "question",
        columnDefinition = "TEXT"

    )
    Integer question_id;

    public Integer getQuestion() {
        return question_id;
    }

    public void setQuestion(String question) {
        this.question_id = question_id;
    }

}
