package com.example.demo.model.user;

import javax.persistence.*;

@Entity
@Table(name = "recruiters")
public class Recruiter {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Constructors
    public Recruiter(){

    }

    //Methods
    public Long getId() {
        return id;
    }

}
