package com.example.demo.model.projection;

public class QARecruiterDTO {
    private String question;
    private String answer;
    private long questionId;
    private long answerId;

    public QARecruiterDTO(String question, String answer, long questionId, long answerId) {
        this.question = question;
        this.answer = answer;
        this.questionId = questionId;
        this.answerId = answerId;
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

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}
