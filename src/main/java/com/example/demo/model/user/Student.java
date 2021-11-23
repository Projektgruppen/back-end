package com.example.demo.model.user;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Constructors
    public Student(){

    }

    //Methods
    public long getId() {
        return id;
    }
}
