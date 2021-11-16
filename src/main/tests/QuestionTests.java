import com.example.demo.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTests {

    private Question q;

    @BeforeEach
    void setup() {
        q = new Question();
    }

    @Test
    void getQuestionNotNull() {
        q = new Question();
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
    void cannotSetNegativeID() {
        NumberFormatException thrown = assertThrows(NumberFormatException.class,
                () -> q.setId(-1L)
                ,"ID was set to negative value!"); // In case no exception is thrown show this.
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getTimestampNotNull() {
        assertNotNull(q.getTimestamp());
    }

    @Test
    void getLikesNotLessThanZero() {
        assertFalse(q.getLikes < 0);
    }
}
