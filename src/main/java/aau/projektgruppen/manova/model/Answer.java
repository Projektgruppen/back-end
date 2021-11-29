package aau.projektgruppen.manova.model;

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
     * Contains the id of the answer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Contains the answer as a String.*/
    private String answer;

    /**
     * Initializes a newly created {@code Answer} object with a given answer {@code String} and {@link Question} object.
     * Id is not provided.
     * @param answer, A {@code String} object containing the answer text as a {@code String}.
     */
    public Answer(String answer){
    this.answer = answer;
    }

    /**
     * Creates an empty {@code Answer} object.
     */
    public Answer() {

    }

    /**
     * Getter for the answer text belonging to the answer object.
     * @return the {@code answer} text of the answer.
     */
    public String getAnswer(){return answer;}

    /**
     * Setter for the answer text belonging to the answer object.
     * @param answer, A {@code String} containing the answer as text.
     */
    public void setAnswer(String answer){
        this.answer = answer;
    }

    /**
     * Getter for the Id belonging to the answer object.
     * @return a {@code long} specifying the Id of an answer.
     */
    public long getId() {
        return id;
    }
}
