package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * The {@code Answer} class represents an answer to question asked by a student. A {@code Answer} object contains an
 * automatically generated Id, the answer as a String and which question it belongs to.
 * <p></p>
 *
 * This is an example of the creation of an {@code Answer} object.
 *
 * <blockquote><pre>
 *     Answer answer = new Answer();
 *     answer.setAnswer("Example answer");
 *     answer.setQuestion(question);
 * </pre></blockquote>
 *
 * @author Johan Nissen Riedel,
 * @see Question
 */
@Entity
@Table(name = "answers")
public class Answer {

    /**
     * Contains the Id of the answer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Contains the answer as a String.*/
    private String answer;

    /**
     * Contains the question, which the answer belongs to.
     *
     */
    @OneToOne
    @JsonIgnore
    private Question question;

    /**
     * Initializes a newly created {@code Answer} object with a given answer {@code String} and {@link Question} object.
     * Id is not provided.
     * @param answer, a {@code String} object containing the answer text as a {@code String}.
     * @param question, a {@code Question} object which the answer belongs to.
     */
    //Constructors
    public Answer(String answer, Question question){
    this.answer = answer;
    this.question = question;
    }

    public Answer() {

    }

    /**
     * Getter for the question belonging to the answer.
     * @return the {@code Question} belonging to the answer.
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * Setter for the question belonging to the answer.
     * @param question, a {@code Question} belonging to the answer.
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

    /**
     * Getter for the answer text belonging to the answer object.
     * @return the {@code answer} text of the answer.
     */
    public String getAnswer(){return answer;}

    /**
     * Setter for the answer text belonging to the answer object.
     * @param answer, a {@code String} containing the answer as text.
     */
    public String setAnswer(String answer){return this.answer = answer;}

    /**
     * Getter for the Id belonging to the answer object.
     * @return a {@code Long} specifying the Id of an answer.
     */
    public long getId() {
        return id;
    }

}
