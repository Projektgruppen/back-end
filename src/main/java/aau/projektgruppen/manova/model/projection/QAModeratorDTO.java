package aau.projektgruppen.manova.model.projection;

public class QAModeratorDTO {
    private String question;
    private long questionId;
    private boolean markedForReview;

    public QAModeratorDTO(String question,long questionId, boolean markedForReview) {
        this.question = question;
        this.questionId = questionId;
        this.markedForReview = markedForReview;

    }

    public boolean isMarkedForReview() {return markedForReview;}

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
