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
    private Long id;

    private boolean approve;

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Moderator{" +
                "id=" + id +
                ", approve=" + approve +
                '}';
    }
}
