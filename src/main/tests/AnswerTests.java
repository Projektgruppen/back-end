import com.example.demo.model.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTests {

    private Answer a;

    @BeforeEach
    void setup() {
        a = new Answer();
    }

    @Test
    void setThenGetAnswer() {
        a.setAnswer("foo");
        assertEquals("foo", a.getAnswer());
    }

    @Test
    void getIdNotNull() {
        assertNotNull(a.getId());
    }

    @Test
    void getIdGreaterThanZero() {
        assertTrue(a.getId() > 0);
    }

    @Test
    void cannotSetNegativeID() {
        NumberFormatException thrown = assertThrows(NumberFormatException.class,
                () -> a.setId(-1L)
                ,"ID was set to negative value!"); // In case no exception is thrown show this.
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getAnswerNotNull() {
        a = new Answer();
        assertNotNull(a.getAnswer());
    }
}