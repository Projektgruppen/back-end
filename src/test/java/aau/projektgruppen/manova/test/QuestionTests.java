package aau.projektgruppen.manova.test;

import aau.projektgruppen.manova.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTests {

    private Question q;

    @BeforeEach
    void setup() {
        q = new Question("Foo", null);
    }

    @Test
    void getQuestionNotNull() {
        assertNotNull(q.getQuestion());
    }

    @Test
    void setThenGetQuestion() {
        q.setQuestion("foo");
        assertEquals("foo", q.getQuestion());
    }

    @Test
    void getIdNotNull() {
        assertNotNull(q.getId());
    }

    @Test
    void getIdGreaterThanZero() {
        assertTrue(q.getId() > 0);
    }

    @Test
    void newQuestionWithNegativeIdThrowsNumberFormatException() {
        NumberFormatException thrown = assertThrows(NumberFormatException.class,
                () -> q = new Question("Foo", null)
                ,"ID was set to negative value!"); // In case no exception is thrown show this.
        assertNotNull(thrown.getMessage());
    }

    @Test
    void newQuestionWithNullQuestionThrowsIllegalStateException() {
        IllegalStateException thrown = assertThrows(IllegalStateException.class,
                () -> q = new Question(null, null)
                ,"Question was initialized with null!");
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getTimestampNotNull() {
        assertNotNull(null); // TODO: someone removed this method: q.getTimestamp());
    }

    @Test
    void getLikesNotLessThanZero() {
        assertFalse(true); // TODO: someone removed this method: q.getLikes() < 0);
    }

    @Test
    void isApproveReturnsFalseByDefault() {
        assertFalse(q.getApprove());
    }

    @Test
    void setApproveThenIsApproveReturnsTrue() {
        q.setApproved(true);
        assertTrue(q.getApprove());
    }

    @Test
    void getStudent_idNotLessThanZero() {
        assertFalse(true); // TODO: someone removed this method: q.getStudent_id() < 0);
    }
}