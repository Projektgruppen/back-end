package com.example.demo.model;

/**
 * The {@code QAMessage} class represents a collection of one question and one answer. A {@code QAMessage} object contains
 * a question and an answer as well their associated Ids.
 *
 * This is an example of the creation of a {@code QAMessage} object.
 *
 * <blockquote><pre>
 *     QAMessage qaMessage = new QAMessage(0, "Example question");
 *     qaMessage.setAnswer("Example answer");
 *     qaMessage.setAnswerId(0);
 * </pre></blockquote>
 *
 * @author Johan Nissen Riedel
 */
public class QAMessage {
    /**
     * Contains the Id of the question.
     */
    private long question_id;

    /**
     * Contains the question.
     */
    private String question;

    /**
     * Contains the Id of the answer.
     */
    private long answer_id;

    /**
     * Contains the answer.
     */
    private String answer;

    /**
     * Initializes a newly created {@code QAMessage} object with a given questionId and question.
     * answer and answerId are not provided.
     * @param questionId, a {@code l} specifying the Id of the question.
     * @param question, a {@code String} object containing the question as text.
     */
    public QAMessage(long questionId, String question) {
        this.question_id = questionId;
        this.question = question;
    }

    /**
     * Setter for the answer
     * @param answer, a {@code String} object containing the answer as text.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Getter for the question id.
     * @return the {@code long} specifying the id of the question.
     */
    public long getQuestion_id() {
        return question_id;
    }

    /**
     * Setter for the question id.
     * @param questionId, a {@code l} specifying the id of the question.
     */
    public void setQuestion_id(long questionId) {
        this.question_id = questionId;
    }

    /**
     * Getter for the answer id.
     * @return the {@code long} specifying the id of the answer.
     */
    public long getAnswerId() {
        return answer_id;
    }

    /**
     * Setter for the answer id.
     * @param answerId, a {@code long} specifying the id of the answer.
     */
    public void setAnswerId(long answerId) {
        this.answer_id = answerId;
    }

    /**
     * Getter for the question.
     * @return the {@code String} object containing the question as text.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Getter for the answer.
     * @return the {@code String} object containing the answer as text.
     */
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
