package com.example.demo.model.user;

import javax.persistence.*;

@Entity
@Table(name = "moderators")
public class Moderator {
    //Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Constructors
    public Moderator() {

    }

    //Methods
    public long getId() {
        return id;
    }

}
