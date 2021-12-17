package aau.projektgruppen.manova.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The {@code Session} class represents a livestream session hosted by an organisation. A {@code Session} object contains
 * a name, an automatically generated id, booleans specifying whether the session is live or whether autoreview
 * has been enabled, a list of all questions and an organisation.
 * <p></p>
 *
 * This is an example of the creation of a {@code Session} object.
 * <blockquote><pre>
 *     Session session = new Session(organisation);
 *     session.setLive(False);
 *     session.setAutoReview(False);
 *     session.setQuestions(questions);
 * </pre></blockquote>
 *
 * @see Organisation
 * @see Question
 */
@Entity
@Table(name = "sessions")
public class Session {

    /**
     * Contains the session's id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Specifies whether the session is live.
     */
    private boolean live;

    /**
     * Specifies whether auto review has been enabled for the session.
     */
    private boolean autoReview;

    private final String timeOfCreation = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    /**
     * List containing every question in the session.
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "session")
    private List<Question> questions = new ArrayList<>();

    /**
     * Organisation object specifying which organisation the session belongs to.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "organisation_id", referencedColumnName = "id")
    @JsonIgnore
    private Organisation organisation;

    /**
     * Initializes a newly created {@code Session} object with a given organisation.
     * @param organisation, An {@code Organisation} object containing which organisation the session belongs to.
     */
    public Session(Organisation organisation) {
        this.organisation = organisation;
    }

    /**
     * Creates an empty Session object.
     */
    public Session() {

    }

    /**
     * Getter for the boolean specifying whether the session is live or not.
     * @return a {@code Boolean} specifying whether the session is live or not.
     */
    public boolean isLive() {
        return live;
    }

    /**
     * Setter for the boolean specifying whether the session is live.
     * @param live, A {@code Boolean} specifying whether the session is live.
     */
    public void setLive(boolean live) {
        this.live = live;
    }

    /**
     * Getter for the boolean specifying whether auto review has been enabled for the session.
     * @return {@code Boolean} specifying whether auto review has been enabled for the session.
     */
    public boolean isAutoReview() {
        return autoReview;
    }

    /**
     * Setter for the boolean specifying whether auto review has been enabled for the session.
     * @param autoReview, A {@code Boolean} specifying whether auto review has been enabled for the session.
     */
    public void setAutoReview(boolean autoReview) {
        this.autoReview = autoReview;
    }

    /**
     * Getter for the session's organisation.
     * @return {@code Organisation} specifying the organisation which the session belongs to.
     */
    public Organisation getOrganisation() {
        return organisation;
    }

    /**
     * Setter for the session's organisation.
     * @param organisation, An {@code Organisation} object that specifies which organisation the session belongs to.
     */
    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    /**
     * Getter for the list of questions in the session.
     * @return {@code List} containing all questions in the session.
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * Setter for the list of questions in the session.
     * @param questions, A {@code List} containing all questions in the session.
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Getter for the session's id.
     * @return {@code long} specifying the id of the session.
     */
    public long getId() {
        return id;
    }

}
