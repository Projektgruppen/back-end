package com.example.demo.model;

public class QAMessage {
    private long question_id;

    private String question;

    private long answer_id;

    private String answer;

    public QAMessage(long questionId, String question) {
        this.question_id = questionId;
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(long questionId) {
        this.question_id = questionId;
    }

    public long getAnswerId() {
        return answer_id;
    }

    public void setAnswerId(long answerId) {
        this.answer_id = answerId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "QAMessage{" +
                "question_id=" + question_id +
                ", question='" + question + '\'' +
                ", answer_id=" + answer_id +
                ", answer='" + answer + '\'' +
                '}';
    }
}
