package com.example.demo.model;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organisation")
    private List<Session> sessions = new ArrayList<>();


    //Constructors
    public Organisation() {

    }

    //Methods
    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public long getId() {
        return id;
    }
}
