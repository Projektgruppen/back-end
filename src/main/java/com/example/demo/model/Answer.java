package com.example.demo.model;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "Answer")
public class Answer {
    @Id
    @SequenceGenerator(
            name = "answer_id",
            sequenceName = "answer_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "answer_id"
    )
    @Column(
            name = "approve",
            columnDefinition = "BOOLEAN"
    )
    private boolean approve;
    @Column(
            name = "id",
            updatable = false,
            nullable = false
    )
    private Long id;

    @Column(
            name = "answer",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String answer;

    @Column(
            name ="question_id",
            nullable = false
    )
    private Integer question_id;

    @Column(
            name = "recruiter_id",
            updatable = false
    )

    private Integer recruiter_id;

    @Column(
            name = "time",
            nullable = false
    )

    private Date date;

    public Answer(){

    }

    public String getAnswer(){return answer;}
    public String setAnswer(String answerString){return this.answer = answer;}
    public Long getId() {
        return id;
    }
    public boolean isApprove() {
        return approve;
    }
    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "approve=" + approve +
                ", id=" + id +
                ", answer='" + answer + '\'' +
                ", question_id=" + question_id +
                ", recruiter_id=" + recruiter_id +
                ", date=" + date +
                '}';
    }
}
