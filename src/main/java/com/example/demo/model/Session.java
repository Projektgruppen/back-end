package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "Session")
public class Session {
    @Id
    @SequenceGenerator(
            name = "session_id_sequence",
            sequenceName = "session_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "session_id_sequence"
    )

   @Column(
           name = "id",
           updatable = false
   )
    private Long id;

    @Column(
            name = "organisation_id",
            insertable = false,
            updatable = false
    )
    private Long organisation_id;

    /*@ManyToOne
    private Organisation organisation;*/

    @OneToMany
    private Set<Question> questions;

    @OneToMany
    private Set<Student> students;

    @ManyToOne
    private Moderator moderator;



    public Session() {}

    public Session(long id) {
        this.id = id;
    }


    public long getId() {
        return id;
    }

    public long getOrgId() {
        return organisation_id;
    }
}
