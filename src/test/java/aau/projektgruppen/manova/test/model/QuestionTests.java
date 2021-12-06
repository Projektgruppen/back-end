package aau.projektgruppen.manova.test.model;

import aau.projektgruppen.manova.model.Answer;
import aau.projektgruppen.manova.model.Question;
import aau.projektgruppen.manova.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link aau.projektgruppen.manova.model.Question} class
 *
 * @author Mathias Gigas
 */
class QuestionTests {

    private Question q;

    @BeforeEach
    void setup() {
        q = new Question();
    }

    @Test
    void constructor_given_string_returns_Question_with_String() {
        Session s = new Session();
        q = new Question("foo", s);
        assertEquals("foo", q.getQuestion());
    }

    @Test
    void constructor_given_null_as_session_throws_RuntimeException() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> q = new Question("foo", null)
                ,"Session possibly set as null");
        assertNotNull(thrown.getMessage());
    }

    @Test
    void constructor_given_null_as_question_throws_RuntimeException() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> q = new Question(null, new Session())
                ,"Question possibly set as null");
        assertNotNull(thrown.getMessage());
    }

    @Test
    void constructor_given_empty_question_throws_RuntimeException() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> q = new Question("", new Session())
                ,"Question possibly set as empty");
        assertNotNull(thrown.getMessage());
    }

    @Test
    void setSession_then_getSession() {
        Session expected, actual;
        expected = new Session();
        q.setSession(expected);
        actual = q.getSession();
        assertEquals(expected, actual);
    }

    @Test
    void getApprove_default_is_false() {
        assertFalse(q.getApprove());
    }

    @Test
    void isMarkedForReview_default_is_false() {
        assertFalse(q.isMarkedForReview());
    }

    @Test
    void getQuestion_default_is_not_null() {
        assertNotNull(q.getQuestion());
    }

    @Test
    void setQuestion_then_getQuestion() {
        q.setQuestion("foo");
        assertEquals("foo", q.getQuestion());
    }

    @Test
    void getId_default_is_not_negative() {
        assertFalse(q.getId() < 0);
    }

    @Test
    void setApproved_then_getApprove() {
        q.setApproved(true);
        assertTrue(q.getApprove());
    }

    @Test
    void setAnswer_then_getAnswer() {
        Answer expected, actual;
        expected = new Answer();
        q.setAnswer(expected);
        actual = q.getAnswer();
        assertEquals(expected, actual);
    }

    @Test
    void getTimeOfApproval_default_is_null_if_getApprove_is_false() {
        assertFalse(q.getApprove());
        assertNull(q.getTimeOfApproval());
    }

    @Test
    void setTimeOfApproval_then_getTimeOfApproval() {
        String expectedTime = LocalTime.now().toString();
        q.setTimeOfApproval(expectedTime);
        assertEquals(expectedTime, q.getTimeOfApproval());
    }

    @Test
    void getTimeOfApproval_is_not_null_if_getApprove_is_true() {
        q.setApproved(true);
        assertTrue(q.getApprove());
        assertNotNull(q.getTimeOfApproval());
    }

    // --- Further improvements not implemented --------------------------------
    // TODO: Maybe garden this later?
/*
    @Test
    void getTimestamp() {
        fail("Not Implemented");
    }

    @Test
    void getLikes() {
        fail("Not Implemented");
    }

    @Test
    void getStudent() {
        fail("Not Implemented");
    }
*/
}