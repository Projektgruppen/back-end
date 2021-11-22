package com.example.demo.model.user;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Constructors
    public Student(){

    }

    //Methods
    public Long getId() {
        return id;
    }
}
