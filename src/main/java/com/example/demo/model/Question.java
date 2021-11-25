package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * The {@code Question} class represents a question that has been asked by a student. A {@code Question} object contains an
 * automatically generated Id, the question as text and booleans specifying whether the question has been approved and/or reviewed.
 * <p>
 *      The sessions which the question belongs to is defined according to the object {@link Session}.
 *
 * </p>
 *
 * This is an example of the creation of an {@code Question} object.
 *
 * <blockquote><pre>
 *     Question question = new Question();
 *     question.setQuestion("Example question");
 *     question.setApprove(False);
 *     question.setReview(False);
 * </pre></blockquote>
 *
 * @author Johan Nissen Riedel,
 * @see Answer
 * @see Session
 */
@Entity
@Table(name = "questions")
public class Question {

    /**
     * Contains the Id of the question.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Contains the question as text.
     */
    private String question;

    /**
     * Boolean specifying whether the question has been approved.
     */
    //TODO refactor to approved
    private boolean approve;

    /**
     * Boolean specifying whether the question has been marked for review.
     */
    //TODO refactor to markedForReview
    private boolean review;

    /**
     * Object that specifies which session the question belongs to.
     */
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "session_id", referencedColumnName = "id")
    @JsonIgnore
    private Session session;

    /**
     * Initializes a newly created {@code Question} object with a given question as text, information on whether the
     * question has been approved and/or reviewed and which session the question belongs to.
     * @param question, a {@code String} containing the question as text.
     * @param approve, a {@code Boolean} specifying whether the question has been approved.
     * @param review, a {@code Boolean} specifying whether the question has been marked for review.
     * @param session, a {@code Session} specifying which session the question belongs to.
     */
    public Question(String question, boolean approve, boolean review, Session session) {
    this.question = question;
    this.approve = approve;
    this.review = review;
    this.session = session;
    }

    public Question() {
    }

    public Question(long l, String foo) {
    }

    /**
     * Getter for the session which the question belongs to.
     * @return {@code Session}, an object specifying the session which the question belongs to.
     */
    public Session getSession() {
        return session;
    }

    /**
     * Setter for the session which the question belongs to.
     * @param session, the {@code Session} which the question belongs to.
     */
    public void setSession(Session session) {
        this.session = session;
    }

    //TODO merge identical functions isApprove and getApprove
    public boolean isApprove() {
        return approve;
    }

    public boolean getApprove() {
        return approve;
    }

    /**
     * Getter for the Boolean review, which specifies whether the question has been marked for review.
     * @return a {@code Boolean}, which specifies whether the question has been marked for review.
     */
    public boolean isReview() {
        return review;
    }

    /**
     * Setter for the Boolean review, which specifies whether the question has been marked for review.
     * @param review, a {@code Boolean} specifying whether the question has been marked for review.
     */
    public void setReview(boolean review) {
        this.review = review;
    }

    /**
     * Getter for the question as text.
     * @return a {@code String} containing the question as text.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Setter for the question as text.
     * @param question, a {@code String} containing the question as text.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Getter for the Id of the question.
     * @return a {@code Long} specifying the Id of a question.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for the Boolean approve, which specifies whether the question has been approved.
     * @param approve, a {@code Boolean} specifying whether the question has been approved.
     */
    public void setApprove(boolean approve) {
        this.approve = approve;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", approve=" + approve +
                ", review=" + review +
                ", session=" + session +
                '}';
    }
}
