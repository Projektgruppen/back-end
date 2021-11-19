package com.example.demo.model;
import javax.persistence.*;
import java.util.Date;

@Entity(name = "Question")
public class Question {
    @Id
    @SequenceGenerator(name ="question_id", sequenceName = "question_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_id")
    @Column(name="id", updatable = false, nullable = false)
    private long id;

    @Column(name="question", columnDefinition = "TEXT")
    private String question;

    @Column(name = "approve", columnDefinition = "BOOLEAN")
    private boolean approve;

    @OneToOne
    @JoinColumn(name = "answer",referencedColumnName = "answer")
    private Answer answer;

    @ManyToOne
    private Session session;

    public Question() {
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public boolean getApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }
    
}
