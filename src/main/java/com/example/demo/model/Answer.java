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
            columnDefinition = "TEXT"
    )
    private String answer;

    public Answer(){

    }

    public String getAnswer(){return answer;}

    public String setAnswer(String answer){return this.answer = answer;}

    public Long getId() {
        return id;
    }

}
