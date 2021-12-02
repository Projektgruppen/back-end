package aau.projektgruppen.manova.test.model;

import aau.projektgruppen.manova.model.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link aau.projektgruppen.manova.model.Answer} class
 *
 * @author Mathias Gigas
 */
class AnswerTests {

    private Answer a;

    @BeforeEach
    void setup() {
        a = new Answer();
    }

    @Test
    void constructor_given_string_returns_answer_with_string() {
        a = new Answer("foo");
        assertNotNull(a);
        assertEquals("foo", a.getAnswer());
    }

    @Test
    void constructor_given_null_throws_InstantiationException() {
        Exception ex = assertThrows(InstantiationException.class,
                () -> new Answer(null),
                "Answer object instantiated with NULL as String!");
        assertFalse(ex.getMessage().isEmpty());
    }

    @Test
    void constructor_given_empty_String_throws_InstantiationException() {
        Exception ex = assertThrows(InstantiationException.class,
                () -> new Answer(""),
                "Answer object instantiated with empty String!");
        assertFalse(ex.getMessage().isEmpty());
    }

    @Test
    void setAnswer_then_getAnswer() {
        a.setAnswer("foo!");
        assertEquals("foo!", a.getAnswer());
    }

    @Test
    void getId_default_is_not_negative() {
        assertFalse(a.getId() < 0);
    }

    @Test
    void getAnswer_default_is_not_null() {
        assertNotNull(a.getAnswer());
    }
}
