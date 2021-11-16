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
            name = "answer",
            nullable = false
    )
    private String answer;

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
    public String setAnswer(){return this.answer = answer;}

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", recruiter_id=" + recruiter_id +
                ", date=" + date +
                '}';
    }
}
