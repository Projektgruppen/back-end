package aau.projektgruppen.manova.model.projection;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * This class serves as a DTO (Data Transfer Object) between the database and the front-end, specifically transferring
 * data that a {@link aau.projektgruppen.manova.model.user.Student Student} should have access to. Beside the data from
 * {@link aau.projektgruppen.manova.model.projection.GenericDTO} (which this class extends) the {@code Student} needs
 * access to the {@link aau.projektgruppen.manova.model.Answer answers} that a
 * {@link aau.projektgruppen.manova.model.user.Recruiter Recruiter} has made to the different
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

    private String timeOfApprovalForQuestion;

    private String timeOfCreationForAnswer;

    public QAStudentDTO(long questionId, String question, String timeOfApprovalForQuestion, String answer, String timeOfCreationForAnswer) {
        super(questionId, question);
        this.timeOfApprovalForQuestion = timeOfApprovalForQuestion;
        this.answer = answer;
        this.timeOfCreationForAnswer = timeOfCreationForAnswer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getTimeOfApprovalForQuestion() {
        return timeOfApprovalForQuestion;
    }

    public String getTimeOfCreationForAnswer() {
        return timeOfCreationForAnswer;
    }

    @Override
    public String toString() {
        return "QAStudentDTO{" +
                "answer='" + answer + '\'' +
                ", timeOfCreationForQuestion='" + timeOfApprovalForQuestion + '\'' +
                ", timeOfCreationForAnswer='" + timeOfCreationForAnswer + '\'' +
                '}';
    }
}
