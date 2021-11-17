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
            name = "answer",
            columnDefinition = "TEXT"
    )
    private String answer;

    @Column(
            name ="question_id"
    )
    private Integer question_id;

    @Column(
            name = "recruiter_id",
            updatable = false
    )

    private Integer recruiter_id;

    @Column(
            name = "time"
    )

    private Date date;

    public Answer(){

    }

    public Answer(long id) {
        this.id = id;
    }

    public String getAnswer(){return answer;}
    public String setAnswer(String answer){return this.answer = answer;}
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
