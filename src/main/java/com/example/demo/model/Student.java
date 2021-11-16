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
    @GeneratedValue(strategy = SEQUENCE,
            generator = "id_sequence"
    )
    @Column(
            name = "id",
            nullable = false,
            updatable = false
    )

    private Long id;


    @Column(
        name = "question_id",
        columnDefinition = "int"

    )
    Integer question_id;

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", question_id=" + question_id +
                '}';
    }
}
