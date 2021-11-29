package aau.projektgruppen.manova.model.projection;

public class QAModeratorDTO {
    private String question;
    private long questionId;

    public QAModeratorDTO(String question,long questionId) {
        this.question = question;
        this.questionId = questionId;

    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
}
