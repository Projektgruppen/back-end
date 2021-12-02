package aau.projektgruppen.manova.test.model;

import aau.projektgruppen.manova.model.Organisation;
import aau.projektgruppen.manova.model.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link aau.projektgruppen.manova.model.Organisation} class
 *
 * @author Mathias Gigas
 */
public class OrganisationTests {

    Organisation o;

    @BeforeEach
    void setup() {
        o = new Organisation();
    }

    @Test
    void constructor_given_null_as_name_throws_RuntimeException() {
        RuntimeException thrown = assertThrows(RuntimeException.class,
                () -> new Organisation(null),
                "Organisation possibly created with null name");
        assertNotNull(thrown.getMessage());
    }

    @Test
    void getCurrentSession_default_is_null() {
        assertNull(o.getCurrentSession());
    }

    @Test // FIXME: Why is this a long and not a session object?
    void setCurrentSession_then_getCurrentSession() {
/*    Expected behavior:
        Session expected = new Session();
        o.setCurrentSession(expected);
        assertEquals(expected, o.getCurrentSession());
 */// Actual behavior:
        o.setCurrentSession(100);
        assertEquals(100, o.getCurrentSession());

        // TODO: Delete me.
        fail("CurrentSession uses longs, is this expected behavior?");
    }

    @Test
    void setSessions_then_getSessions_returns_list() {
        List<Session> sList = Arrays.asList(
                new Session(),
                new Session(),
                new Session());

        o.setSessions(sList);
        assertEquals(sList.get(0), o.getSessions().get(0));
        assertEquals(sList.get(1), o.getSessions().get(1));
        assertEquals(sList.get(2), o.getSessions().get(2));
    }

    @Test
    void getId_default_is_not_negative() {
        assertFalse(o.getId() < 0);
    }

    @Test
    void getName_default_is_not_null_and_not_empty() {
        assertNotNull(o.getName());
        assertFalse(o.getName().isEmpty());
    }

    @Test
    void setName_then_getName_returns_name() {
        o.setName("foo");
        assertEquals("foo", o.getName());
    }
}
