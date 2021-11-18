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

    @Column(name = "student_id")
    private long student_id;

    @Column(name = "time_sent")
    private Date time_sent;

    @Column(name = "likes")
    private int likes;

    @Column(name = "answer_id")
    private Long answer_id;

    public Question() {
    }

    public Question(long id, String question) {
        this.id = id;
        this.question = question;
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

    public boolean isApprove() {
        return approve;
    }

    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    public Date getTimestamp() {
        return time_sent;
    }

    public int getLikes() {
        return likes;
    }

    public long getStudent_id() {
        return student_id;
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
