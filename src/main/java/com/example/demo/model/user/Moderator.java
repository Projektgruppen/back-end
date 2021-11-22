package com.example.demo.model.user;

import javax.persistence.*;

@Entity
@Table(name = "moderators")
public class Moderator {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Constructors
    public Moderator() {

    }

    //Methods
    public Long getId() {
        return id;
    }

}
