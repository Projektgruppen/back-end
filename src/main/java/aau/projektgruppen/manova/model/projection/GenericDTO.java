package aau.projektgruppen.manova.model.projection;

/**
 * the class represents the very base of which data can be tranfered from the database to the front-end.
 * At its base, the transfered data always includes a question and its id. the class is not used directly, but in
 * stead serves as a super class for the implemented DTOs (Data Transfer Objects).
 *
 * <p>
 *     once created, data is not mutable, hence no Setters are provided.
 * </p>
 *
 * @author Tommy Grenaae
 * @see QAStudentDTO
 * @see QARecruiterDTO
 * @see QAModeratorDTO
 *
 */
public class GenericDTO {
    private long questionId;
    private String question;

    public GenericDTO(long questionId, String question) {
        this.questionId = questionId;
        this.question = question;
    }

    public long getQuestionId() {
        return questionId;
    }

    public String getQuestion() {
        return question;
    }
}
