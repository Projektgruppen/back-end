package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Organisation} class represents a specific organisation organizing a session. A {@code Organisation}
 * object contains an automatically generated Id, a name, the organisation's current session and a list of all the
 * organisation's sessions.
 * <p></p>
 * <blockquote><pre>
 *     Organisation organisation = new Organisation("Example name");
 *     organisation.setId(0);
 *     organisation.setCurrentSession(0);
 *     organisation.setSessions(sessions);
 * </pre></blockquote>
 *
 * @author Johan Nissen Riedel
 * @see Session
 */
@Entity
@Table(name = "organisations")
public class Organisation {

    /**
     * Contains the id of the organisation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Contains the name of the organisation.
     */
    private String name;

    /**
     * Contains the id of the organisation's current session.
     */
    private long currentSession;

    /**
     * List containing the organisation's sessions.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "organisation")
    @JsonIgnore
    private List<Session> sessions = new ArrayList<>();


    /**
     * Initializes a newly created {@code Organisation} object with a given name.
     * @param name, a {code String} object containing the name of the organisation.
     */
    public Organisation(String name) {
        this.name = name;
    }
    public Organisation() {

    }

    /**
     * Getter for the current session.
     * @return the {@code Long} specifying the organisation's current session.
     */
    public long getCurrentSession() {
        return currentSession;
    }

    /**
     * Setter for the current session.
     * @param currentSession, a {@code Long} specifying the organisation's current session.
     */
    public void setCurrentSession(long currentSession) {
        this.currentSession = currentSession;
    }

    /**
     * Getter for the organisation's list of sessions.
     * @return a {@code List} of sessions belonging to the organisation.
     */
    public List<Session> getSessions() {
        return sessions;
    }

    /**
     * Setter for the organisation's list of sessions.
     * @param sessions, a {@code List} of sessions belonging to the organisation.
     */
    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    /**
     * Getter for the organisation's id.
     * @return a {@code Long} specifying the id of the organisation.
     */
    public long getId() {
        return id;
    }

    /**
     * Getter for the name of the organisation.
     * @return {}
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the name of the organisation.
     * @param name, a {@code String} object containing the name of the organisation.
     */
    public void setName(String name) {
        this.name = name;
    }
}
