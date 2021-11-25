package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "organisations")
public class Organisation {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private long currentSession;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organisation")
    @JsonIgnore
    private List<Session> sessions = new ArrayList<>();


    //Constructors
    public Organisation(String name) {
        this.name = name;
    }
    public Organisation() {

    }

    //Methods


    public long getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(long currentSession) {
        this.currentSession = currentSession;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
