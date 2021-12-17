package aau.projektgruppen.manova.model.projection;

/**
 * This class serves as a DTO (Data Transfer Object) between the database and the front-end, specifically transferring
 * data that a {@link aau.projektgruppen.manova.model.user.Moderator Moderator} should have access to. Beside the data from
 * {@link aau.projektgruppen.manova.model.projection.GenericDTO} (which this class extends) the {@code Moderator} needs
 * to know if a {@link aau.projektgruppen.manova.model.Question Question} is marked for review or not.
 *
 * <p>
 *     Once created, data is not mutable, hence no Setters are provided.
 * </p>
 *
 * @see GenericDTO
 * @see aau.projektgruppen.manova.model.user.Moderator Moderator
 * @see aau.projektgruppen.manova.model.Question Question
 */
public class QAModeratorDTO extends GenericDTO{
    private boolean markedForReview;

    public QAModeratorDTO(long questionId, String question, boolean markedForReview) {
        super(questionId, question);
        this.markedForReview = markedForReview;
    }

    public boolean isMarkedForReview() {return markedForReview;}
}
