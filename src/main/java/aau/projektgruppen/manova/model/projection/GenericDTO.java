package aau.projektgruppen.manova.model.projection;

/**
 * The {@code GenericDTO} class represents the very base of which data can be transferred from the database to the front-end.
 * At its base, the transferred data always includes a question and its id. The class is not used directly, but
 * instead serves as a super class for the implemented DTOs (Data Transfer Objects).
 *
 * <p>
 *     Once created, data is not mutable, hence no Setters are provided.
 * </p>
 * This is an example of the creation of a {@code GenericDTO} object.
 *
 * <blockquote><pre>
 *     GenericDTO genericDTO = new GenericDTO(id, question);
 * </pre></blockquote>
 *
 * @see QAStudentDTO
 * @see QARecruiterDTO
 * @see QAModeratorDTO
 *
 */
public class GenericDTO {
    private long questionId;
    private String question;

    /**
     * Initializes a newly created {@code GeneriCDTO} object with a given question id and question String.
     * @param questionId
     * @param question
     */
    public GenericDTO(long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    /**
     * Getter for the Id belonging to the question.
     * @return a {@code long} specifying the Id of the question.
     */
    public long getQuestionId() {
        return questionId;
    }

    /**
     * Getter for the question as text.
     * @return A {@code String} containing the question as text.
     */
    public String getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "GenericDTO{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                '}';
    }
}
