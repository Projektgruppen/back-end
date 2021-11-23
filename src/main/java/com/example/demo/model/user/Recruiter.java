package com.example.demo.model.user;

import javax.persistence.*;

@Entity
@Table(name = "recruiters")
public class Recruiter {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Constructors
    public Recruiter(){

    }

    //Methods
    public long getId() {
        return id;
    }

}
