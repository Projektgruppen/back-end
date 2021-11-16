import com.example.demo.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionTests {

    private Session s;

    @BeforeEach
    void setup() {
        s = new Session();
    }

    @Test
    void getIdNotNull() {
        assertNotNull(s.getId());
    }

    @Test
    void getIdGreaterThanZero() {
        assertTrue(s.getId() > 0);
    }

    @Test
    void cannotSetNegativeID() {
        NumberFormatException thrown = assertThrows(NumberFormatException.class,
                () -> s.setId(-1L)
                ,"ID was set to negative value!"); // In case no exception is thrown show this.
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getOrgIdNotNull() {
        s = new Session();
        assertNotNull(s.getOrgId());
    }
}
