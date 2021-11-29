package aau.projektgruppen.manova.model.projection;

public class QAStudentDTO {
    private String question;
    private String answer;

    public QAStudentDTO(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
    public QAStudentDTO(String question){
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
