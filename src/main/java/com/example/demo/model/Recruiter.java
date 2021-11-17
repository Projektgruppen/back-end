package com.example.demo.model;


import javax.persistence.*;

@Entity(name = "Recruiter")
public class Recruiter {
    @Id
    @SequenceGenerator(
            name = "recruiter_id",
            sequenceName = "recruiter_id",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "recruiter_id"
    )

    @Column(
            name = "id",
            updatable = false
    )

    private Long id;

    @Column(
            name = "answer_id"
    )

    private Integer answer_id;

    public Integer getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(Integer answer_id) {
        this.answer_id = answer_id;
    }

    public Long getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Recruiter{" +
                "id=" + id +
                ", answer_id=" + answer_id +
                '}';
    }
}
