package aau.projektgruppen.manova.model.projection;

/**
 * this class serves as a DTO (Data Transfer Object) between the database and the front-end, specifically transfering
 * data that a {@link aau.projektgruppen.manova.model.user.Student Student} should have access to. Besides the data from
 * {@link aau.projektgruppen.manova.model.projection.GenericDTO} (which this class extends) the {@code Student} needs
 * access to the {@link aau.projektgruppen.manova.model.Answer answers} that a
 * {@link aau.projektgruppen.manova.model.user.Recruiter Recruiter} have made to the different
 * {@link aau.projektgruppen.manova.model.Question questions}.
 *
 * <p>
 *     Once created, data is not mutable, hence no Setters are implemented.
 * </p>
 *
 * @author Tommy Grenaae
 * @see GenericDTO
 * @see aau.projektgruppen.manova.model.user.Student Student
 * @see aau.projektgruppen.manova.model.Answer Answer
 * @see aau.projektgruppen.manova.model.Question Question
 * @see aau.projektgruppen.manova.model.user.Recruiter Recruiter
 */
public class QAStudentDTO extends GenericDTO {
    private String answer;

    public QAStudentDTO(long questionId, String question, String answer) {
        super(questionId, question);
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

}
