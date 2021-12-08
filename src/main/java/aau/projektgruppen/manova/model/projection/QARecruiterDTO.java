package aau.projektgruppen.manova.model.projection;

/**
 * This class serves as a DTO (Data Transfer Object) between the database and the front-end, specifically transferring
 * data that a {@link aau.projektgruppen.manova.model.user.Recruiter Recruiter} should have access to.
 * the data from {@link aau.projektgruppen.manova.model.projection.GenericDTO} (which this class extends) is all the
 * {@code Recruiter} needs access to which is why no extra fields are added to this class.
 *
 * <p>
 *     Once created, data is not mutable, hence no Setters are provided.
 * </p>
 *
 * @author Tommy Grenaae
 * @see GenericDTO
 */

public class QARecruiterDTO extends GenericDTO {

    public QARecruiterDTO(long questionId, String question) {
        super(questionId, question);
    }
}
