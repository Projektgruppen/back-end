import com.example.demo.model.QAMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.tree.ExpandVetoException;

import static org.junit.jupiter.api.Assertions.*;

class QAMessageTests {

    private QAMessage m;

    @BeforeEach
    void setup() {
        m = new QAMessage(10L, "Foo", "Bar");
    }

    /*@Test(expected = IllegalStateException.class)
    void contructorNullArgsThrowsIllegalStateException() {
        // assert exception is thrown
    }*/

    @Test
    void cannotSetNegativeID() {
        NumberFormatException thrown = assertThrows(NumberFormatException.class,
                () -> m.setId(-1L)
                ,"ID was set to negative value!"); // In case no exception is thrown show this.
    }

    @Test
    void getIdNotNull() {
        assertNotNull(m.getId());
    }

    @Test
    void getId() {
        assertEquals(10L, m.getId());
    }

    @Test
    void setId() {
        long expected = 15L;
        m.setId(expected);

        assertEquals(expected, m.getId());
    }

    @Test
    void getQuestionNotNull() {
        m = new QAMessage();
        assertNotNull(m.getQuestion());
    }

    @Test
    void getQuestion() {
        assertEquals("Foo", m.getQuestion());
    }

    @Test
    void setQuestion() {
        m.setQuestion("Foo!?");
        assertEquals("Foo!?", m.getQuestion());
    }

    @Test
    void getAnswerNotNull() {
        m = new QAMessage();
        assertNotNull(m.getAnswer());
    }

    @Test
    void getAnswer() {
        assertEquals("Bar", m.getAnswer());
    }

    @Test
    void setAnswer() {
        m.setAnswer("Baz");
        assertEquals("Baz", m.getAnswer());
    }

    @Test
    void isApproveDefaultFalse() {
        assertFalse(m.isApprove());
    }

    @Test
    void setApprove() {
        m.setApprove(true);
        assertTrue(m.isApprove());
    }
}