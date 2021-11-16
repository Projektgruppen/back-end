package com.example.demo.model;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "Question")
public class Question {
    @Id
    @SequenceGenerator(
        name ="question_id",
        sequenceName = "question_id",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                generator = "question_id"
    )

    @Column(
            name="id",
            updatable = false
    )
            private Long id;

    @Column(
            name="question",
            nullable = false
    )

    private String question;

    @Column(
            name = "student_id",
            nullable = false
    )

    private Integer student_id;

    @Column(
            name = "time_sent",
            nullable = false
    )

    private Date time_sent;

    @Column(
            name = "likes"
    )
    private Integer likes;



}
