package com.example.demo.model;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity(name = "Moderator")
public class Moderator {
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
    Integer id;

    @Column(
        name = "question_id",
        columnDefinition = "int"
    )
    Integer question_id;

    @Column(
        name = "approve",
        columnDefinition = "BOOLEAN"
    )

    private boolean approve;

    public Integer getQuestion() {
        return question_id;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }


}
