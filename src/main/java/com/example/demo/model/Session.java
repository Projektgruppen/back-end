package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean live;

    private boolean autoReview;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "session")
    private List<Question> questions = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    @JsonIgnore
    private Organisation organisation;

    //Constructors
    public Session(Organisation organisation) {
        this.organisation = organisation;
    }
    public Session() {

    }

    //Methods


    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isAutoReview() {
        return autoReview;
    }

    public void setAutoReview(boolean autoReview) {
        this.autoReview = autoReview;
    }

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

}
