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
            updatable = false,
            nullable = false
    )
            private Long id;

    @Column(
            name="question",
            nullable = false,
            columnDefinition = "TEXT"
    )

    private String question;

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public Integer getQuestion_id() {
        return question_id;
    }


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", aproove='" + approve +
                ", student_id=" + student_id +
                ", time_sent=" + time_sent +
                ", likes=" + likes +
                '}';
    }
}
